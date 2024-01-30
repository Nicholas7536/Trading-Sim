public class Main {
    public static void main(String[] args) throws InvalidPriceOperation, InvalidOrderValue, InvalidUserValue {
        /*
        /*Price Tests
        //Testing makeprice for integer values
        int intValue1 = 5000;  // $50.00
        int intValue2 = -12;   // $-0.12
        int intValue3 = 12;    // $0.12
        int intValue4 = 12345; // $123.45

        Price priceA = PriceFactory.makePrice(intValue1);
        Price priceB = PriceFactory.makePrice(intValue2);
        Price priceC = PriceFactory.makePrice(intValue3);
        Price priceD = PriceFactory.makePrice(intValue4);

        System.out.println("Price a (int): " + priceA.toString());
        System.out.println("Price b (int): " + priceB.toString());
        System.out.println("Price c (int): " + priceC.toString());
        System.out.println("Price d (int): " + priceD.toString());


        //Testing makeprice for string values

        String stringValue1 = "0.00";
        String stringValue2 = "0.75";
        String stringValue3 = "$1,234,567.89";
        String stringValue4 = "$1234567.89";
        String stringValue5 = "-.89";

        Price price4 = PriceFactory.makePrice(stringValue1);
        Price price5 = PriceFactory.makePrice(stringValue2);
        Price price6 = PriceFactory.makePrice(stringValue3);
        Price price7 = PriceFactory.makePrice(stringValue4);
        Price price8 = PriceFactory.makePrice(stringValue5);

        System.out.println("Price 4 (String): " + price4.toString());
        System.out.println("Price 5 (String): " + price5.toString());
        System.out.println("Price 6 (String): " + price6.toString());
        System.out.println("Price 7 (String): " + price7.toString());
        System.out.println("Price 8 (String): " + price8.toString());

        // Test isNegative() method
        System.out.println("Price a is negative: " + priceA.isNegative()); // Should print false
        System.out.println("Price b is negative: " + priceB.isNegative()); // Should print true
        System.out.println("Price c is negative: " + priceC.isNegative()); // Should print false

        // Test add() method
        Price sum1 = priceA.add(priceC);
        System.out.println("Price a + c: " + sum1.toString()); // Should print $50.12

        // Test subtract() method
        Price diff1 = priceD.subtract(priceA);
        System.out.println("Price d - a: " + diff1.toString()); // Should print $73.45

        // Test multiply() method
        Price product1 = priceC.multiply(2);
        System.out.println("Price c * 2: " + product1.toString()); // Should print $0.24

        // Test greaterOrEqual() method
        System.out.println("Price a >= c: " + priceA.greaterOrEqual(priceC)); // Should print true

        // Test lessOrEqual() method
        System.out.println("Price c <= d: " + priceC.lessOrEqual(priceD)); // Should print true

        // Test greaterThan() method
        System.out.println("Price d > b: " + priceD.greaterThan(priceB)); // Should print true

        // Test lessThan() method
        System.out.println("Price a < c: " + priceA.lessThan(priceC)); // Should print false

        // Test equals() method
        System.out.println("Price a equals b: " + priceA.equals(priceB)); // Should print false

        // Test hashCode() method
        System.out.println("Hash code for priceA: " + priceA.hashCode());
        System.out.println("Hash code for priceB: " + priceB.hashCode());

        // Test compareTo() method
        int compareResult = priceA.compareTo(priceC);
        System.out.println("Compare price a and c: " + compareResult); // Should print a positive value


        // Exceptions
        try {
            Price sumA = priceA.add(null);
        } catch (InvalidPriceOperation a){
            System.out.println(a.getMessage()); // Should print Cannot use null Price.
        }
        try {
            Boolean greaterA = priceA.greaterThan(null);
        } catch (InvalidPriceOperation a){
            System.out.println(a.getMessage()); // Should print Cannot use null Price.
        }
        try {
            Boolean greaterOrEqualA = priceA.greaterOrEqual(null);
        } catch (InvalidPriceOperation a){
            System.out.println(a.getMessage()); // Should print Cannot use null Price.
        }
        try {
            Price sumA = priceA.add(null);
        } catch (InvalidPriceOperation a){
            System.out.println(a.getMessage()); // Should print Cannot use null Price.
        }

        try {
            Price BadPrice = PriceFactory.makePrice("$2B.AD");
        } catch (InvalidPriceOperation a){
            System.out.println(a.getMessage()); // Should print Invalid String for makePrice: 'String'.
        }




        System.out.println("Price a equals null: " + priceA.equals(null)); // Should print false
        int compareNull = priceA.compareTo(null);
        System.out.println("Compare price a and null: " + compareNull); // Should print -1


        */

        //Flyweight testing
/*
        Price copy1 = PriceFactory.makePrice(1234);
        Price copy2 = PriceFactory.makePrice(1234);
        Price copy3 = PriceFactory.makePrice(9999);
        Price copy4 = PriceFactory.makePrice("$12.45");
        Price copy5 = PriceFactory.makePrice("12.45");
        Price copy6 = PriceFactory.makePrice("-12.45");


        //Order and OrderDTO Creation
        Price amznPrice = PriceFactory.makePrice(9638);
        Order myOrder = new Order("XRF","AMZN", amznPrice, 50, BookSide.BUY);
        System.out.println(myOrder.toString());

        OrderDTO myDTO = myOrder.makeTradableDTO();
        System.out.println(myDTO);

        //ProductBookSide a = new ProductBookSide(BookSide.BUY,HashMap<Price,ArrayList<Order>>)
*/
        /*
        ProductBook pb = new ProductBook("TGT");
        try {
            System.out.println("1) --------------------------------------------------------------");
            Order o1 = new Order("AAA", "TGT", PriceFactory.makePrice(1000), 50, BookSide.BUY);
            pb.add(o1);
            System.out.println(pb);
            System.out.println("2) --------------------------------------------------------------");
            Order o2 = new Order("BBB", "TGT", PriceFactory.makePrice(1000), 60, BookSide.BUY);
            pb.add(o2);
            System.out.println(pb);
            System.out.println("3) --------------------------------------------------------------");
            Order o3 = new Order("CCC", "TGT", PriceFactory.makePrice(995), 70, BookSide.BUY);
            pb.add(o3);
            System.out.println(pb);
            System.out.println("4) --------------------------------------------------------------");
            Order o4 = new Order("DDD", "TGT", PriceFactory.makePrice(990), 25, BookSide.BUY);
            pb.add(o4);
            System.out.println(pb);
            System.out.println("5) --------------------------------------------------------------");
            Order o5 = new Order("EEE", "TGT", PriceFactory.makePrice(1010), 120, BookSide.SELL);
            pb.add(o5);
            System.out.println(pb);
            System.out.println("6) --------------------------------------------------------------");
            Order o6 = new Order("EEE", "TGT", PriceFactory.makePrice(1020), 45, BookSide.SELL);
            pb.add(o6);
            System.out.println(pb);
            System.out.println("7) --------------------------------------------------------------");
            Order o7 = new Order("FFF", "TGT", PriceFactory.makePrice(1025), 90, BookSide.SELL);
            pb.add(o7);
            System.out.println(pb);
            System.out.println("8) --------------------------------------------------------------");
            Order o8 = new Order("AAA", "TGT", PriceFactory.makePrice(1000), 200, BookSide.SELL);
            pb.add(o8);
            System.out.println(pb);
            System.out.println("9) --------------------------------------------------------------");
            Order o9 = new Order("BBB", "TGT", PriceFactory.makePrice(1010), 200, BookSide.BUY);
            pb.add(o9);
            System.out.println(pb);
            System.out.println("10) --------------------------------------------------------------");
            pb.cancel(BookSide.SELL, o6.getId());
            System.out.println(pb);
            System.out.println("11) --------------------------------------------------------------");
            Order o10 = new Order("CCC", "TGT", PriceFactory.makePrice(990), 95, BookSide.SELL);
            pb.add(o10);
            System.out.println(pb);
            System.out.println("12) --------------------------------------------------------------");
            Order o11 = new Order("DDD", "TGT", PriceFactory.makePrice(1025), 100, BookSide.BUY);

            pb.add(o11);
            System.out.println(pb);
        } catch ( InvalidOrderValue e) {
            System.out.println("Unexpected exception occurred: " + e.getMessage());
            e.printStackTrace();
        }
        */
        TrafficSim.runSim();


    }
}