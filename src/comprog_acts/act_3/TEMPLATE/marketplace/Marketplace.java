package marketplace;


public class Marketplace extends Shop {
    public Marketplace (String name) {
        super(name);
    }

    @Override
    public void add(Product item) {
        this.itemCounter++;
        ((Gadget)item).setItemNumber(itemCounter);
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
        this.itemCounter--;
    }

    private int findItemIndex (Product[] list, Product item) {
        for (int i = 0; i < list.length; i++) {
            if (item == list[i]) {
                return i;
            }
        }
        return 0;
    }

    public void purchaseHandler(Product boughtItem) {

    for (int i = 0; i < this.items.length; i++) {
        if (this.items[i].getClassification().equals(boughtItem.getClassification())) {
            // Increase demand
            int newDemand = this.items[i].getDemand() + 3;
            this.items[i].setDemand(newDemand);

            // Apply discount only if demand >= 10
            if (this.items[i].getDemand() >= 10) {

                float oldPrice = this.items[i].getPrice();
                float newPrice = oldPrice;

                if (this.items[i].getCondition().equals(Gadget.COND_GOOD)) {
                    newPrice = oldPrice * 0.85f;
                }

                else if (this.items[i].getCondition().equals(Gadget.COND_MINT)) {
                    newPrice = oldPrice * 0.90f;
                }

                else if (this.items[i].getCondition().equals(Gadget.COND_LIKE_NEW)) {
                    newPrice = oldPrice * 0.95f;
                }

                this.items[i].setPrice(newPrice);
                this.items[i].setDemand(this.items[i].getDemand() - 10);
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
    public void transact(Product item) {
        this.sales += item.getPrice();
        remove(item);
        purchaseHandler(item);
    }
    @Override
    public void viewProducts() {
        System.out.println(this.name);
        for (int i = 0; i < this.items.length; i++) {
            System.out.println();
            System.out.println("Item " + ((Gadget)this.items[i]).getItemNumber() +": ");
            System.out.println("Brand: " + this.items[i].brand);
            System.out.println("Model: " + this.items[i].model);
            System.out.println("Price: " + this.items[i].price);
            System.out.println("Condition: " + this.items[i].condition);
            System.out.println("Classification: " + this.items[i].classification);
            System.out.println("Demand Points: " + this.items[i].demand);
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
