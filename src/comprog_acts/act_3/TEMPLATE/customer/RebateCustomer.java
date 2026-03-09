package customer;

import marketplace.Marketplace;
import marketplace.Product;

public class RebateCustomer extends Customer{

    private static final float rebatePower = (float) 0.05;

    public RebateCustomer(String name, String address, String number, float coins) {
        super(name, address, number, coins);
    }

    //Calls the buy method and adds the accumulated rebate coins to this.coins 
    @Override
    public void buy(Product item, Marketplace marketplace) {
        super.buy(item, marketplace);
        this.coins+=rebateCoins(rebatePower, item);
    }

    //Returns the amount of rebate coins
    private float rebateCoins (float rebatePower, Product item) {
        return (item.getPrice() * rebatePower);
    }

}
