import java.util.HashMap;

public class TrafficSim {
    private static HashMap<String /*Symbol*/, Double /*Price*/> basePrices = new HashMap<>();

    public static void runSim() throws InvalidPriceOperation, InvalidOrderValue, InvalidUserValue {
        UserManager userManager = UserManager.getInstance();

        ProductManager productManager = ProductManager.getInstance();

        userManager.init(new String[]{"ANN","BOB","CAT","DOG","EGG"});

        User annRef = userManager.getUser("ANN");
        User bobRef = userManager.getUser("BOB");
        User catRef = userManager.getUser("CAT");
        User dogRef = userManager.getUser("DOG");
        User eggRef = userManager.getUser("EGG");

        CurrentMarketPublisher cmp = CurrentMarketPublisher.getInstance();

        cmp.subscribeCurrentMarket("WMT",annRef);
        cmp.subscribeCurrentMarket("TGT",annRef);
        cmp.subscribeCurrentMarket("TGT",bobRef);
        cmp.subscribeCurrentMarket("TSLA",bobRef);
        cmp.subscribeCurrentMarket("AMZN",catRef);
        cmp.subscribeCurrentMarket("TGT",catRef);
        cmp.subscribeCurrentMarket("WMT",catRef);
        cmp.subscribeCurrentMarket("TSLA",dogRef);
        cmp.subscribeCurrentMarket("WMT",eggRef);

        cmp.unSubscribeCurrentMarket("TGT",bobRef);


        // Call the ProductManager's
        // AddProduct method, once for
        // each of these product symbols:
        // WMT, TGT, AMZN, TSLA
        try {
            productManager.addProduct("WMT");
            productManager.addProduct("TGT");
            productManager.addProduct("AMZN");
            productManager.addProduct("TSLA");
        } catch (InvalidOrderValue e) {
            e.getMessage();
        }

        // Add the following pairs of symbol-price values to
        // the TrafficSim s HashMap of base prices:
        // "WMT", 140.98 "TGT", 174.7 6
        // "AMZN", 102.11 "TSLA", 196.8 1
        basePrices.put("WMT",140.98);
        basePrices.put("TGT",174.76);
        basePrices.put("AMZN",102.11);
        basePrices.put("TSLA",196.81);

        for (int i = 0; i < 10000; i++){
            User randUser = userManager.getRandomUser();
            if (Math.random()<0.9){
                String randProdSymbol = productManager.getRandomProduct();
                BookSide randSide = BookSide.getRandomSide();
                int randOrderVolume = (int) (25 + (Math.random() * 300));
                randOrderVolume = (int)Math.round(randOrderVolume/5.0)*5;
                Price orderPrice = TrafficSim.getPrice(randProdSymbol,randSide);
                Order order = new Order(randUser.getUserId(),randProdSymbol,orderPrice,randOrderVolume,randSide);
                OrderDTO dto = productManager.addOrder(order);
                randUser.addOrder(dto);
            } else { /* >= 0.9 */
                if (randUser.hasOrderWithRemainingQty()){
                    ; // Do nothing
                } else {
                    continue;
                }
                OrderDTO randOrderDto = randUser.getOrderWithRemainingQty();
                OrderDTO cancelledDto = productManager.cancel(randOrderDto);
                if (!(cancelledDto == null)){
                    randUser.addOrder(cancelledDto);
                } else {
                    ; // Do nothing
                }
            }
        }
        System.out.print("\n\n\n******ProdudtManager******\n\n");
        //System.out.print(productManager.toString());
        System.out.print("\n\n\n*******UserManager*******\n\n");
        //System.out.print(userManager.toString());
        System.out.println("** ProductManager and UserManager commented out so that the currentmarket messages can be viewed above **\n");

        System.out.println(annRef.getCurrentMarkets());
        System.out.println(bobRef.getCurrentMarkets());
        System.out.println(catRef.getCurrentMarkets());
        System.out.println(dogRef.getCurrentMarkets());
        System.out.println(eggRef.getCurrentMarkets());





        cmp.unSubscribeCurrentMarket("WMT",annRef);
        cmp.unSubscribeCurrentMarket("TGT",annRef);
        cmp.unSubscribeCurrentMarket("TGT",bobRef);
        cmp.unSubscribeCurrentMarket("TSLA",bobRef);
        cmp.unSubscribeCurrentMarket("AMZN",catRef);
        cmp.unSubscribeCurrentMarket("TGT",catRef);
        cmp.unSubscribeCurrentMarket("WMT",catRef);
        cmp.unSubscribeCurrentMarket("TSLA",dogRef);
        cmp.unSubscribeCurrentMarket("WMT",eggRef);
    }

    public static Price getPrice(String symbol, BookSide side) throws InvalidPriceOperation {
        double basePrice = basePrices.get(symbol);
        double priceWidth = 0.02;
        double startPoint = 0.01;
        double tickSize = 0.1;
        double gapFromBase = basePrice * priceWidth; // 5.0
        double priceVariance = gapFromBase * (Math.random());

        if (side == BookSide.BUY) {
            double priceToUse = basePrice * (1 - startPoint);
            priceToUse += priceVariance;
            double priceToTick = Math.round(priceToUse * 1/tickSize) / 20.0;
            return PriceFactory.makePrice((int) (priceToTick*100));
        }
        else if (side == BookSide.SELL) {
            double priceToUse = basePrice * (1 + startPoint);
            priceToUse -= priceVariance;
            double priceToTick = Math.round(priceToUse * 1/tickSize) / 20.0;
            return PriceFactory.makePrice((int) (priceToTick*100));
        }

        return null;
    }
}

/*
* TGT $87.25x160 - $0.00x0 [$0.00]
**************************************
CANCEL: BUY Order: DOGWMT$70.15294002077578900 Cxl Qty: 275
*********** Current Market ***********
* WMT $70.30x185 - $0.00x0 [$0.00]
**************************************
ADD: BUY: EGG order: BUY TSLA at $98.85, Orig Vol: 305, Rem Vol: 305, Fill Vol: 0, CXL Vol: 0, ID:
EGGTSLA$98.85294002089932400
FULL FILL: (SELL 205) BOB order: SELL TSLA at $97.95, Orig Vol: 250, Rem Vol: 0, Fill Vol: 250, CXL Vol: 0,
ID: BOBTSLA$97.95294002078197500
PARTIAL FILL: (BUY 205) EGG order: BUY TSLA at $98.85, Orig Vol: 305, Rem Vol: 100, Fill Vol: 205, CXL Vol:
0, ID: EGGTSLA$98.85294002089932400
*********** Current Market ***********
* TSLA $98.85x100 - $0.00x0 [$0.00]
**************************************
ADD: SELL: BOB order: SELL WMT at $70.00, Orig Vol: 130, Rem Vol: 130, Fill Vol: 0, CXL Vol: 0, ID:
BOBWMT$70.00294002090612300
FULL FILL: (SELL 130) BOB order: SELL WMT at $70.00, Orig Vol: 130, Rem Vol: 0, Fill Vol: 130, CXL Vol: 0,
ID: BOBWMT$70.00294002090612300
PARTIAL FILL: (BUY 130) ANN order: BUY WMT at $70.30, Orig Vol: 185, Rem Vol: 55, Fill Vol: 130, CXL Vol: 0,
ID: ANNWMT$70.30294002083989700
*********** Current Market ***********
* WMT $70.30x55 - $0.00x0 [$0.00]
**************************************
[…]
ADD: BUY: DOG order: BUY TGT at $87.85, Orig Vol: 115, Rem Vol: 115, Fill Vol: 0, CXL Vol: 0, ID:
DOGTGT$87.85294357585953100
*********** Current Market ***********
* TGT $87.85x115 - $88.00x45 [$0.15]
**************************************
ANN:
TGT $86.70x230 - $87.00x30
WMT $70.00x280 - $70.15x155
BOB:
TSLA $97.60x195 - $98.30x95
CAT:
TGT $86.70x230 - $87.00x30
AMZN $50.90x435 - $51.05x135
WMT $70.00x280 - $70.15x155
DOG:
TSLA $97.60x195 - $98.30x95
EGG:
WMT $70.00x280 - $70.15x155
 */
