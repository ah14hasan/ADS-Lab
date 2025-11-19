// PROGRAM TO CREATE A CLASS DEMO CONTAINING TWO FUNCTIONS F1 and F2 with integer variables
import java.util.*;
import java.io.*;
class sample6
{
    public static void main(String[] args)
    {
       demo obj = new demo(); // Object Creation
       obj.f1(); // Object invoking the function in class demo (f1)
       obj.f2(); // Object invoking the function in class demo (f2)
    }
}
class demo {
    void f1(){
        int x = 45;
        System.out.println("x = " + x);
    }
    void f2(){
        int y = 38;
        System.out.println("y = " + y);
    }
}
