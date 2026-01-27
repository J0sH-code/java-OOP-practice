import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Aggregation {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws Exception {
        runProgram();
    }

    static void runProgram() {
        boolean running = true;
        while (running) { 
            storeProductRelation(running);
        }
    }

    static void storeProductRelation(boolean running) {
        System.out.print("Enter store name: ");
        String storeName = scanner.nextLine();
        Store myStore = new Store(storeName);

        System.out.println("Welcome to " + storeName);
        System.out.println("[1: View Products] [2: Add Products] [3: Buy Product] [4: Remove Products]");
        int input = scanner.nextInt();
        scanner.nextLine();

        inputHandler(input, myStore, running);
    }

    static void inputHandler(int input, Store store, boolean running){
        switch (input) {
            case 1 -> {
                for (Product product : store.products) {
                    System.out.println(product);
                }
            }
            case 2 -> {
                System.out.println("Product name: ");
                String productName = scanner.nextLine();
                store.addProduct(new Product(productName.toLowerCase(), store));
            }
            case 3 -> {
                System.out.println("TBC");
            }
            case 4 -> {
                System.out.print("Enter product name to remove: ");
                String productName = scanner.nextLine();
                store.removeProduct(new Product(productName, store));
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
    ArrayList<Product> products = (ArrayList<Product>) Arrays.asList(new Product("dove", this), new Product("safeguard", this));

    public Store (String storeName) {
        this.storeName = storeName;
    }

    void addProduct(Product product){
        products.add(product);
    }

    void removeProduct(Product product){
        products.remove(product);
    }

}

class Product {
    //Class Store is used an attribute for class Product
    private String productName;
    private Store store;

    public Product (String productName, Store store) {
        this.productName = productName;
        this.store = store;
    }

    void setStore(Store store) {
        this.store = store;
    }
}