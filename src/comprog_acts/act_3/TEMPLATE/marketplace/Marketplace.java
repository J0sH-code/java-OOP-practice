package marketplace;


public class Marketplace extends Shop {
    public Marketplace (String name) {
        super(name);
    }

    @Override
    public void add(Product item) {
        this.itemCounter++;
        Product[] prevItems = this.items;
		this.items = new Product[this.itemCounter];

		if (this.itemCounter == 1) {
			this.items[0] = item;
		} 

		if (this.itemCounter > 1) {
            System.arraycopy(prevItems, 0, this.items, 0, prevItems.length);
			this.items[itemCounter-1] = item;
		}
    }

    @Override
    public void remove(Product item) {
        Product[] prevItems = this.items;
        this.items = new Product[prevItems.length-1];
        int itemIndex = findItemIndex(prevItems, item);

        if (prevItems.length == 1) {
            this.items = new Product[0];
        }

        if (prevItems.length > 1) {
            System.arraycopy(prevItems, 0, this.items, 0, itemIndex);
            for (int i = itemIndex; i < prevItems.length-1; i++) {
                this.items[i] = prevItems[i+1];
            }
        }
    }

    private int findItemIndex (Product[] list, Product item) {
        for (int i = 0; i < list.length; i++) {
            if (item == list[i]) {
                return i;
            }
        }
        return 0;
    }

    public void purchaseHandler(Product item) {
        for (int i = 0; i < this.items.length; i++) {
            if (this.items[i].classification.equals(item.classification)) {
                this.items[i].demand += 3;

                if (this.items[i].demand <= 10) {
                    if (this.items[i].condition.equals(Gadget.COND_GOOD)) {
                        this.items[i].price -= (this.items[i].price * 0.15);
                        this.items[i].demand-=10;
                    }

                    if (this.items[i].condition.equals(Gadget.COND_MINT)) {
                        this.items[i].price -= (this.items[i].price * 0.10);
                        this.items[i].demand-=10;
                    }

                    if (this.items[i].condition.equals(Gadget.COND_LIKE_NEW)) {
                        this.items[i].price -= (this.items[i].price * 0.05);
                        this.items[i].demand-=10;
                    }
                }
            }
        }
    }

    @Override
    protected boolean find(Product item) {
        for (int i = 0; i < this.items.length; i++) {
            if (this.items[i] == item) {
                return true;
            }
        }
        return false;
    }

    @Override
    protected void transact(Product item) {
        remove(item);
    }

    @Override
    public void viewProducts() {
        System.out.println(this.name);
        for (int i = 0; i < this.items.length; i++) {
            System.out.println();
            System.out.println("Item " + (i+1) +": ");
            System.out.println("Brand: " + this.items[i].brand);
            System.out.println("Model: " + this.items[i].model);
            System.out.println("Price: " + this.items[i].price);
            System.out.println("Condition: " + this.items[i].condition);
            System.out.println("Classification: " + this.items[i].classification);
            System.out.println("Demand PointsL: " + this.items[i].demand);
        }
    }

    @Override
    public void viewInfo() {
        System.out.println(this.name);
        System.out.println("Total products: " + this.items.length);
        System.out.println("Total sales: " + this.sales);
    }

    @Override
    public String getName() {
        return super.name;
    }

    @Override
    protected float getSales() {
        return super.sales;
    }

    public Product[] getItems() {
        return this.items;
    }
}
