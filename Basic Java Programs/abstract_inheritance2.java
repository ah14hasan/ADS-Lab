// Multiple Abstract classes and their inheritance
import java.util.*;
import java.io.*;  


abstract class A 
{
    // Abstract method
    public abstract void f2();

    // Concrete method
    public void f1() 
    {
        System.out.println("This is f1");
    }
}

abstract class B extends A
{
    // Abstract method
    public abstract void f3();

    // Concrete method - definition of A's abstract method
    public void f2() 
    {
        System.out.println("This is f2");
    }
}


class C extends B 
{
    // Concrete method - Definition of B's abstract method
    public void f3()
    {
        System.out.println("This is f3");
    }
}


// Main class to run
public class absin {
    public static void main(String[] args) 
    {
        C obj = new C();
        obj.f1();
        obj.f2();
        obj.f3();
    }
}
