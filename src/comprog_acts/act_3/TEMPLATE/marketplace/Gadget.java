package marketplace;

public class Gadget extends Product {

    public static String COND_LIKE_NEW = "like new";
    public static String COND_GOOD = "good";
    public static String COND_MINT = "mint";

    public static String CLASS_MOBILE = "mobile";
    public static String CLASS_CAMERA = "camera";
    public static String CLASS_COMPUTER = "computer";

    protected boolean purchaseStatus = false;
    private int itemNumber;

    public Gadget(String brand, String model, float price, String condition, String classification) {
        super(brand, model, price, condition, classification);
    }

    //This is a setter for gadget price
    @Override
    protected void setPrice(float price) {
        this.price = price;
    }

    //This is a setter for gadget demand
    @Override
    protected void setDemand(int demand) {
        this.demand = demand;
    }

    //This is a setter for item number
    public void setItemNumber(int number) {
        this.itemNumber = number;
    }

    //This is a getter for item number
    public int getItemNumber() {
        return this.itemNumber;
    }
}
