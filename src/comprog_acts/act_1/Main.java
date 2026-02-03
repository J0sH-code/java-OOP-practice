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
    
    static boolean running = true;
    public static void main(String[] args) throws Exception {
        pets.put(sally.name, sally);
        pets.put(max.name, max);
        pets.put(hershey.name, hershey);
        pets.put(brixx.name, brixx);

        vets.put(josh.name, josh);
        vets.put(zoey.name, zoey);
        while (running) { 
            mainView();
        }
    }
    
    static void mainView() {
        System.out.println();
        System.out.println("--------------------------------------------------");
        userOptions();
    }

    static void userOptions() {
        System.out.println("""
                1. Test Pet Play Function | 2. Test Pet Sickness function | 3. Test Vet Treatment function | 4. Test limiters | 
                5. Check Pet State | 6. Check Vet State | 7. Check object counters | *Press any other number to exit*
                """);
        System.out.print("Enter selection: ");
        int userInput = scanner.nextInt(); 
        System.out.println();
        inputHandler(userInput);       
    }

    static void inputHandler(int userInput) {
        switch (userInput) {
            case 1 -> {
                String petName = UiSelectPet();
                Test.testPlay(pets.get(petName));
            }
            case 2 -> {
                String petName = UiSelectPet();
                Test.testSick(pets.get(petName));
            }
            case 3 -> {
                String petName = UiSelectPet();
                String vetName = UiSelectVet();
                Test.testTreatment(vets.get(vetName), pets.get(petName));
            }
            case 4 -> {
                String petName = UiSelectPet();
                String vetName = UiSelectVet();
                Test.testLimiters(vets.get(vetName), pets.get(petName));
            }
            case 5 -> {
                String petName = UiSelectPet();
                pets.get(petName).state();
            }
            case 6 -> {
                String vetName = UiSelectVet();
                vets.get(vetName).state();
            }
            case 7 -> {
                System.out.println();
                System.out.println("Number of vets: " + Veterinarian.vetCount);
                System.out.println("Number of pets: " + Pet.petCount);
                System.out.println();
            }
            default -> {
                System.exit(0);
            }
        }
    }

    static String UiSelectPet() {
        System.out.println();
        System.out.println("Select pet name to test");
        showPetsList();
        System.out.println();
        System.out.print("Enter pet name: ");
        String petName = scanner.next();
        return petName;
    } 

    static String UiSelectVet() {
        System.out.println();
        System.out.println("Select vet name to test");
        showVetsList();
        System.out.println();
        System.out.print("Enter vet name: ");
        String vetName = scanner.next();
        return vetName;
    }

    static void showVetsList() {
        System.out.println("-List of vets-");
        System.out.println(vets.keySet());
    }

    static void showPetsList () {
        System.out.println("-List of pets-");
        System.out.println(pets.keySet());
    }

}
