package comprog_acts.act_1;

import java.util.HashMap;

public class Veterinarian {
    static int vetCount = 0;
    String name;
    String specialization;
    int yearsOfExperience;
    int stressLevel = 50;
    
    HashMap<String, Pet> assignedPets = new HashMap<>();

    public Veterinarian(String name, String specialization, int yearsOfExperience) {
        this.name = name;
        this.specialization = specialization;
        this.yearsOfExperience = yearsOfExperience;
        Veterinarian.vetCount++;
    }

    void treatPet (Pet pet) {
        pet.vet = this;
        pet.increaseHealth(25);
        pet.decreaseHunger(10);
        assignPet(pet);
        checkPetHealth(pet);
    }

    private void assignPet (Pet pet) {
        assignedPets.put(pet.name, pet);
    }

    private void checkPetHealth (Pet pet) {
        this.stressLevel = (pet.healthLevel >= 100) ? this.stressLevel-=10 : this.stressLevel;
    }
}
