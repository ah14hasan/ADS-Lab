// Java Program to create and display a circular linked list with 10 nodes
import java.util.*; 
import java.io.*;

class node {
    int data;
    node link;
}

class circularLinkedList {
    node first;  // Class-level pointer to head

    void create() {
        node p, q;
        p = new node();
        p.data = 999;
        first = p;
        for (int i = 1; i <= 9; i++) {
            q = new node();
            q.data = 999 + i;
            p.link = q;
            p = q;
        }
        p.link = first; // Make it circular: last node points to first
    }

    void display() {
        if (first == null) {
            System.out.println("List is empty");
            return;
        }
        node temp = first;
        do {
            System.out.println(temp.data + " -->");
            temp = temp.link;
        } while (temp != first);
        System.out.println("(back to " + first.data + ")");
    }
}

// Main class
class circularten {
    public static void main(String args[]) {
        circularLinkedList l = new circularLinkedList();
        l.create();
        l.display();
    }
}
