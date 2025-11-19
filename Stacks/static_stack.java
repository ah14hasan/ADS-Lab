// Java program to implement a static stack
import java.util.*;
import java.io.*;
// Class to implement a static stack
class sample
{
    int[] stack = new int[5];
    int top = -1;
    void push(int x)
    {
        if(top==4)
        {
            System.out.println("Overflow");
        }
        else
        {
            top++; 
            stack[top]=x;
            System.out.println(x+" pushed"); 
        }
    }
    void pop() 
    {
        if(top==-1)
        {
            System.out.println("Underflow");
        }
        else
        {
            System.out.println(stack[top]+" popped");
            top--;
        }
    }
    void peek()
    {
        if(top==-1)
        {
            System.out.println("Stack is empty");
        }
        else
        {
            System.out.println("Top element is: "+stack[top]);
        }
    }
    void display()
    {
        if(top==-1)
        {
            System.out.println("Stack is empty");
        }
        else
        {
            System.out.print("Stack elements: ");
            for(int i=0;i<=top;i++)
            {
                System.out.print(stack[i]+" ");
            }
            System.out.println();
        }
    }
}

class stack1 
{
    public static void main(String[] args) 
    {
        sample obj=new sample(); // create stack object
        obj.push(10);
        obj.push(20);
        obj.push(30);
        obj.display();
        obj.peek();
        obj.pop();
        obj.display();
    }
}
