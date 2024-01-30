import java.util.ArrayList;
import java.util.HashMap;

public class CurrentMarketPublisher {
    private static HashMap<String /*Symbol*/, ArrayList<CurrentMarketObserver>> filters = new HashMap<>();

    private static CurrentMarketPublisher instance;

    public static CurrentMarketPublisher getInstance() {
        if (instance == null){
            instance = new CurrentMarketPublisher();
        }

        return instance;
    }

    void subscribeCurrentMarket(String symbol, CurrentMarketObserver cmo){
        if (!filters.containsKey(symbol)){
            filters.put(symbol, new ArrayList<CurrentMarketObserver>());
            filters.get(symbol).add(cmo);
        }
        filters.get(symbol).add(cmo);
    }

    void unSubscribeCurrentMarket(String symbol, CurrentMarketObserver cmo){
        if (filters.containsKey(symbol)){
            filters.get(symbol).remove(cmo);
        }
        return;
    }

    void acceptCurrentMarket(String symbol, CurrentMarketSide buySide, CurrentMarketSide sellSide){
        if (filters.containsKey(symbol)){
            ArrayList<CurrentMarketObserver> currObservers = filters.get(symbol);
            for (CurrentMarketObserver cmo : currObservers){
                cmo.updateCurrentMarket(symbol,buySide,sellSide);
            }
        }
        return;
    }

    //Done

}

