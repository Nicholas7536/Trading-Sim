public class OrderDTO {
    public final String user;
    public final String product;
    public final Price price;
    public final String id;
    public final int originalVolume;
    public final BookSide side;
    public int remainingVolume;
    public int cancelledVolume;
    public int filledVolume;

    public OrderDTO (String nuser, String product, Price price,
                     int originalVolume, int remainingVolume, BookSide side){
        this.user = nuser;
        this.product = product;
        this.price = price;
        this.side = side;
        this.id = user + product + price.toString() + System.nanoTime();
        this.originalVolume = originalVolume;
        this.remainingVolume = remainingVolume;
        this.cancelledVolume = 0;
        this.filledVolume = 0;
    }

    public String toString() {

        return user + " order: " + side + " " + product + " at " + price
                + ", Orig Vol: " + originalVolume + ", Rem Vol: " + remainingVolume
                + ", Fill Vol: " + filledVolume + ", CXL Vol: " + cancelledVolume
                + ", ID: " + id;
    }
}
