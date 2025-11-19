// Java Program to perform insertion and deletion in a circular linked list
import java.util.*;  
import java.io.*;

class node {
    int data;
    node link;
} 

class circularLinkedList 
{
    node first;  // Points to head node

    // Creates two nodes: 10 -> 20 (circular)
    void create() 
    {
        node p = new node();
        node q = new node();
        p.data = 10;
        q.data = 20;
        p.link = q;
        q.link = p; // Last node points to first
        first = p;
    }

    void display() 
    {
        if (first == null) 
        {
            System.out.println("null");
            return;
        }
        node temp = first;
        do {
            System.out.print(temp.data + " --> ");
            temp = temp.link;
        } while (temp != first);
        System.out.println("(back to " + first.data + ")");
    }

    void addfirst()
    {
        node n = new node();
        n.data = 5;
        if (first == null) 
        {
            n.link = n;
            first = n;
        } 
        else 
        {
            node last = first;
            while (last.link != first) 
            {
                last = last.link;
            }
            n.link = first;
            last.link = n;
            first = n;
        }
    }

    void addlast()
    {
        node n = new node();
        n.data = 30;
        if (first == null) 
        {
            n.link = n;
            first = n;
        } 
        else 
        {
            node last = first;
            while (last.link != first) 
            {
                last = last.link;
            }
            last.link = n;
            n.link = first;
        }
    }

    // Adding between 10 and 20 (insert after node with data 10)
    void addbetween() 
    {
        node n = new node();
        n.data = 15;
        if (first == null) return;
        node temp = first;
        do {
            if (temp.data == 10) break;
            temp = temp.link;
        } while (temp != first);
        n.link = temp.link;
        temp.link = n;
    }

    void deletefirst() 
    {
        if (first == null) 
        {
            System.out.println("List is empty");
            return;
        }
        if (first.link == first)
        { // Only one node
            first = null;
            return;
        }
        node last = first;
        while (last.link != first) 
        {
            last = last.link;
        }
        first = first.link;
        last.link = first;
    } 

    void deletelast() 
    {
        if (first == null) 
        {
            System.out.println("List is empty");
            return;
        }
        if (first.link == first) 
        { // Only one node
            first = null;
            return;
        }
        node temp = first, prev = null;
        while (temp.link != first) 
        {
            prev = temp;
            temp = temp.link;
        }
        prev.link = first;
    }

    void deletebetween() 
    {
        if (first == null || first.link == first) 
        {
            System.out.println("List is empty or only one node");
            return;
        }
        node temp = first, prev = null;
        // Looking for node before the node that has data 20
        do {
            prev = temp;
            temp = temp.link;
        } while (temp.link.data != 20 && temp.link != first);
        // If node with data 20 found
        if (temp.link.data == 20) 
        {
            prev = temp;
            temp = temp.link;
            prev.link = temp.link;
        }
    }
}

// Main class
class circular2 
{
    public static void main(String args[]) 
    {
        circularLinkedList l = new circularLinkedList();
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
