public class Order {

    private final String user;
    private final String product;
    private final Price price;
    private final String id;
    private final int originalVolume;
    private final BookSide side;
    private int remainingVolume;
    private int cancelledVolume;
    private int filledVolume;


    public Order(String user, String product, Price price, int originalVolume, BookSide side)
            throws InvalidOrderValue {
        // Validate user
        if (user == null || user.length() != 3 || !user.matches("^[A-Z]*$")) {
            throw new InvalidOrderValue("Invalid user code:" + user);
        }

        // Validate product
        if (product == null || product.length() < 1 || product.length() > 5 || !product.matches("^[A-Z0-9.]*$")) {
            throw new InvalidOrderValue("Invalid product symbol:" + product);
        }

        // Validate price
        if (price == null) {
            throw new InvalidOrderValue("Price must not be null");
        }

        // Validate originalVolume
        if (originalVolume <= 0 || originalVolume >= 10_000) {
            throw new InvalidOrderValue("Original volume must be between 1 and 10,000:" + originalVolume);
        }

        // Validate side
        if (side == null) {
            throw new InvalidOrderValue("Side must not be null");
        }
        this.user = user;
        this.product = product;
        this.price = price;
        this.side = side;
        this.id = user + product + price.toString() + System.nanoTime();
        this.originalVolume = originalVolume;
        this.remainingVolume = originalVolume;
        this.cancelledVolume = 0;
        this.filledVolume = 0;
    }

    public int getRemainingVolume() {
        return remainingVolume;
    }

    public void setRemainingVolume(int remainingVolume) {
        this.remainingVolume = remainingVolume;
    }

    public int getCancelledVolume() {
        return cancelledVolume;
    }

    public void setCancelledVolume(int cancelledVolume) {
        this.cancelledVolume = cancelledVolume;
    }

    public int getFilledVolume() {
        return filledVolume;
    }

    public void setFilledVolume(int filledVolume) {
        this.filledVolume = filledVolume;
    }

    public String getId() {
        return id;
    }

    public BookSide getSide() {
        return side;
    }

    public String getProductSymbol() { return product; }

    @Override
    public String toString() {

        return "     " + user + " order: " + side + " " + product + " at " + price
                + ", Orig Vol: " + originalVolume + ", Rem Vol: " + remainingVolume
                + ", Fill Vol: " + filledVolume + ", CXL Vol: " + cancelledVolume
                + ", ID: " + id;
    }

    public OrderDTO makeTradableDTO(){
        return new OrderDTO(user, product, price, originalVolume, remainingVolume, side);
    }


}
