// PROGRAM TO CREATE A CLASS DEMO CONTAINING ONE FUNCTION F1 with an integer variable
import java.util.*;
import java.io.*;
class sample5
{
    public static void main(String[] args)
    {
       demo obj = new demo(); // Object Creation
       obj.f1(); // Object invoking the function in class demo (f1)
    }
}
class demo {
    void f1(){
        int x = 45;
        System.out.println("x = " + x);
    }
}
