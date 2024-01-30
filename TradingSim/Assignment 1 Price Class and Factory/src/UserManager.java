import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class UserManager {


    // Hashmap of userId and User object
    static HashMap<String/*orderId*/, User> orders = new HashMap<>();
    private static UserManager instance;

    public static UserManager getInstance() {
        if (instance == null){
            instance = new UserManager();
        }
        return instance;
    }

    public void init(String[] usersIn) throws InvalidUserValue {
        // Create a new User object for each userId in the String array passed in.
        //Each User object should be added to the UserManager’s HashMap of users.
        for (String user : usersIn){
            User inUser = new User(user);
            orders.put(inUser.getUserId(), inUser);
        }
    }

   public User getRandomUser(){
        Random random    = new Random();
        List<String> keys = new ArrayList<String>(orders.keySet());
        String randomKey = keys.get( random.nextInt(keys.size()) );
        return orders.get(randomKey);
   }

   void addToUser(String userId, OrderDTO o){
        User currUser = orders.get(userId);
        currUser.addOrder(o);
   }

    @Override
    public String toString() {
        String userMngrStr = "";
        for (String userId : orders.keySet()) {
            User currUser = orders.get(userId);
            userMngrStr += currUser.toString();
        }
        return userMngrStr;
    }

    public User getUser(String id){
        return orders.get(id);
    }
    //Done

}
