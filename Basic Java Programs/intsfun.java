// PROGRAM TO CREATE A CLASS DEMO CONTAINING ONE FUNCTION and passing two integer parameters
import java.util.*;
import java.io.*;
class sample8
{
    public static void main(String[] args)
    {
       demo obj = new demo(); // Object Creation
       obj.f1(10,20); // Object invoking the function in class demo (f1) and passing the parameters 10 and 20
    }
}
class demo 
{
    void f1(int x, int y)
    {
        System.out.println("x = " + x);
        System.out.println("y = " + y);
    }
}

