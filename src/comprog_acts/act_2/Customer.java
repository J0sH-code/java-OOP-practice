package comprog_acts.act_2;

public class Customer {
    public String name;
    public String status = "waiting";
    private int money;
    private int hunger = 0;

    public Customer(String name) {
        this.name = name;
        this.hunger += 10;
    }

    String getName(){
        return this.name;
    }

    String getStatus(){
        return this.status;
    }

    void work(){
        this.money += 15;
        this.hunger += 5;

        if (this.hunger >= 40) {
            updateStatus();    
        }
        
    }

    void eatBread(){
        this.hunger -= 20;

        updateStatus();
    }

    void payAndEat() {
        this.money -= 30;
        this.hunger -= 20;
        this.status = "served";
    }

    void updateStatus() {
        this.status = (this.hunger < 40) ? "waiting" : this.status;
    }

    boolean hasEnoughMoney () {
        return (this.money > 30);
    }

    boolean isWaiting () {
        return false;
    }
    
}
