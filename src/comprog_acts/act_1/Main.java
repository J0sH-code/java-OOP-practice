package comprog_acts.act_1;

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    static Pet sally = new Pet("sally", "shihtzu", null);
    static Pet max = new Pet("max", "terrier", null);
    static Pet hershey = new Pet("hershey", "labrador", null);
    static Pet brixx = new Pet("brixx", "chao-chao", null);

    static Veterinarian josh = new Veterinarian("josh", "k9 Veterinarian", 8);
    public static void main(String[] args) throws Exception {
        testPlay(brixx);
        System.out.println();
        testSick(brixx);
        
    }

    private static void testSuccess(String testName) {
        System.out.println(testName + " - passed /");
    }

    private static void testFail(String testName) {
        System.out.println(testName + " - failed X");
    }

    static void testPlay (Pet pet) {
        int initialHealth = pet.healthLevel;
        int initialHunger = pet.hungerLevel;
        int newHealth;
        int newHunger;

        pet.play();
        newHealth = pet.healthLevel;
        newHunger = pet.hungerLevel;

        System.out.println("Initial health: " + initialHealth + " | New health: " + newHealth);
        System.out.println("Initial hunger: " + initialHunger + " | New hunger: " + newHunger);

        if (initialHealth > newHealth && initialHunger < newHunger) {
            testSuccess("testPlay");
        } else {
            testFail("testPlay");
        }
    }

    static void testSick (Pet pet) {
        int initialHealth = pet.healthLevel;
        int initialTreatmentCount = pet.treatmentCount;
        int newHealth;
        int newTreatmentCount;

        pet.isSick();
        newHealth = pet.healthLevel;
        newTreatmentCount = pet.treatmentCount;

        System.out.println("Initial health: " + initialHealth + "| New health: " + newHealth);
        System.out.println("Initial Treatment Count: " + initialTreatmentCount + "| New Treatment Count: " + newTreatmentCount);

        if (pet.isSick == true && initialHealth > newHealth && initialTreatmentCount < newHealth) {
            testSuccess("testSick");
        } else {
            testFail("testSick");
        }
    }
}
