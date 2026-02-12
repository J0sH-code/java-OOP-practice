package comprog_acts.act_2;

public class Baker {
    private String name;
    private String status = "waiting";
    private int breadStock = 0;
    private int fatigue = 0;

    public Baker(String name) {
        this.name = name;
        updateStatus();
    }

    boolean sellBread (Customer customer) {
        if (status.toLowerCase().equals("resting")) {
            System.out.println("Baker is resting and cannot sell right now....");
        }

        if (canSellto(customer)) {
            this.breadStock -= 10;
            this.fatigue += 5;
            this.status = (canSellto(customer)) ? "served" : this.status;
            customer.payAndEat();
            return true;  
        }
        
        return false;
    }

    boolean canSellto (Customer customer) {
        if (!customer.getStatus().equals("waiting")) {
            return false;
        }

        if (!this.status.equals("waiting")) {
            return false;
        }

        if (this.breadStock < 10) {
            return false;
        }

        if (!customer.hasEnoughMoney()) {
            return false;
        }

        if (this.fatigue > 30) {
            return false;
        }

        return true;
    }

    void updateStatus () {
        this.status = (this.fatigue < 30) ? "waiting" : this.status;
        this.status = (this.fatigue >= 30) ? "resting" : this.status;
    }

    String getName () {
        return this.name;
    }

    String getStatus () {
        return this.status;
    }

    void bakeBread() {
        if (!status.toLowerCase().equals("resting")) {
            this.breadStock += 10;
            this.fatigue += 5;   
        } else {
            System.out.println("Baker is resting and cannot bake right now....");
        }
        updateStatus();
    }

    void rest() {
        this.fatigue -= 15;

        updateStatus();
    }

}
