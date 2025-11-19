// Java Program to create and display 10 nodes of a doubly circular linked list
import java.util.*;
import java.io.*;

// Node class for Doubly Circular Linked List
class DNode 
{
    int data;
    DNode prev;
    DNode next;
}

// Doubly Circular Linked List class
class DoublyCircularLinkedList 
{
    DNode first;  // class-level reference to the first node
    
    void create() 
    {
        DNode p, q;
        p = new DNode();
        p.data = 10;
        first = p;
        DNode last = p;
        for (int i = 1; i <= 9; i++) 
        {
            q = new DNode();
            q.data = 10 + i;
            last.next = q;
            q.prev = last;
            last = q;
        }
        // Complete the circular links
        last.next = first;
        first.prev = last;
    }

    void display() 
    {
        if (first == null) 
        {
            System.out.println("List is empty");
            return;
        }
        DNode temp = first;
        System.out.println("Forward Traversal:");
        do {
            System.out.print(temp.data + " <-> ");
            temp = temp.next;
        } while (temp != first);
        System.out.println("(back to first: " + first.data + ")");
    }

    void displayReverse() 
    {
        if (first == null) 
        {
            System.out.println("List is empty");
            return;
        }
        // Move to the last node
        DNode temp = first.prev;
        DNode start = temp;
        System.out.println("Backward Traversal:");
        do {
            System.out.print(temp.data + " <-> ");
            temp = temp.prev;
        } while (temp != start);
        System.out.println("(back to last: " + start.data + ")");
    }
}

// Main class
class dcircularten 
{
    public static void main(String args[]) 
    {
        DoublyCircularLinkedList dl = new DoublyCircularLinkedList();
        dl.create();
        dl.display();
        dl.displayReverse();
    }
}
