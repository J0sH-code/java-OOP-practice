package comprog_acts.act_2;

public class Customer {
    public String name;
    public String status = "waiting";
    private int money;
    private int hunger = 0;

    public Customer(String name) {
        this.name = name;
    }

    String getName(){
        return this.name;
    }

    String getStatus(){
        return this.status;
    }

    void work(){

    }

    void eatBread(){
        
    }

    void payAndEat() {

    }

    void updateStatus() {
        
    }

    boolean hasEnoughMoney () {
        return false;
    }

    boolean isWaiting () {
        return false;
    }
    
}
