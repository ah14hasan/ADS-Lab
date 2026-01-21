// BST - insertion, deletion, search, and traversals with menu-driven interface
import java.util.*;
import java.io.*;

// Node of the Binary Search Tree
class BSTNode 
{
    int key;          // value stored in the node
    BSTNode left;     // reference to left child
    BSTNode right;    // reference to right child

    // Constructor to create a new node with a given key
    BSTNode(int key) 
    {
        this.key = key;
        this.left = null;
        this.right = null;
    }
}

// Class that implements all BST operations
class BSTree 
{
    // Root node of the BST
    private BSTNode root;

    // Public method to insert a key into the BST
    public void insert(int key) {
        root = insert(root, key);
    }

    // Recursive function to insert a key in the subtree rooted at 'node'
    private BSTNode insert(BSTNode node, int key) 
    {
        // 1. Standard BST insertion
        if (node == null) 
        {
            return new BSTNode(key);
        }

        if (key < node.key) 
        {
            node.left = insert(node.left, key);
        } 
        else if (key > node.key) 
        {
            node.right = insert(node.right, key);
        } 
        else 
        {
            // Duplicate keys are not inserted in this implementation
            return node;
        }

        // 2. Return the (unchanged) node pointer
        return node;
    }

    // Utility function to find the node with minimum key value in a subtree
    // Used during deletion to find inorder successor. [web:108][web:111]
    private BSTNode minValueNode(BSTNode node) 
    {
        BSTNode current = node;
        // Loop to find the leftmost (smallest) node
        while (current.left != null) 
        {
            current = current.left;
        }
        return current;
    }

    // Public method to delete a key from the BST
    public void delete(int key) 
    {
        root = delete(root, key);
    }

    // Recursive function to delete a key from subtree rooted at 'node' [web:109][web:115]
    private BSTNode delete(BSTNode node, int key) 
    {
        // 1. Standard BST delete steps
        if (node == null) 
        {
            return null;
        }

        if (key < node.key) 
        {
            node.left = delete(node.left, key);
        } 
        else if (key > node.key) 
        {
            node.right = delete(node.right, key);
        } 
        else 
        {
            // Node to be deleted is found

            // Case 1 & 2: node has one child or no child
            if (node.left == null) 
            {
                return node.right;    // could be null or right child
            } 
            else if (node.right == null) 
            {
                return node.left;     // only left child
            } 
            else 
            {
                // Case 3: node has two children
                // Get inorder successor (smallest in right subtree)
                BSTNode temp = minValueNode(node.right);

                // Copy the inorder successor's key to this node
                node.key = temp.key;

                // Delete the inorder successor node
                node.right = delete(node.right, temp.key);
            }
        }

        // 2. Return the (possibly new) root of this subtree
        return node;
    }

    // Public method to search for a key in the BST
    public boolean search(int key) 
    {
        return search(root, key);
    }

    // Recursive search in BST
    private boolean search(BSTNode node, int key) 
    {
        if (node == null)
            return false;            // key not found
        if (key == node.key)
            return true;             // key found
        if (key < node.key)
            return search(node.left, key);   // search in left subtree
        else
            return search(node.right, key);  // search in right subtree
    }

    // Display all traversals of the tree starting from root
    public void display() 
    {
        System.out.print("Inorder traversal: ");
        inorder(root);               // Left, Root, Right (sorted order) [web:112][web:122][web:127]
        System.out.println();

        System.out.print("Preorder traversal: ");
        preorder(root);              // Root, Left, Right
        System.out.println();

        System.out.print("Postorder traversal: ");
        postorder(root);             // Left, Right, Root
        System.out.println();
    }

    // Inorder traversal (prints elements in sorted order for BST)
    private void inorder(BSTNode node) 
    {
        if (node != null) 
        {
            inorder(node.left);
            System.out.print(node.key + " ");
            inorder(node.right);
        }
    }

    // Preorder traversal
    private void preorder(BSTNode node) 
    {
        if (node != null) 
        {
            System.out.print(node.key + " ");
            preorder(node.left);
            preorder(node.right);
        }
    }

    // Postorder traversal
    private void postorder(BSTNode node) 
    {
        if (node != null) 
        {
            postorder(node.left);
            postorder(node.right);
            System.out.print(node.key + " ");
        }
    }
}

// Main class that provides a menu-driven interface for BST operations
public class BSTMenuDemo 
{
    public static void main(String[] args) 
    {
        BSTree tree = new BSTree();   // create an empty BST
        Scanner sc = new Scanner(System.in);

        while (true) 
        {
            // Print menu for user
            System.out.println("\n--- Binary Search Tree Menu ---");
            System.out.println("1. Insert an element");
            System.out.println("2. Delete an element");
            System.out.println("3. Search for an element");
            System.out.println("4. Display tree (inorder, preorder, postorder)");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();

            switch (choice) 
            {
                case 1:
                    // Insert operation
                    System.out.print("Enter element to insert: ");
                    int ins = sc.nextInt();
                    tree.insert(ins);
                    System.out.println("Inserted " + ins + " into the BST.");
                    break;

                case 2:
                    // Delete operation
                    System.out.print("Enter element to delete: ");
                    int del = sc.nextInt();
                    tree.delete(del);
                    System.out.println("Deletion (if present) completed for " + del + ".");
                    break;

                case 3:
                    // Search operation
                    System.out.print("Enter element to search: ");
                    int s = sc.nextInt();
                    if (tree.search(s))
                        System.out.println(s + " found in the tree.");
                    else
                        System.out.println(s + " not found in the tree.");
                    break;

                case 4:
                    // Display all traversals
                    tree.display();
                    break;

                case 5:
                    // Exit the program
                    System.out.println("Exiting...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
