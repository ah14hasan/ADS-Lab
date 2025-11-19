// PROGRAM TO DEMONSTRATE METHOD OVERRIDING

// Superclass (Parent)
class Animal {
    void sound() {
        System.out.println("Animal makes a sound.");
    }
}

// Subclass (Child) overriding the sound() method
class Dog extends Animal {
    @Override
    void sound() {
        System.out.println("Dog barks.");
    }
}

// Main class to test method overriding
class MethodOverridingDemo {
    public static void main(String[] args) {
        Animal a = new Animal();
        a.sound(); // Calls Animal's sound()
        
        Dog d = new Dog();
        d.sound(); // Calls Dog's overridden sound()
    }
}
