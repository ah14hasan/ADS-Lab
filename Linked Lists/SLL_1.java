// Java Program to create and display two nodes of a singly linked list 
import java.util.*; 
import java.io.*;

class node 
{
    int data;
    node link;
}

class linkedlist 
{
    node first;  // <-- make it a class-level variable

    void create() {
        node p, q;
        p = new node();
        q = new node();
        p.data = 10;
        q.data = 20;
        p.link = q;
        q.link = null;
        first = p;  
    }

    void display() {
        node temp = first;
        while (temp.link != null) {
            System.out.println(temp.data + "-->");
            temp = temp.link;
        }
        System.out.println(temp.data + "-->");
        System.out.println("null");
    }
}


// Main class
class single {
    public static void main(String args[]) {
        linkedlist l = new linkedlist();
        l.create();
        l.display();
    }
}
