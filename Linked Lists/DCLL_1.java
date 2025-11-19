// Java Program to create and display two nodes of a doubly circular linked list
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
        q = new DNode();

        p.data = 10;
        q.data = 20;

        // linking nodes circularly
        p.next = q;
        q.prev = p;
        q.next = p; // circular: last node's next points to first
        p.prev = q; // circular: first node's prev points to last

        first = p;
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
        System.out.println("Backward Traversal:");
        DNode start = temp;
        do {
            System.out.print(temp.data + " <-> ");
            temp = temp.prev;
        } while (temp != start);
        System.out.println("(back to last: " + start.data + ")");
    }
}

// Main class
class dcircular 
{
    public static void main(String args[]) 
    {
        DoublyCircularLinkedList dl = new DoublyCircularLinkedList();
        dl.create();
        dl.display();
        dl.displayReverse();
    }
}
