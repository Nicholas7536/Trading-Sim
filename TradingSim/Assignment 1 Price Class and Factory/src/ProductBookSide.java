import java.awt.print.Book;
import java.util.ArrayList;
import java.util.HashMap;

public class ProductBookSide {
    private final BookSide side;

    private final HashMap<Price, ArrayList<Order>> bookEntries;

    public ProductBookSide(BookSide side, HashMap<Price, ArrayList<Order>> bookEntries) throws InvalidOrderValue {
        // Validate side
        if (side == null) {
            throw new InvalidOrderValue("Side cannot be null");
        }
        this.side = side;
        this.bookEntries = bookEntries;
    }

    public OrderDTO add(Order o) {
        OrderDTO dto = o.makeTradableDTO();
        if(!bookEntries.containsKey(dto.price)) {
            bookEntries.put(dto.price, new ArrayList<Order>());
        }
        ArrayList<Order> orders = bookEntries.get(dto.price);
        orders.add(o);
        System.out.println("ADD: " + dto.side + ": " + dto.toString());
        return dto;
    }

    public OrderDTO cancel(String orderId) {

        for (Price price : bookEntries.keySet()) {
            ArrayList<Order> orders = bookEntries.get(price);

            for (Order order : orders) {

                // If order is found in hashmap, remove and convert to DTO
                if (order.toString().equals(orderId)) {
                    OrderDTO dto = order.makeTradableDTO();
                    orders.remove(order);
                    dto.cancelledVolume += dto.remainingVolume;
                    dto.remainingVolume = 0;

                    if (orders.isEmpty()) {
                        bookEntries.remove(price,orders);
                    }
                    return dto;
                }
            }
        }
        return null;
    }

    //helper function for topOf methods
    private ArrayList<Price> getSortedBookEntriesPrices(){
        ArrayList<Price> sorted = new ArrayList<>(bookEntries.keySet());
        sorted.sort(Price::compareTo);
        return sorted;
    }

    //Accessor for Prices
    public Price topOfBookPrice() {
        ArrayList<Price> sorted = getSortedBookEntriesPrices();
        //Default set to SELL - Lowest Price
        if (sorted.isEmpty()){
            return null;
        }
        int pos = 0;
        if (side == BookSide.BUY) {

            pos = sorted.size()-1;
        }
        return sorted.get(pos);
    }

    //Accessor for Order volumes
    public int topOfBookVolume() {
        ArrayList<Price> sorted = getSortedBookEntriesPrices();
        if (sorted.isEmpty()){
            return 0;
        }
        //Default set to BUY - greatest price
        int pos = sorted.size()-1;
        if (side == BookSide.SELL) {
            pos = 0;
        }
        int totalOrderVolume = 0;
        ArrayList<Order> orders = bookEntries.get(sorted.get(pos));
        for (Order order : orders) {
            OrderDTO dto = order.makeTradableDTO();
            totalOrderVolume += dto.remainingVolume;
        }
        return totalOrderVolume;
    }


    public void tradeOut(Price price, int vol) {
        int remainingVol = vol;
        ArrayList<Order> orders = bookEntries.get(price);

        while (remainingVol > 0 && !orders.isEmpty()) {
            Order currOrder = orders.get(0);
            int currOrderRemainingVol = currOrder.getRemainingVolume();

            if (currOrderRemainingVol <= remainingVol) {
                orders.remove(0);
                int currOrderRemVol = currOrder.getRemainingVolume();
                currOrder.setFilledVolume(currOrder.getFilledVolume()+currOrderRemVol);
                currOrder.setRemainingVolume(0);
                remainingVol -= currOrderRemVol;
                System.out.println("FILL: (" + currOrder.getSide() + " " + currOrderRemainingVol + ") " + currOrder.toString());
            } else {
                currOrder.setFilledVolume(currOrder.getFilledVolume() + remainingVol);
                currOrder.setRemainingVolume(currOrder.getRemainingVolume() - remainingVol);
                System.out.println("PARTIAL FILL: (" + currOrder.getSide() + " " + remainingVol + ") " + currOrder.toString());
                remainingVol = 0;
            }


        }
        if (orders.isEmpty()) {
            bookEntries.remove(price);
        }
    }


    @Override
    public String toString() {
        String buildStr = "\n";
        if (bookEntries.keySet().isEmpty()){
            return "\n   <Empty>";
        }
        for (Price price : bookEntries.keySet()) {
            buildStr += "   ";
            ArrayList<Order> orders = bookEntries.get(price);
            buildStr += "Price: " + price + "\n";
            for (Order order : orders) {
                buildStr += order.toString() + "\n";
            }
        }
        return buildStr;
    }


}
