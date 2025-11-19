// Java Program to create and display 10 nodes of a doubly linked list
import java.util.*;
import java.io.*;

// Node class for Doubly Linked List
class DNode 
{
    int data;
    DNode prev;
    DNode next;
}

// Doubly Linked List class
class DoublyLinkedList 
{
    DNode first;  // class-level reference to the first node

    void create() 
    {
        DNode p, q;
        p = new DNode();
        p.data = 10;
        first = p;
        p.prev = null;
        for (int i = 1; i <= 9; i++) 
        {
            q = new DNode();
            q.data = 10 + i;
            p.next = q;
            q.prev = p;
            q.next = null;
            p = q;
        }
    }

    void display() 
    {
        DNode temp = first;
        System.out.println("Forward Traversal:");
        while (temp != null) 
        {
            System.out.print(temp.data + " <-> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    void displayReverse()
    {
        // Move to the last node
        DNode temp = first;
        while (temp.next != null)
            temp = temp.next;

        System.out.println("Backward Traversal:");
        while (temp != null) 
        {
            System.out.print(temp.data + " <-> ");
            temp = temp.prev;
        }
        System.out.println("null");
    }
}

// Main class
class doubleten 
{
    public static void main(String args[]) 
    {
        DoublyLinkedList dl = new DoublyLinkedList();
        dl.create();
        dl.display();
        dl.displayReverse();
    }
}
