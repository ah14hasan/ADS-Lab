// Java program to implement a dynamic stack
import java.util.*;
import java.io.*;

// Class to implement a dynamic stack
class Sample {
    int[] stack;
    int top = -1;
    int size;

    // Constructor to set stack size dynamically
    Sample(int n) 
    {
        size = n;
        stack = new int[size];
    }

    void push(int x) 
    {
        if (top == size - 1) 
        {
            System.out.println("Overflow! Cannot push " + x);
        } 
        else 
        {
            top++;
            stack[top] = x;
            System.out.println(x + " pushed");
        }
    }

    void pop() 
    {
        if (top == -1) 
        {
            System.out.println("Underflow! Stack is empty");
        } 
        else 
        {
            System.out.println(stack[top] + " popped");
            top--;
        }
    }

    void peek() 
    {
        if (top == -1) 
        {
            System.out.println("Stack is empty");
        } 
        else 
        {
            System.out.println("Top element is: " + stack[top]);
        }
    }

    void display() 
    {
        if (top == -1) 
        {
            System.out.println("Stack is empty");
        } 
        else 
        {
            System.out.print("Stack elements: ");
            for (int i = 0; i <= top; i++) 
            {
                System.out.print(stack[i] + " ");
            }
            System.out.println();
        }
    }
}

// Main class to test the dynamic stack
class stack2 
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in); // create scanner object

        System.out.print("Enter size of stack: ");
        int n = sc.nextInt(); // read size from user
        Sample obj = new Sample(n); // create stack of size n

        while (true) 
        {
            System.out.println("\n1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Peek");
            System.out.println("4. Display");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt(); // read user choice

            switch (choice) 
            {
                case 1:
                    System.out.print("Enter element to push: ");
                    int x = sc.nextInt();
                    obj.push(x);
                    break;

                case 2:
                    obj.pop();
                    break;

                case 3:
                    obj.peek();
                    break;

                case 4:
                    obj.display();
                    break;

                case 5:
                    System.out.println("Exiting...");
                    sc.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }
}
