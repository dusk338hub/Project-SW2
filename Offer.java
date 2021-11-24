public class Offer {
    private int price ;
    private Driver driver;
    public Offer(){}
    public Offer(int price, Driver driver) {
        this.price = price;
        this.driver = driver;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }
}
