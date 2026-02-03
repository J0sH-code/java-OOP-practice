package comprog_acts.act_1;

import java.util.HashMap;

public class Veterinarian {
    static int vetCount = 0;
    String name;
    String specialization;
    int yearsOfExperience;

    private int stressLevel = 50;
    
    HashMap<String, Pet> assignedPets = new HashMap<>();

    public Veterinarian(String name, String specialization, int yearsOfExperience) {
        stressFloor();
        this.name = name;
        this.specialization = specialization;
        this.yearsOfExperience = yearsOfExperience;
        Veterinarian.vetCount++;
    }

    void treatPet (Pet pet) {
        if (checkPetStatus(pet) == true) {
            System.out.println();
            System.out.println("***" + pet.name + " is not sick***");
            return;
        }
        assignPet(pet);
        pet.recieveTreatment();
        checkPetHealth(pet);
    }

    void state (){
        System.out.println();
        System.out.println("Vet name: " + this.name);
        System.out.println("Vet specialization: " + this.specialization);
        System.out.println("Vet years of experience: " + this.yearsOfExperience + "yrs");
        System.out.println("Vet stress level: " + this.stressLevel);
        System.out.println("Assigned pets: " + assignedPets.keySet());
        System.out.println();
    }

    private boolean checkPetStatus (Pet pet) {
        return (pet.isSick == false);
    }

    private void assignPet (Pet pet) {
        assignedPets.put(pet.name, pet);
        pet.vet = this;
    }

    private void checkPetHealth (Pet pet) {
        this.stressLevel = (pet.getHealthLevel() >= 100) ? this.stressLevel-=10 : this.stressLevel;
        stressFloor();
    }

    final void stressFloor () {
        this.stressLevel = (this.stressLevel < 0) ? this.stressLevel = 0 : this.stressLevel;
    }

    public int getStressLevel() {
        return this.stressLevel;
    }

    public int setStressLevel(int stressLevel) {
        return this.stressLevel = stressLevel;
    }
}
