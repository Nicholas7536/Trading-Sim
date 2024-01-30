public class CurrentMarketTracker {
    private static CurrentMarketTracker instance;
    public static CurrentMarketTracker getInstance() {
        if (instance == null){
            instance = new CurrentMarketTracker();
        }
        return instance;
    }

    public void updateMarket(String symbol, Price buyPrice, int buyVolume, Price sellPrice, int sellVolume) throws InvalidPriceOperation {

        if (buyPrice==null){
            buyPrice = PriceFactory.makePrice(0);
        }
        if (sellPrice==null){
            sellPrice = PriceFactory.makePrice(0);
        }
        Price marketWidth = sellPrice.subtract(buyPrice);
        CurrentMarketSide currMarketBuy = new CurrentMarketSide(buyPrice, buyVolume);
        CurrentMarketSide currMarketSell = new CurrentMarketSide(sellPrice, sellVolume);
        System.out.println(
                "*********** Current Market ***********\n"+
                "* " + symbol + "  " + buyPrice.toString() + "X" + buyVolume + " - " + sellPrice.toString() + "X" + sellVolume + " [" + marketWidth.toString() + "]"+
                "\n**************************************"
        );
        CurrentMarketPublisher cmp = CurrentMarketPublisher.getInstance();
        cmp.acceptCurrentMarket(symbol,currMarketBuy,currMarketSell);
    }
    // Done

}
