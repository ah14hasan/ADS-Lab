// Java Program to create and display a single linked list with 10 nodes
import java.util.*; 
import java.io.*;

class node {
    int data;
    node link;
}

class linkedlist {
    node first;  // <-- make it a class-level variable

    void create() {
        node p, q;
        p = new node();
        p.data = 999;
        first = p;
        for (int i = 1; i <= 9; i++) {
            q = new node();
            q.data = 999 + i;
            p.link = q;
            q.link = null;
            p = q;
        }
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
class singleten {
    public static void main(String args[]) {
        linkedlist l = new linkedlist();
        l.create();
        l.display();
    }
}
