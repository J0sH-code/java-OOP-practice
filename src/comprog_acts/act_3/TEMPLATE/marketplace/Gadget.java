package marketplace;

public class Gadget extends Product{
    public static String COND_LIKE_NEW = "like new";
    public static String COND_GOOD = "good";
    public static String COND_MINT = "mint";

    public static String CLASS_MOBILE = "mobile";
    public static String CLASS_CAMERA = "camera";
    public static String CLASS_COMPUTER = "computer";

    protected boolean purchaseStatus = false;

    public Gadget(String brand, String model, float price, String condition, String classification){
        super(brand, model, price, condition, classification);
    }
    @Override
    protected void setPrice(float price) {
        this.price = price;
    }
    
    @Override
    protected void setDemand(int demand) {
        this.demand = demand;
    }

    public void isPurchaced() {
        this.purchaseStatus = true;
    }

    public boolean getPurchaseStatus() {
        return this.purchaseStatus;
    }
}
