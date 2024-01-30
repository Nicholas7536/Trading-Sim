import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class ProductManager {
    private static ProductManager instance;
    public static HashMap<String/*Product symbol*/, ProductBook> productBooks = new HashMap<>();

    public static ProductManager getInstance() {
        if (instance == null){
            instance = new ProductManager();
        }
        return instance;
    }

    public void addProduct(String symbol) throws InvalidOrderValue {
        productBooks.put(symbol, new ProductBook(symbol));
    }

    public String getRandomProduct(){
        List<String> keysAsArray = new ArrayList<String>(productBooks.keySet());
        Random random = new Random();
        int randomSymbol = random.nextInt(keysAsArray.size());
        return keysAsArray.get(randomSymbol);
    }

    public OrderDTO addOrder(Order o) throws InvalidPriceOperation {
        String productSymbol = o.getProductSymbol();
        ProductBook currProdBook = productBooks.get(productSymbol);
        return currProdBook.add(o);
    }

    public OrderDTO cancel(OrderDTO o) throws InvalidPriceOperation {
        if (o == null){
            System.out.println("Failed to cancel order");
            return null;
        }
        ProductBook currProductBook = productBooks.get(o.product);
        OrderDTO cancelledOrder = currProductBook.cancel(o.side,o.id);
        return cancelledOrder;
    }

    @Override
    public String toString() {
        String prodMngrStr = "";
        for (String userId : productBooks.keySet()) {
            ProductBook currUser = productBooks.get(userId);
            prodMngrStr += currUser.toString();
        }
        return prodMngrStr;
    }
}