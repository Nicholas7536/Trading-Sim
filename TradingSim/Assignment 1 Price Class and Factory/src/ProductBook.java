import java.util.ArrayList;
import java.util.HashMap;

public class ProductBook {
    private final String product;
    private final ProductBookSide buySide;
    private final ProductBookSide sellSide;

    public ProductBook(String product) throws InvalidOrderValue {
        // Validate product
        if (product == null || product.length() < 1 || product.length() > 5 || !product.matches("^[A-Z0-9.]*$")) {
            throw new InvalidOrderValue("Invalid product symbol:" + product);
        }
        this.product = product; // add data validation
        this.buySide = new ProductBookSide(BookSide.BUY, new HashMap<Price, ArrayList<Order>>());
        this.sellSide = new ProductBookSide(BookSide.SELL, new HashMap<Price, ArrayList<Order>>());
    }

    public OrderDTO add(Order o) throws InvalidPriceOperation {
        OrderDTO dto = o.makeTradableDTO();
        if (dto.side == BookSide.BUY) {
            dto = buySide.add(o);
            tryTrade();
            updateMarket();
        }
        else if (dto.side == BookSide.SELL) {
            dto = sellSide.add(o);
            tryTrade();
            updateMarket();
        }
        return dto;
    }

    public OrderDTO cancel(BookSide side, String orderId) throws InvalidPriceOperation {
        OrderDTO dto = null;
        if (side == BookSide.BUY) {
            dto = buySide.cancel(orderId);
            updateMarket();
        }
        else if (side == BookSide.SELL) {
            dto = sellSide.cancel(orderId);
            updateMarket();
        }
        return dto;
    }

    public void tryTrade(){
        Price topBuyPrice = buySide.topOfBookPrice();
        Price topSellPrice = sellSide.topOfBookPrice();

        while (topBuyPrice != null && topSellPrice != null &&
                (topBuyPrice.compareTo(topSellPrice) == 0 || topBuyPrice.compareTo(topSellPrice) == 1)){

            int topBuyVol = buySide.topOfBookVolume();
            int topSellVol = sellSide.topOfBookVolume();

            int volToTrade = Math.min(topBuyVol,topSellVol);
            sellSide.tradeOut(topSellPrice, volToTrade);
            buySide.tradeOut(topBuyPrice, volToTrade);

            topBuyPrice = buySide.topOfBookPrice();
            topSellPrice = sellSide.topOfBookPrice();
        }
    }

    private void updateMarket() throws InvalidPriceOperation {
        Price topBuyPrice = buySide.topOfBookPrice();
        int topBuyVol = buySide.topOfBookVolume();
        Price topSellPrice = sellSide.topOfBookPrice();
        int topSellVol = sellSide.topOfBookVolume();

        CurrentMarketTracker cmt = CurrentMarketTracker.getInstance();

        cmt.updateMarket(product,topBuyPrice,topBuyVol,topSellPrice,topSellVol);
    }


    public String toString(){
        return "Product: " + product +
                "\nSide: BUY" +
                buySide.toString() +
                "\nSide: SELL" +
                sellSide.toString() + "\n";
    }

    //Done
}
