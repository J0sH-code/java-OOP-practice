package comprog_acts.act_1;

public class Pet {
    static int petCount = 0;

    int healthLevel = 70;
    int hungerLevel = 40;
    int treatmentCount = 0;
    
    boolean isSick = false;
    
    String name;
    String breed;
    Veterinarian vet;

    public Pet(String name, String breed, Veterinarian vet) {
        this.name = name;
        this.breed = breed;
        this.vet = vet;

        Pet.petCount++;

        healthCeiling();
    }
    private void decreaseHealth(int value) {
        this.healthLevel-=value;
    }

    private void increaseHunger (int value) {
        this.hungerLevel+=value;
    }

    private void healthCeiling () {
        this.healthLevel = (this.healthLevel > 100) ? 100 : this.healthLevel;
    }

    void play() {
        increaseHunger(10);
        decreaseHealth(15);
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
}
