import java.util.HashMap;

public class User implements CurrentMarketObserver{


    private String userId;

    // Hashmap or Order id's and OrderDTO objects associated with the id
    private HashMap<String, OrderDTO> orders = new HashMap<>();
   private HashMap<String, CurrentMarketSide[]> currentMarkets = new HashMap<String, CurrentMarketSide[]>();

    public User(String userId) throws InvalidUserValue {
        if (userId != null && userId.matches("^[A-Z]{3}$")) {
            this.userId = userId;
        } else {
            this.userId = "BAD";
            throw new InvalidUserValue("Invalid userId: " + userId);
        }
    }

    public String getUserId() {
        return userId;
    }
    private void setUserId(String userId) {
        this.userId = userId; // Make sure this userId passes validation check above**
    }

    public void addOrder(OrderDTO o) {
        // validate incoming order to not be null
        orders.put(o.id, o);
    }
    public boolean hasOrderWithRemainingQty(){
        OrderDTO currOrder;
        for (String orderId : orders.keySet()) {
            currOrder = orders.get(orderId);
            if (currOrder.remainingVolume == 0){
                return false;
            }

        }
        return true;
    }

    public OrderDTO getOrderWithRemainingQty(){
        OrderDTO currOrder;
        for (String orderId : orders.keySet()) {
            currOrder = orders.get(orderId);
            if (currOrder.remainingVolume > 0){
                return currOrder;
            }

        }
        return null;
    }

    @Override
    public String toString() {
        String buildStr = "";
        if (orders.keySet().isEmpty()){
            return "\n   <Empty>";
        }
        for (String orderId : orders.keySet()) {
            buildStr += "   ";
            OrderDTO dto = orders.get(orderId);
            buildStr += "Product: " + dto.toString() + "\n";
        }
        return "UserID : " + userId + '\n' + buildStr + "\n";
    }

    @Override
    public void updateCurrentMarket(String symbol, CurrentMarketSide buySide, CurrentMarketSide sellSide) {
        CurrentMarketSide[] currMarketSides = {buySide,sellSide};
        currentMarkets.put(symbol,currMarketSides);
    }

    public String getCurrentMarkets(){
        String summary = userId + ":\n";
        for (String symbol : currentMarkets.keySet()){
            summary += symbol + "  " + currentMarkets.get(symbol)[0].toString() + " - ";
            summary += currentMarkets.get(symbol)[1].toString() + "\n";
        }
        return summary;
    }



    //Done
}
