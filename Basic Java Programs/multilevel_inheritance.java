// PROGRAM TO DEMONSTRATE MULTI-LEVEL INHERITANCE

// Base class or parent class
class GrandParent {
    void gpMethod() {
        System.out.println("This is the grandparent class.");
    }
}

// Child class of GrandParent (intermediate class)
class Parent extends GrandParent {
    void parentMethod() {
        System.out.println("This is the parent class.");
    }
}

// Child class of Parent (final derived class)
class Child extends Parent {
    void childMethod() {
        System.out.println("This is the child class.");
    }
}

// Main class to test the multi-level inheritance
class SampleMultiLevel {
    public static void main(String[] args) {
        // Create object of Child class
        Child obj = new Child();
        obj.gpMethod();       // Method from GrandParent
        obj.parentMethod();   // Method from Parent
        obj.childMethod();    // Method from Child
    }
}
