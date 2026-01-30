package class_relationships;

public class Abstraction {
    public static void main(String[] args) {
        var car = new Car("Honda", "Sedan", "Blue");
        car.go();
    }
}

abstract class Vehicle {
    final String brand;
    final String type;
    final String color;

    public Vehicle(String brand, String type, String color){
        this.brand = brand;
        this.type = type;
        this.color = color;
    }

    abstract void go();
    abstract void stop();
}

class Car extends Vehicle {

    public Car(String brand, String type, String color) {
        super(brand, type, color);
    }
    
    @Override
    void go(){
        System.out.println("Car is on GO zoom! zoom!");
    }

    @Override
    void stop(){
        System.out.println("Car is STOPPING shreek! shreek!");
    }
}

