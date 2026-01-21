// Diamond Problem (inheritance)
import java.util.*;
import java.io.*; 
// Top-level interface
interface A {
    default void show() {
        System.out.println("Message from A (base interface)");
    }
}

// Two child interfaces forming the upper arms of the diamond
interface B extends A {
    @Override
    default void show() {
        System.out.println("Message from B (first child interface)");
    }
}

interface C extends A {
    @Override
    default void show() {
        System.out.println("Message from C (second child interface)");
    }
}

// Class at the bottom of the diamond
class D implements B, C {

    // Must override show() to resolve the diamond ambiguity
    @Override
    public void show() {
        // Explicitly choose one parent's implementation
        B.super.show();   // you can change this to C.super.show() to see the difference

        // Or you could add a custom message as well:
        // System.out.println("Message from D (resolving the diamond)");
    }

    public static void main(String[] args) {
        D obj = new D();
        obj.show();
    }
}

