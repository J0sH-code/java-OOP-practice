package comprog_acts.act_1;

import java.util.ArrayList;
import java.util.Scanner;


public class Main {
    static Scanner scanner = new Scanner(System.in);

    static ArrayList<Pet> pets = new ArrayList<>();
    static Pet sally = new Pet("sally", "shihtzu", null);
    static Pet max = new Pet("max", "terrier", null);
    static Pet hershey = new Pet("hershey", "labrador", null);
    static Pet brixx = new Pet("brixx", "chao-chao", null);

    static Veterinarian josh = new Veterinarian("josh", "k9 Veterinarian", 8);
    public static void main(String[] args) throws Exception {
        pets.add(sally);
        pets.add(max);
        pets.add(hershey);
        pets.add(brixx);
        
        Test.testPlay(brixx);
        System.out.println();

        Test.testSick(brixx);
        System.out.println();

        Test.testTreatment(josh, max);
        System.out.println();

        Test.testTreatment(josh, brixx);
    } 
}
