public class Singleton_Example {

    public static final String name = "ChicagoStreet";
    private static Singleton_Example instance;

    private long id;
    private Singleton_Example(){
        id = System.currentTimeMillis();
    }

    public static Singleton_Example getInstance() {
        if (instance == null){
            instance = new Singleton_Example();
        }
        return instance;
    }

    public void getRoadInfo(){
        System.out.println(id);
    }
}