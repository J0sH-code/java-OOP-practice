package customer;

import marketplace.*;

public class Customer {
	protected String name;
	protected String address;
	protected String number;
	protected float coins;
	protected Product[] items;
	protected int itemCounter;
	public final static int MAX_PRODUCTS = 3;
	
	public Customer(String name, String address, String number, float coins) {
		this.name = name;
		this.address = address;
		this.number = number;
		this.coins = coins;
		this.items = new Product[0];
    	this.itemCounter = 0; 
	}

	protected boolean canAfford(Product item) {
		return (this.coins >= item.getPrice());
	}
	
	/*
	 * The function below should contain the logic of the buy method of a customer,
	 * complete the method below and make use of the following commands as you construct the flow of your algorithm:
	 *
	 * At the start of a transaction print the following
	 * System.out.println("**LOG: Customer " + this.name + " is trying to buy " + item.getName() + " from " + marketplace.getName() + ".");
	 * 
	 * After a successful purchase print the following:
	 * System.out.println("**LOG: The item " + item.getName() + " was successfully bought by customer " + this.getName() + ".");
	 * 
	 * If purchase invalid due to insufficient fund print the following:
	 * System.out.println("**LOG: " + item.getName() + " cannot be purchased because of insufficient funds.");
	 * 
	 * If item is not in the marketplace print the following:
	 * System.out.println("**LOG: The item " + item.getName() + " is not available in the " + marketplace.getName() + ".");	
	 * 
	 * If customer reached the max product purchase print the following:
	 * System.out.println("**LOG: Maximum number of products is reached.");
	 */

	public void buy(Product item, Marketplace marketplace){
		System.out.println("**LOG: Customer " + this.name + " is trying to buy " + item.getName() + " from " + marketplace.getName() + ".");

		if (!maxItemValidate(itemCounter, MAX_PRODUCTS)) {
			System.out.println("**LOG: Maximum number of products is reached.");
		}

		if (!canAfford(item)) {
			System.out.println("**LOG: " + item.getName() + " cannot be purchased because of insufficient funds.");
		}

		if (!itemValidate(item, marketplace)) {
			System.out.println("**LOG: The item " + item.getName() + " is not available in the " + marketplace.getName() + ".");
		}

		if (itemValidate(item, marketplace) && canAfford(item) && maxItemValidate(this.itemCounter, MAX_PRODUCTS)) {
			this.coins -= item.getPrice();
			this.itemCounter++;
			marketplace.transact(item);
			addItem(itemCounter, item);
			System.out.println("**LOG: The item " + item.getName() + " was successfully bought by customer " + this.getName() + ".");
		}
	}

	private boolean itemValidate (Product item, Marketplace marketplace) {
		for (int i = 0; i < marketplace.getItems().length; i++) {
			if (marketplace.getItems()[i] == item) {
            	return true;
        	}
		}
		return false;
	}

	private boolean maxItemValidate (int itemCounter, int MAX_PRODUCTS) {
		return (itemCounter < MAX_PRODUCTS);
	}

	private void addItem (int itemCounter, Product item) {
		Product[] prevItems = this.items;
		this.items = new Product[itemCounter];

		if (this.itemCounter == 1) {
			this.items[0] = item;
		} 

		if (this.itemCounter > 1) {
            System.arraycopy(prevItems, 0, this.items, 0, prevItems.length);
			this.items[itemCounter-1] = item;
		}
	}
	
	// DO NOT MODIFY THIS METHOD
	public void viewState() {
		System.out.println("\n==========[ CUSTOMER STATE ]==========");
		System.out.println("\tName: "+this.name);
		System.out.println("\tAddress: "+this.address);
		System.out.println("\tMobile Number: "+this.number);
		System.out.println("\tShopping Coins: "+this.coins);
		System.out.println("\n\tPurchases: ");

		if (this.items.length > 0) {
			for(int i=0; i<this.items.length; i++) {
				if(this.items[i] != null) {
					System.out.println("\n\tItem " + (i+1) + ": ");
					this.items[i].viewInfo();					
				}
			}	
		} else System.out.println("\tCustomer hasn't purchased any item.");
		
		System.out.println("======================================");
	}

	public String getName() {
		return this.name;
	}
}