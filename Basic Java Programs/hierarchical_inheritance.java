// PROGRAM TO DEMONSTRATE HIERARCHICAL INHERITANCE

// Base class or parent class
class Parent {
    void parentMethod() {
        System.out.println("This is the parent class.");
    }
}

// First child class
class Child1 extends Parent {
    void child1Method() {
        System.out.println("This is child1 class.");
    }
}

// Second child class
class Child2 extends Parent {
    void child2Method() {
        System.out.println("This is child2 class.");
    }
}

// Main class for testing hierarchical inheritance
class SampleHierarchical {
    public static void main(String[] args) {
        // Create object of Child1
        Child1 obj1 = new Child1();
        obj1.parentMethod();    // Method from Parent class
        obj1.child1Method();    // Method from Child1 class

        // Create object of Child2
        Child2 obj2 = new Child2();
        obj2.parentMethod();    // Method from Parent class
        obj2.child2Method();    // Method from Child2 class
    }
}
