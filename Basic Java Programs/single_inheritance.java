// PROGRAM TO DEMONSTRATE SINGLE INHERITANCE - one child taking properties of one parent
import java.util.*;
import java.io.*;  
// base class or parent class
class Parent {
    void f1() {
        System.out.println("This is the parent class.");
    }
}
// "extends" means child class (derived class) taking all the properties of parent class (functions of parent class)
class Child extends Parent {
    void f2() {
        System.out.println("This is the child class.");
    }
}
// main class
class sample11 {
    public static void main(String[] args) {
        // Create an object of Child class
        Child obj = new Child(); // obj now has access to both f1() and f2()
        obj.f1(); // Call method from Parent class
        obj.f2(); // Call method from Child class
    }
}
