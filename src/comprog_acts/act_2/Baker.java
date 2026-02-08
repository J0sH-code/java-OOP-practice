package comprog_acts.act_2;

public class Baker {
    private String name;
    private String status = "waiting";
    private int breadStock = 0;
    private int fatigue = 0;

    public Baker(String name) {
        this.name = name;
    }

    boolean sellBread (Customer customer) {
        return false;
    }

    boolean canSellto (Customer customer) {
        return false;
    }

    void updateStatus () {
        
    }

    String getName () {
        return this.name;
    }

    String getStatus () {
        return this.status;
    }

    void bakeBread() {
        this.breadStock += 10;
        this.fatigue += 5;
    }

    void rest() {

    }

}
