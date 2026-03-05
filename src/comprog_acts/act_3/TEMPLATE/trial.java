
import java.util.ArrayList;

public class trial {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        Item item1 = new Item("Apples", 20);
        Item item2 = new Item("Sword", 2);
        Inventory trial = new Item(null, 0);
        Item trial2 = new Inventory();

        trial.testPrint();
        System.out.println(trial.x);
        inventory.addItem(item1);
        inventory.addItem(item2);
    }
}

class Inventory {
    private ArrayList<Item> items;
    int x = 10;

    public Inventory() {
        this.items = new ArrayList<>();
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void displayInventory () {
        System.out.println(this.items);
    }

    public void testPrint() {
        System.out.println("From inventory");
    }
}

class Item extends Inventory {
    private String name;
    private int quantity;

    int x = 20;

    public Item(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public void testPrint() {
        System.out.println("From Item");
    }
    
}
