// PROGRAM to demonstrate function/method overloading.
import java.util.*;
import java.io.*;
class sample9
{
    public static void main(String[] args)
    {
       overloaddemo obj=new overloaddemo();
       obj.f1();
       obj.f1(5);
       obj.f1(6,8);
    }
}
class overloaddemo
{
    void f1()
    {
        System.out.println("First function call has no parameter");
    }
    void f1(int x)
    {
        System.out.println("One parameter: " + x);
    }
    void f1(int x,int y)
    {
        System.out.println("Two parameters: X = " + x + "," + "Y = " + y);
    }
}


