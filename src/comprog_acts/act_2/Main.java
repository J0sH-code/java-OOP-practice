package comprog_acts.act_2;

public class Main {
    public static void main(String[] args){
        var baker = new Baker("Pedro");
        var customer = new Customer("Juan");
        
        baker.bakeBread();
        baker.bakeBread();
        customer.work();
        customer.work();

        boolean success = baker.sellBread(customer);

        System.out.println("Transaction success: " + success);
        System.out.println("Baker status: " + baker.getStatus());
        System.out.println("Customer status: " + customer.getStatus());
    }
}
