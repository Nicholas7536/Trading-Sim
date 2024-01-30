import java.util.HashMap;

public abstract class PriceFactory {

    private static final int MAP_LIMIT = 1000;
    private static HashMap<Integer, Price> prices = new HashMap<>();
    private static HashMap<Integer, Long> lastUsed = new HashMap<>();

    public static Price makePrice(int totalCents) {
        if(!prices.containsKey(totalCents)) {
            // Check if at size limit
            // if so, remove oldest element (lastused)
            prices.put(totalCents, new Price(totalCents));
        }
        lastUsed.put(totalCents,System.currentTimeMillis());
        return prices.get(totalCents);
    }

    public static Price makePrice(String dollar) throws InvalidPriceOperation {
        boolean isNegative = false;

        // Get rid of dollar sign and commas in the string
        dollar = dollar.replaceAll("[$,]", "");
        if (dollar.startsWith("-")) {
            isNegative = true;
            dollar = dollar.substring(1);
        }
        if (!dollar.matches("^(\\d+)?(\\.\\d{2})?$")) {
            throw new InvalidPriceOperation("Invalid String for makePrice: " + dollar);
        }

        // Splice string - Everything before "." decimal is stored in int dollars
        // Everything after "." decimal is saved in int cents
        String[] parts = dollar.split("\\.");
        int dollars;
        if (parts.length > 0 && !parts[0].isEmpty()) {
            dollars = Integer.parseInt(parts[0]);
        } else {
            dollars = 0;
        }
        int cents;
        if (parts.length > 1) {
            cents = Integer.parseInt(parts[1]);
        } else {
            cents = 0;
        }

        // Calculate the total cents and apply the negative sign if necessary
        int totalCents = dollars * 100 + cents;
        if (isNegative) {
            totalCents = -totalCents;
        }


        //Flyweight design pattern update
        if(!prices.containsKey(totalCents)) {
            // Check if at size limit
            // if so, remove the oldest element (lastused)
            prices.put(totalCents, new Price(totalCents));
        }
        lastUsed.put(totalCents,System.currentTimeMillis());
        return prices.get(totalCents);
    }





}
