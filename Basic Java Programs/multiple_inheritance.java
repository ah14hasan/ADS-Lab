// PROGRAM TO DEMONSTRATE MULTIPLE INHERITANCE USING INTERFACES

// First interface
interface InterfaceA {
    void methodA();
}

// Second interface
interface InterfaceB {
    void methodB();
}

// Class implementing both interfaces (multiple inheritance)
class MultipleInheritanceDemo implements InterfaceA, InterfaceB {
    public void methodA() {
        System.out.println("Method from InterfaceA.");
    }
    public void methodB() {
        System.out.println("Method from InterfaceB.");
    }
}

// Main class to test multiple inheritance
class MainClass {
    public static void main(String[] args) {
        MultipleInheritanceDemo obj = new MultipleInheritanceDemo();
        obj.methodA(); // Method from InterfaceA
        obj.methodB(); // Method from InterfaceB
    }
}
