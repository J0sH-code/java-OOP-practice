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
     1. Initiialize 
        - initialHealth
        - initialHunger
        - newHealth (null)
        - newHunger (null)
     2. @pet.play() initializes play method
     3. Initialize value of @newHunger and @newHealth
     4. Test success if initialHealth is greater than newHealth and initialHunger is less than newHunger
    */
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

        System.out.println("Initial health: " + initialHealth + " | New health: " + newHealth);
        System.out.println("Initial Treatment Count: " + initialTreatmentCount + " | New Treatment Count: " + newTreatmentCount);

        if (pet.isSick == true && initialHealth > newHealth && initialTreatmentCount < newTreatmentCount) {
            testSuccess("testSick");
        } else {
            testFail("testSick");
        }
    }

    static void testTreatment (Veterinarian vet, Pet pet){
        int pet_initialHealth = pet.healthLevel;
        int pet_initialHunger = pet.hungerLevel;
        int pet_newHealth;
        int pet_newHunger;

        int vet_initialStress = vet.stressLevel;

        vet.treatPet(pet);
        pet_newHealth = pet.healthLevel;
        pet_newHunger = pet.hungerLevel;

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
}
