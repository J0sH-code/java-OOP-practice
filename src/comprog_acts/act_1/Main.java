package comprog_acts.act_1;

import java.util.HashMap;
import java.util.Scanner;


public class Main {
    static Scanner scanner = new Scanner(System.in);

    static HashMap<String, Pet> pets = new HashMap<>();
    static Pet sally = new Pet("sally", "shihtzu", null);
    static Pet max = new Pet("max", "terrier", null);
    static Pet hershey = new Pet("hershey", "labrador", null);
    static Pet brixx = new Pet("brixx", "chao-chao", null);

    static HashMap<String, Veterinarian> vets = new HashMap<>();
    static Veterinarian josh = new Veterinarian("josh", "k9 Veterinarian", 8);
    static Veterinarian zoey = new Veterinarian("zoey", "Puppy treatment", 4);

    public static void main(String[] args) throws Exception {
        pets.put(sally.name, sally);
        pets.put(max.name, max);
        pets.put(hershey.name, hershey);
        pets.put(brixx.name, brixx);

        vets.put(josh.name, josh);
        vets.put(zoey.name, zoey);
        showPetsList();
        
        Test.testPlay(brixx);
        System.out.println();

        Test.testSick(brixx);
        System.out.println();

        Test.testTreatment(josh, max);
        System.out.println();

        Test.testTreatment(josh, brixx);
        System.out.println();

        //Test.testLimiters(brixx, josh);
        josh.state();
    }
    
    static void userOptions() {
        System.out.println("");        
    }

    static void showVetsList() {
        
    }

    static void showPetsList () {
        System.out.println(pets);
    }

}
