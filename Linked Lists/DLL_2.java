// Java Program to perform insertion and deletion in a doubly linked list
import java.util.*;
import java.io.*;

class DNode 
{
    int data;
    DNode prev;
    DNode next;
}

class DoublyLinkedList 
{
    DNode first;  // class-level head pointer

    void create() 
    {
        DNode p = new DNode();
        DNode q = new DNode();

        p.data = 10;
        q.data = 20;

        p.next = q;
        p.prev = null;

        q.prev = p;
        q.next = null;

        first = p;
    }

    void display() 
    {
        DNode temp = first; 
        while (temp != null && temp.next != null) 
        {
            System.out.println(temp.data + " <->");
            temp = temp.next;
        }
        if (temp != null) 
        {
            System.out.println(temp.data + " <->");
        }
        System.out.println("null");
    }

    void addfirst() 
    {
        DNode n = new DNode();
        n.data = 5;
        n.prev = null;
        n.next = first;
        if (first != null) first.prev = n;
        first = n;
    }

    void addlast() 
    {
        DNode n = new DNode();
        n.data = 30;
        n.next = null;

        if (first == null) 
        {
            n.prev = null;
            first = n;
            return;
        }

        DNode temp = first;
        while (temp.next != null) 
        {
            temp = temp.next;
        }
        temp.next = n; // link previous last node to new node
        n.prev = temp; // link back to previous last node
    }

    // adding between 10 and 20 (insert 15 after node with data 10)
    void addbetween() 
    {
        if (first == null) 
        {
            System.out.println("List is empty");
            return;
        }

        DNode temp = first;
        while (temp != null && temp.data != 10) 
        {
            temp = temp.next;
        }
        if (temp == null) 
        {
            System.out.println("Node with data 10 not found");
            return;
        }

        DNode n = new DNode();
        n.data = 15;

        n.next = temp.next;
        n.prev = temp;

        if (temp.next != null) temp.next.prev = n;
        temp.next = n;
    }

    void deletefirst() 
    {
        if (first == null) 
        {
            System.out.println("List is empty");
            return;
        }
        first = first.next;
        if (first != null) first.prev = null;
    }

    void deletelast() 
    {
        if (first == null) 
        {
            System.out.println("List is empty");
            return;
        }

        DNode temp = first;
        while (temp.next != null) 
        {
            temp = temp.next;
        }
        // temp is last node
        if (temp.prev == null) 
        { // only one node
            first = null;
        } 
        else 
        {
            temp.prev.next = null;
        }
    }

    // delete the node between 10 and 20 (i.e., the node with data 15)
    void deletebetween() 
    {
        if (first == null) 
        {
            System.out.println("List is empty");
            return;
        }

        // Find node with data 15 (the one we inserted between 10 and 20)
        DNode temp = first;
        while (temp != null && temp.data != 15) 
        {
            temp = temp.next;
        }

        if (temp == null) 
        {
            System.out.println("Node with data 15 not found");
            return;
        }

        // Unlink temp
        if (temp.prev != null) temp.prev.next = temp.next;
        else first = temp.next; // deleting the first node (edge case)

        if (temp.next != null) temp.next.prev = temp.prev;
    }
}

// Main class
class double2 
{
    public static void main(String args[]) 
    {
        DoublyLinkedList l = new DoublyLinkedList();

        System.out.println("Creating list:");
        l.create();
        l.display();

        System.out.println("Adding 5 at the beginning:");
        l.addfirst();
        l.display();

        System.out.println("Adding 30 at the end:");
        l.addlast();
        l.display();

        System.out.println("Adding 15 between 10 and 20:");
        l.addbetween();
        l.display();

        System.out.println("Deleting first node:");
        l.deletefirst();
        l.display();

        System.out.println("Deleting last node:");
        l.deletelast();
        l.display();

        System.out.println("Deleting node between 10 and 20:");
        l.deletebetween();
        l.display();
    }
}
