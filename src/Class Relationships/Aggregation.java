import java.util.Arrays;
import java.util.List;

public class Aggregation {
    public static void main(String[] args) throws Exception {
        
    }
}

class Store {
    //Attributes
    String storeName;
    List<Product> products = Arrays.asList(new Product("Dove", this), new Product("Safeguard", this));

    public Store (String storeName) {
        this.storeName = storeName;
    }

}

class Product {
    String productName;
    Store store;

    public Product (String productName, Store store) {
        this.productName = productName;
        this.store = store;
    }
}