package comprog_acts.act_1;

public class Pet {
    String name;
    String breed;
    Veterinarian vet = new Veterinarian();

    public Pet (String name, String breed, Veterinarian vet) {
        this.name = name;
        this.breed = breed;
        this.vet = vet;
    }
}
