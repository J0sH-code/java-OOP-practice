package marketplace;


public class Marketplace extends Shop {
    public Marketplace (String name) {
        super(name);
    }

    /*
     * Overrides the add method,
     * Checks the current items list and creates a new 
     * instance of this.items that copies its old state and adds the new item
     */
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

    /**
     * Removes a product from the marketplace inventory.
     *
     * Steps performed:
     * 1. Store the current list of items in a temporary array.
     * 2. Create a new array with a size reduced by one.
     * 3. Determine the index of the product to remove.
     * 4. Copy all elements before the removed item.
     * 5. Shift elements after the removed item one position to the left.
     * 6. Decrement the item counter to reflect the updated inventory size.
     */
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

    //Searches for the index of item in product list, used for remove method
    private int findItemIndex (Product[] list, Product item) {
        for (int i = 0; i < list.length; i++) {
            if (item == list[i]) {
                return i;
            }
        }
        return 0;
    }

    /**
     * Handles the effects of a product purchase within the marketplace.
     *
     * When a product is purchased, all items with the same classification
     * will have their demand increased. If the demand of an item reaches
     * a threshold of 10 or more, a price discount is applied based on
     * the product's condition.
     *
     * Discount rules:
     * - GOOD condition: 15% discount
     * - MINT condition: 10% discount
     * - LIKE_NEW condition: 5% discount
     *
     * After the discount is applied, the demand is reduced by 10 to reset
     * the demand cycle.
     *
     * @param boughtItem the product that has been purchased
     */
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
                    } else if (this.items[i].getCondition().equals(Gadget.COND_MINT)) {
                        newPrice = oldPrice * 0.90f;
                    } else if (this.items[i].getCondition().equals(Gadget.COND_LIKE_NEW)) {
                        newPrice = oldPrice * 0.95f;
                    }

                    this.items[i].setPrice(newPrice);
                    this.items[i].setDemand(this.items[i].getDemand() - 10);
                }
            }
        }
    }

    //Searches items list to find item product, returns true if found
    @Override
    protected boolean find(Product item) {
        for (int i = 0; i < this.items.length; i++) {
            if (this.items[i] == item) {
                return true;
            }
        }
        return false;
    }

    //Removes item from list and purchases the item
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

    //Getter for marketplace name
    @Override
    public String getName() {
        return super.name;
    }

    //Getter for marketplace sales
    @Override
    protected float getSales() {
        return super.sales;
    }

    //Getter for marketplace items
    public Product[] getItems() {
        return this.items;
    }
}
