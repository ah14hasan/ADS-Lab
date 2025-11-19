// Java program to implement a static queue
import java.util.*;
import java.io.*;

// Class to implement a static queue
class Sample {
    int[] queue = new int[5];  // fixed size of queue
    int front = -1, rear = -1;

    // Enqueue operation
    void enqueue(int x) {
        if (rear == 4) {
            System.out.println("Overflow");
        } else {
            if (front == -1) front = 0;  // first element
            rear++;
            queue[rear] = x;
            System.out.println(x + " enqueued");
        }
    }

    // Dequeue operation
    void dequeue() {
        if (front == -1 || front > rear) {
            System.out.println("Underflow");
        } else {
            System.out.println(queue[front] + " dequeued");
            front++;
        }
    }

    // Peek operation (front element)
    void peek() {
        if (front == -1 || front > rear) {
            System.out.println("Queue is empty");
        } else {
            System.out.println("Front element is: " + queue[front]);
        }
    }

    // Display all queue elements
    void display() {
        if (front == -1 || front > rear) {
            System.out.println("Queue is empty");
        } else {
            System.out.print("Queue elements: ");
            for (int i = front; i <= rear; i++) {
                System.out.print(queue[i] + " ");
            }
            System.out.println();
        }
    }
}

// Main class to test the queue implementation
class q1 {
    public static void main(String[] args) {
        Sample q = new Sample();

        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        q.display();
        q.peek();
        q.dequeue();
        q.display();
    }
}
