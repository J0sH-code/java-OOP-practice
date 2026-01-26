public class Association {
    public static void main(String[] args) throws Exception {

        var pra = new Product(3);
        System.out.println(pra.stock_amt);
        var jacob = new Costumer("Jacob");

        jacob.buy(pra);
        System.out.println(pra.stock_amt);
    }
}

class Product {
    int stock_amt;

    public Product(int stock_amt) {
        this.stock_amt = stock_amt;
    }
}

class Costumer {
    String name;

    public Costumer (String name) {
        this.name = name;
    }

    void buy (Product p){
        p.stock_amt -= 1; 
    }
    
}

