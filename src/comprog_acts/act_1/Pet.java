package comprog_acts.act_1;

public class Pet {
    static int petCount = 0;

    private int healthLevel = 70;
    private int hungerLevel = 40;
    private int treatmentCount = 0;
    
    boolean isSick = false;
    
    String name;
    String breed;
    Veterinarian vet;

    public Pet(String name, String breed, Veterinarian vet) {
        healthLimit();
        this.name = name;
        this.breed = breed;
        this.vet = vet;

        Pet.petCount++;
    }
    
    void state() {
        String status = (isSick == false) ? "Sick" : "Healthy";
        System.out.println("Pet name: " + this.name);
        System.out.println("Pet hunger level: " + this.hungerLevel);
        System.out.println("Pet treatment count: " + this.treatmentCount);
        System.out.println("Pet status: " + status);
        System.out.println("Assigned vet: " + this.vet.name);
    }

    private void decreaseHealth(int value) {
        this.healthLevel-=value;
    }

    private void increaseHunger (int value) {
        this.hungerLevel+=value;
    }

    final void healthLimit () {
        this.healthLevel = (this.healthLevel > 100) ? 100 : this.healthLevel;
    }

    void play() {
        increaseHunger(10);
        decreaseHealth(5);
    }

    void isSick() {
        decreaseHealth(20);
        this.isSick = true;
        this.treatmentCount++;
    }

    void increaseHealth(int value) {
        this.healthLevel+=value;
    }

    void decreaseHunger (int value) {
        this.hungerLevel-= value;
    }

    public int getHealthLevel() {
        return this.healthLevel;
    }

    public int setHealthLevel(int healthLevel) {
        return this.healthLevel = healthLevel;
    }

    public int getHungerLevel() {
        return this.hungerLevel;
    }

    public int setHungerLevel(int hungerLevel) {
        return this.hungerLevel = hungerLevel;
    }

    public int getTreatmentCount() {
        return this.treatmentCount;
    }

    public int setTreatmentCount(int treatmentCount) {
        return this.treatmentCount = treatmentCount;
    }
}
