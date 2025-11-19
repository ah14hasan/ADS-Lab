// PROGRAM TO DEMONSTRATE CONSTRUCTOR OVERLOADING (i.e., multiple constructors with different parameters)
import java.util.*;
import java.io.*;

class sample10 
{
    public static void main(String[] args) {
        // Creating different objects using different constructors
        OverloadDemo obj1 = new OverloadDemo();         // No parameters
        OverloadDemo obj2 = new OverloadDemo(5);        // One parameter
        OverloadDemo obj3 = new OverloadDemo(10, 20);   // Two parameters
    }
}
class OverloadDemo {
    // Constructor 1 – no parameters
    OverloadDemo() {
        System.out.println("First constructor: No parameters");
    }

    // Constructor 2 – one parameter
    OverloadDemo(int x) {
        System.out.println("Second constructor: One parameter, x = " + x);
    }

    // Constructor 3 – two parameters
    OverloadDemo(int x, int y) {
        System.out.println("Third constructor: Two parameters, x = " + x + ", y = " + y);
    }
}
// Important Points
// 1. Class name and constructor names must be the same.
// 2. Constructors do not have a return type.
// 3. We have to create different objects to call different constructors.
