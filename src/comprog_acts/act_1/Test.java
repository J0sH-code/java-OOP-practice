package comprog_acts.act_1;

public class Test {
    private static void testSuccess(String testName) {
        System.out.println(testName + " - passed /");
    }

    private static void testFail(String testName) {
        System.out.println(testName + " - failed X");
    }

    /* 
    - Tests the play method of pet object -
    This is vital in testing whether the pet object's health level is decreased and its hunger level increased.
    If the condition is met, the test is passed.
    */
    static void testPlay (Pet pet) {
        int initialHealth = pet.getHealthLevel();
        int initialHunger = pet.getHungerLevel();
        int newHealth;
        int newHunger;

        pet.play();
        newHealth = pet.getHealthLevel();
        newHunger = pet.getHungerLevel();

        System.out.println("Initial health: " + initialHealth + " | New health: " + newHealth);
        System.out.println("Initial hunger: " + initialHunger + " | New hunger: " + newHunger);

        if (initialHealth > newHealth && initialHunger < newHunger) {
            testSuccess("testPlay");
        } else {
            testFail("testPlay");
        }
    }

    /* 
    - Tests the play method of pet object -
    This is vital in testing whether the pet object is sick and its health level is decreased and its treatment count increased.
    If the condition is met, the test is passed.
    */
    static void testSick (Pet pet) {
        int initialHealth = pet.getHealthLevel();
        int initialTreatmentCount = pet.getTreatmentCount();
        int newHealth;
        int newTreatmentCount;

        pet.isSick();
        newHealth = pet.getHealthLevel();
        newTreatmentCount = pet.getTreatmentCount();

        System.out.println("Initial health: " + initialHealth + " | New health: " + newHealth);
        System.out.println("Initial Treatment Count: " + initialTreatmentCount + " | New Treatment Count: " + newTreatmentCount);

        if (pet.isSick == true && initialHealth > newHealth && initialTreatmentCount < newTreatmentCount) {
            testSuccess("testSick");
        } else {
            testFail("testSick");
        }
    }

     /* 
    - Tests the treatment method of veterinarian object -
    This is vital in testing whether the pet object is added to the veterinarian object's assigned list of pets.
    It also checks whether the pet's health level increased and its hunger level decreased.

    If pet is not sick, it checks whether pet's health level and hunger level is unchanged, and that the veterinarian object's assigned list of pets is also unchanged.
    If all the conditions are met, the test is passed.
    */
    static void testTreatment (Veterinarian vet, Pet pet){
        int pet_initialHealth = pet.getHealthLevel();
        int pet_initialHunger = pet.getHungerLevel();
        int pet_newHealth;
        int pet_newHunger;

        int vet_initialStress = vet.getStressLevel();

        vet.treatPet(pet);
        pet_newHealth = pet.getHealthLevel();
        pet_newHunger = pet.getHungerLevel();

        if (pet.isSick == false) {
            String treatmentStatus = (vet.assignedPets.isEmpty()) ? "Empty" : "Not-empty";

            System.out.println("Initial health: " + pet_initialHealth + " | New health: " + pet_newHealth);
            System.out.println("Initial hunger: " + pet_initialHunger + " | New hunger: " + pet_newHunger);
            System.out.println("Vet treatment list status: " + treatmentStatus);
            if (pet_initialHealth == pet_newHealth && pet_initialHunger == pet_newHunger && vet.assignedPets.isEmpty()) {
                testSuccess("TestTreatment");
            } else {
                testFail("TestTreatment");
            }
            return;
        }
        
        System.out.println("Initial health: " + pet_initialHealth + " | New health: " + pet_newHealth);
        System.out.println("Initial hunger: " + pet_initialHunger + " | New hunger: " + pet_newHunger);
        System.out.println("Added pet to treatment: " + vet.assignedPets.get(pet.name).name);

        if (pet_initialHealth < pet_newHealth && pet_initialHunger > pet_newHunger && vet.assignedPets.containsValue(pet)) {
            testSuccess("TestTreatment");
        } else {
            testFail("TestTreatment");
        }
    }

     /* 
    - Tests the limiters/floor methods of pet and veterinarian objects -
    This is to know whether pet's health does not exceed 100 and veterinarian's stress level does not plummet below 0
    If conditions are met, the test is passed.
    */
    static void testLimiters (Pet pet, Veterinarian vet) {
        int petMaxHealth = pet.setHealthLevel(105);
        int vetMinStress = vet.setStressLevel(-15);

        pet.healthLimit();
        vet.stressFloor();
        int petHealth = pet.getHealthLevel();
        int vetStress = vet.getStressLevel();

        System.out.println("Overriden health: " + petMaxHealth + " | Actual pet health: " + petHealth);
        System.out.println("Overriden vet stress level: " + vetMinStress + " | Actual vet stress level: " + vetStress);

        if (petHealth <= 100 && vetStress >= 0) {
            testSuccess("testLimiters");
        } else {
            testFail("testLimiters");
        }
    }
}
