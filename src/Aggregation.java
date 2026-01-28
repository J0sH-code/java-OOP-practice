import java.util.HashMap;
import java.util.Scanner;

public class Aggregation {
    static Scanner scanner = new Scanner(System.in);
    static String storeName;
    static Store myStore = new Store(storeName);
    public static void main(String[] args) throws Exception {
        runProgram();
    }

    static void runProgram() {
        System.out.print("Enter store name: ");
        storeName = scanner.nextLine();
        

        boolean running = true;
        while (running) { 
            storeProductRelation(running, storeName, myStore);
        }
    }

    static void storeProductRelation(boolean running, String storeName, Store myStore) {
        System.out.println("Welcome to " + storeName);
        System.out.println("[1: View Products] [2: Add Products] [3: Buy Product] [4: Remove Products]");
        int input = scanner.nextInt();
        scanner.nextLine();

        inputHandler(input, myStore, running);
    }

    static void inputHandler(int input, Store store, boolean running){
        switch (input) {
            case 1 -> {
                System.out.println(store.products.keySet());
            }
            case 2 -> {
                System.out.println("Product name: ");
                String productName = scanner.nextLine();
                store.addProduct(new Product(productName.toLowerCase(), store));
                System.out.println(store.products.keySet());
            }
            case 3 -> {
                System.out.println("TBC");
            }
            case 4 -> {
                System.out.print("Enter product name to remove: ");
                String productName = scanner.nextLine();
                store.removeProduct(productName);
            }
        
            default -> {
                running = false;
            }
        }
    }
}

class Store {
    //Class Product is used an attribute for class Store
    String storeName;
    HashMap<String, Product> products = new HashMap<>();

    public Store (String storeName) {
        this.storeName = storeName;

        setProducts();
    }

    private void setProducts() {
        products.put("dove", new Product("dove", this));
        products.put("safeguard", new Product("safeguard", this));
        products.put("colgate", new Product("colgate", this));
    }

    void addProduct(Product product){
        products.put(product.getProductName(), product);
    }

    void removeProduct(String productKey){
        products.remove(productKey);
    }

}

class Product {
    //Class Store is used an attribute for class Product
    private final String productName;
    private Store store;

    public String getProductName() {
        return this.productName;
    }

    public Store getStore() {
        return this.store;
    }

    public Product (String productName, Store store) {
        this.productName = productName;
        this.store = store;
    }

    void setStore(Store store) {
        this.store = store;
    }
}