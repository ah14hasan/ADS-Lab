// PROGRAM TO CREATE A CLASS DEMO CONTAINING ONE FUNCTION and passing an integer parameter
import java.util.*;
import java.io.*;
class sample7
{
    public static void main(String[] args)
    {
       demo obj = new demo(); // Object Creation
       obj.f1(10); // Object invoking the function in class demo (f1) and passing the parameter 10
    }
}
class demo {
    void f1(int x){
        System.out.println("x = " + x);
    }
}
