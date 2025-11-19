// Creating and displaying two nodes of a circular linked list
import java.util.*; 
import java.io.*;

class node 
{
    int data;
    node link;
}

class circularLinkedList 
{
    node first;

    void create() 
    {
        node p, q;
        p = new node();
        q = new node();
        p.data = 10;
        q.data = 20;
        p.link = q;
        q.link = p; // Make the list circular by pointing last node to first
        first = p;
    }

    void display() 
    {
        node temp = first;
        if (first == null) return;
        do {
            System.out.println(temp.data + "-->");
            temp = temp.link;
        } while (temp != first);
        System.out.println("Back to first (" + first.data + ")");
    }
}

// Main class
class circular 
{
    public static void main(String args[]) 
    {
        circularLinkedList l = new circularLinkedList();
        l.create();
        l.display();
    }
}

