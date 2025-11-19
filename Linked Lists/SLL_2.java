// Java Program to perform insertion and deletion in a singly linked list
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
    void addfirst(){
        node n = new node();
        n.data = 5;
        n.link = first;
        first = n;
    }
    void addlast(){
        node n = new node();
        n.data = 30;
        node temp = first;
        while(temp.link != null){
            temp = temp.link;
        }
        temp.link = n;
        n.link = null;
    }
    // adding between 10 and 20
    void addbetween(){
        node n = new node();
        n.data = 15;
        node temp = first;
        while(temp.data != 10){
            temp = temp.link;
        }
        n.link = temp.link;
        temp.link = n;
    }
    void deletefirst(){
        if(first == null){
            System.out.println("List is empty");
            return;
        }
        first = first.link;
    }
    void deletelast(){
        if(first == null){
            System.out.println("List is empty");
            return;
        }
        node temp = first;
        node prev = null;
        while(temp.link != null){
            prev = temp;
            temp = temp.link;
        }
        prev.link = null;
    }
    void deletebetween(){
        if(first == null){
            System.out.println("List is empty");
            return;
        }
        node temp = first;
        node prev = null;
        while(temp.link.data != 20){
            prev = temp;
            temp = temp.link;
        }
        prev.link = temp.link;
    }
}
// Main class
class single2 {
    public static void main(String args[]) {
        linkedlist l = new linkedlist();
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
