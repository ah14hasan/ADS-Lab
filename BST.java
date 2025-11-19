// Creation and traversal of a Binary Search Tree (BST)
import java.io.*;
import java.util.*;

// Node class for BST
class Node {
    int data;
    Node left, right;

    public Node(int item) {
        data = item;
        left = right = null;
    }
}

// BST class with insert and traversal methods
class BinarySearchTree {
    Node root;

    // Insert method: iteratively inserts into BST
    void insert(int data) {
        root = insertRec(root, data);
    }

    // Recursive helper for insertion
    Node insertRec(Node root, int data) {
        if (root == null) {
            root = new Node(data);
            return root;
        }
        if (data < root.data)
            root.left = insertRec(root.left, data);
        else if (data > root.data)
            root.right = insertRec(root.right, data);
        return root;
    }

    // Inorder traversal
    void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }
    }

    // Preorder traversal
    void preorder(Node root) {
        if (root != null) {
            System.out.print(root.data + " ");
            preorder(root.left);
            preorder(root.right);
        }
    }

    // Postorder traversal
    void postorder(Node root) {
        if (root != null) {
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.data + " ");
        }
    }
}

public class BSTDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BinarySearchTree bst = new BinarySearchTree();

        System.out.print("Enter number of elements to insert: ");
        int n = scanner.nextInt();

        System.out.println("Enter " + n + " integer elements:");
        for (int i = 0; i < n; i++) {
            int val = scanner.nextInt();
            bst.insert(val);
        }

        System.out.print("Inorder Traversal: ");
        bst.inorder(bst.root);      // Sorted order
        System.out.println();

        System.out.print("Preorder Traversal: ");
        bst.preorder(bst.root);
        System.out.println();

        System.out.print("Postorder Traversal: ");
        bst.postorder(bst.root);
        System.out.println();
    }
}
