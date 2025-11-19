// Java program to implement a dynamic queue
import java.util.*;
import java.io.*;

// Class to implement a dynamic queue
class Sample 
{
    int[] queue;  // array to store queue elements
    int front = -1, rear = -1, size;

    // Constructor to set the queue size dynamically
    Sample(int n) 
    {
        size = n;
        queue = new int[size];
    }

    // Enqueue operation
    void enqueue(int x) 
    {
        if (rear == size - 1) // check for overflow
        {
            System.out.println("Overflow! Cannot enqueue " + x);
        } 
        else // insert element
        {
            if (front == -1) front = 0; // first element
            rear++;
            queue[rear] = x;
            System.out.println(x + " enqueued");
        }
    }

    // Dequeue operation
    void dequeue() 
    {
        if (front == -1 || front > rear) // check for underflow
        {
            System.out.println("Underflow! Queue is empty");
        } 
        else 
        {
            System.out.println(queue[front] + " dequeued");
            front++;
        }
    }

    // Peek operation (front element)
    void peek() 
    {
        if (front == -1 || front > rear) 
        {
            System.out.println("Queue is empty");
        } 
        else 
        {
            System.out.println("Front element is: " + queue[front]);
        }
    }

    // Display all queue elements
    void display() 
    {
        if (front == -1 || front > rear) // check if queue is empty
        {
            System.out.println("Queue is empty");
        } 
        else 
        {
            System.out.print("Queue elements: ");
            for (int i = front; i <= rear; i++) 
            {
                System.out.print(queue[i] + " ");
            }
            System.out.println();
        }
    }
}

// Main class to test the dynamic queue
class q2 
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in); // create scanner object

        System.out.print("Enter size of queue: "); // prompt user for size
        int n = sc.nextInt(); // read size from user
        Sample q = new Sample(n); // create queue of size n

        while (true) 
        {
            System.out.println("\n1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. Peek");
            System.out.println("4. Display");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) // handle user choice
            {
                case 1:
                    System.out.print("Enter element to enqueue: ");
                    int x = sc.nextInt();
                    q.enqueue(x);
                    break;

                case 2:
                    q.dequeue();
                    break;

                case 3:
                    q.peek();
                    break;

                case 4:
                    q.display();
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
