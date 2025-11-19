// Java program to demonstrate insertion and deletion in a doubly circular linked list
import java.util.*;
import java.io.*;

class DNode {
    int data;
    DNode prev;
    DNode next;
}

class DoublyCircularLinkedList {
    DNode first;  // head pointer

    void create() {
        DNode p = new DNode();
        DNode q = new DNode();

        p.data = 10;
        q.data = 20;

        p.next = q;
        p.prev = q;
        q.next = p;
        q.prev = p;

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
            System.out.println(temp.data + " <->");
            temp = temp.next;
        } while (temp != first);
        System.out.println("(back to first: " + first.data + ")");
    }

    void addfirst() 
    {
        DNode n = new DNode();
        n.data = 5;
        if (first == null) 
        {
            n.next = n.prev = n;
            first = n;
            return;
        }
        DNode last = first.prev;

        n.next = first;
        n.prev = last;
        first.prev = n;
        last.next = n;
        first = n;
    }

    void addlast() 
    {
        DNode n = new DNode();
        n.data = 30;
        if (first == null) 
        {
            n.next = n.prev = n;
            first = n;
            return;
        }
        DNode last = first.prev;

        last.next = n;
        n.prev = last;
        n.next = first;
        first.prev = n;
    }

    // adding between 10 and 20 (insert after node with data 10)
    void addbetween() {
        if (first == null) 
        {
            System.out.println("List is empty");
            return;
        }
        DNode temp = first;
        do {
            if (temp.data == 10) break;
            temp = temp.next;
        } while (temp != first);

        if (temp.data != 10) {
            System.out.println("Node with data 10 not found");
            return;
        }

        DNode n = new DNode();
        n.data = 15;

        n.next = temp.next;
        n.prev = temp;
        temp.next.prev = n;
        temp.next = n;
    }

    void deletefirst() {
        if (first == null) {
            System.out.println("List is empty");
            return;
        }
        if (first.next == first) { // Only one node
            first = null;
            return;
        }
        DNode last = first.prev;
        first = first.next;
        first.prev = last;
        last.next = first;
    }

    void deletelast() {
        if (first == null) {
            System.out.println("List is empty");
            return;
        }
        if (first.next == first) { // Only one node
            first = null;
            return;
        }
        DNode last = first.prev;
        DNode newLast = last.prev;

        newLast.next = first;
        first.prev = newLast;
    }

    // delete the node between 10 and 20 (i.e., the node with data 15)
    void deletebetween() {
        if (first == null || first.next == first) {
            System.out.println("List is empty or only one node");
            return;
        }
        DNode temp = first;
        do {
            if (temp.data == 15) break;
            temp = temp.next;
        } while (temp != first);

        if (temp.data != 15) {
            System.out.println("Node with data 15 not found");
            return;
        }

        temp.prev.next = temp.next;
        temp.next.prev = temp.prev;
        // If first node is to be deleted
        if (temp == first) {
            first = temp.next; // or you can decide what to do
        }
    }
}

class dcircular2 {
    public static void main(String args[]) {
        DoublyCircularLinkedList l = new DoublyCircularLinkedList();

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
