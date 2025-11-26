// Hybrid Inheritance in Java
// Java does not support multiple inheritance of classes, 
// so in Java “hybrid inheritance” is usually demonstrated as a combination of class inheritance plus interfaces.​
// Here is a simple Java program that combines:
//Single/multilevel inheritance using classes
// Multiple inheritance using interfaces
import java.util.*;
import java.io.*; 

// Interfaces (used to simulate multiple inheritance)
interface CanRun {
    void run();
}

interface CanSpeak {
    void speak();
}

// Base class
class Person {
    void showPerson() {
        System.out.println("This is a person.");
    }
}

// Intermediate subclass (single / multilevel inheritance)
class Employee extends Person {
    void showEmployee() {
        System.out.println("This is an employee.");
    }
}

// Hybrid inheritance:
// Student extends a class (Employee) AND implements two interfaces (CanRun, CanSpeak)
class Student extends Employee implements CanRun, CanSpeak {

    @Override
    public void run() {
        System.out.println("Student can run.");
    }

    @Override
    public void speak() {
        System.out.println("Student can speak.");
    }

    void showStudent() {
        System.out.println("This is a student.");
    }
}

// Main class to test hybrid inheritance
class SampleHybrid {
    public static void main(String[] args) {
        Student s = new Student();

        // From Person (base class)
        s.showPerson();

        // From Employee (single / multilevel inheritance)
        s.showEmployee();

        // From Student
        s.showStudent();

        // From interfaces (multiple inheritance via interfaces)
        s.run();
        s.speak();
    }
}
