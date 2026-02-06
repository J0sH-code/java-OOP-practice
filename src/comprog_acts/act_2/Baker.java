package comprog_acts.act_2;

public class Baker {
    private String name;
    private String status;
    private int breadStock;
    private int fatigue;

    public Baker(String name, String status) {
        this.name = name;
        this.status = status;
    }

    boolean sellBread (Customer customer) {
        return true;
    }

    String getName () {
        return this.name;
    }

    String getStatus () {
        return this.status;
    }

    void bakeBread() {

    }

    void rest() {

    }

}
