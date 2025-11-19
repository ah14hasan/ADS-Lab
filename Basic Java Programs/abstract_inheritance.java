// Abstract class and their inheritance
import java.util.*;
import java.io.*;  
// Abstract base class
abstract class Animal {
    // Abstract method
    public abstract void animalSound();

    // Concrete method
    public void sleep() {
        System.out.println("Zzz");
    }
}

// Inheriting subclass
class Dog extends Animal {
    // Implementation of abstract method
    public void animalSound() {
        System.out.println("Woof");
    }
}

// Main class to run
public class abstractDemo {
    public static void main(String[] args) {
        // You cannot instantiate Animal directly:
        // Animal a = new Animal(); // Error!

        // Instantiate subclass
        Dog dog = new Dog();
        dog.animalSound(); // Outputs: Woof
        dog.sleep();       // Outputs: Zzz
    }
}
