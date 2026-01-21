// Program to implement an AVL Tree with
// insert, delete, search and traversal operations.
import java.io.*;
import java.util.*;

// Node of the AVL Tree
class AVLNode {
    int key;          // value stored in the node
    int height;       // height of this node in the AVL tree
    AVLNode left;     // reference to left child
    AVLNode right;    // reference to right child

    // Constructor to create a new node with a given key
    AVLNode(int key) {
        this.key = key;
        // A new node is initially a leaf, so its height is 1
        this.height = 1;
    }
}

// Class that implements all AVL Tree operations
class AVLTree {
    // Root node of the AVL Tree
    private AVLNode root;

    // Utility function to get height of a node
    // If node is null, height is 0
    private int height(AVLNode node) {
        return (node == null) ? 0 : node.height;
    }

    // Utility function to get balance factor of a node
    // balance = height(left subtree) - height(right subtree)
    private int getBalance(AVLNode node) {
        return (node == null) ? 0 : height(node.left) - height(node.right);
    }

    // Right rotation to fix Left-Left or Left-heavy cases
    //      y                 x
    //     / \               / \
    //    x   T3   ==>      T1  y
    //   / \                   / \
    //  T1 T2                 T2 T3
    private AVLNode rightRotate(AVLNode y) {
        AVLNode x = y.left;
        AVLNode T2 = x.right;

        // Perform rotation
        x.right = y;
        y.left = T2;

        // Update heights of rotated nodes
        y.height = 1 + Math.max(height(y.left), height(y.right));
        x.height = 1 + Math.max(height(x.left), height(x.right));

        // Return new root of this subtree
        return x;
    }

    // Left rotation to fix Right-Right or Right-heavy cases
    //    x                    y
    //   / \                  / \
    //  T1  y      ==>       x  T3
    //     / \              / \
    //    T2 T3            T1 T2
    private AVLNode leftRotate(AVLNode x) {
        AVLNode y = x.right;
        AVLNode T2 = y.left;

        // Perform rotation
        y.left = x;
        x.right = T2;

        // Update heights of rotated nodes
        x.height = 1 + Math.max(height(x.left), height(x.right));
        y.height = 1 + Math.max(height(y.left), height(y.right));

        // Return new root of this subtree
        return y;
    }

    // Public method to insert a key into the AVL Tree
    public void insert(int key) {
        root = insert(root, key);
    }

    // Recursive function to insert a key in the subtree rooted at 'node'
    // and return the new root of that subtree
    private AVLNode insert(AVLNode node, int key) {
        // 1. Perform standard BST insertion
        if (node == null)
            return new AVLNode(key);

        if (key < node.key)
            node.left = insert(node.left, key);
        else if (key > node.key)
            node.right = insert(node.right, key);
        else
            // Duplicate keys are not allowed in this AVL implementation
            return node;

        // 2. Update the height of this ancestor node
        node.height = 1 + Math.max(height(node.left), height(node.right));

        // 3. Get the balance factor to check if this node became unbalanced
        int balance = getBalance(node);

        // 4. If node is unbalanced, there are 4 cases

        // Case 1: Left Left (LL) - heavy on left-left
        if (balance > 1 && key < node.left.key)
            return rightRotate(node);

        // Case 2: Right Right (RR) - heavy on right-right
        if (balance < -1 && key > node.right.key)
            return leftRotate(node);

        // Case 3: Left Right (LR) - heavy on left-right
        if (balance > 1 && key > node.left.key) {
            // First rotate left on left child
            node.left = leftRotate(node.left);
            // Then rotate right on current node
            return rightRotate(node);
        }

        // Case 4: Right Left (RL) - heavy on right-left
        if (balance < -1 && key < node.right.key) {
            // First rotate right on right child
            node.right = rightRotate(node.right);
            // Then rotate left on current node
            return leftRotate(node);
        }

        // Node is balanced, return it
        return node;
    }

    // Utility function to find the node with minimum key value in a subtree
    // Used during deletion to find inorder successor
    private AVLNode minValueNode(AVLNode node) 
    {
        AVLNode current = node;
        // Loop to find the leftmost (smallest) node
        while (current.left != null)
            current = current.left;
        return current;
    }

    // Public method to delete a key from the AVL Tree
    public void delete(int key) {
        root = delete(root, key);
    }

    // Recursive function to delete a key from subtree rooted at 'node'
    private AVLNode delete(AVLNode node, int key) {
        // 1. Perform standard BST delete
        if (node == null)
            return null;

        if (key < node.key)
            node.left = delete(node.left, key);
        else if (key > node.key)
            node.right = delete(node.right, key);
        else {
            // Node to be deleted is found

            // Case 1 and 2: node has one child or no child
            if ((node.left == null) || (node.right == null)) {
                AVLNode temp = (node.left != null) ? node.left : node.right;

                if (temp == null) {
                    // No child: node becomes null (leaf deletion)
                    node = null;
                } else {
                    // One child: copy the child to this node
                    node = temp;
                }
            } else {
                // Case 3: node has two children
                // Get inorder successor (smallest in right subtree)
                AVLNode temp = minValueNode(node.right);

                // Copy the inorder successor's key to this node
                node.key = temp.key;

                // Delete the inorder successor node
                node.right = delete(node.right, temp.key);
            }
        }

        // If the tree had only one node then return
        if (node == null)
            return null;

        // 2. Update height of the current node
        node.height = 1 + Math.max(height(node.left), height(node.right));

        // 3. Get the balance factor of this node
        int balance = getBalance(node);

        // 4. If node is unbalanced, fix it using rotations

        // Case 1: Left Left (LL)
        if (balance > 1 && getBalance(node.left) >= 0)
            return rightRotate(node);

        // Case 2: Left Right (LR)
        if (balance > 1 && getBalance(node.left) < 0) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        // Case 3: Right Right (RR)
        if (balance < -1 && getBalance(node.right) <= 0)
            return leftRotate(node);

        // Case 4: Right Left (RL)
        if (balance < -1 && getBalance(node.right) > 0) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        // Return the (possibly new) root of this subtree
        return node;
    }

    // Public method to search for a key in the AVL Tree
    public boolean search(int key) {
        return search(root, key);
    }

    // Recursive search in BST-style (AVL is also a BST)
    private boolean search(AVLNode node, int key) {
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
    public void display() {
        System.out.print("Inorder traversal: ");
        inorder(root);               // Left, Root, Right
        System.out.println();

        System.out.print("Preorder traversal: ");
        preorder(root);              // Root, Left, Right
        System.out.println();

        System.out.print("Postorder traversal: ");
        postorder(root);             // Left, Right, Root
        System.out.println();
    }

    // Inorder traversal (prints elements in sorted order for BST/AVL)
    private void inorder(AVLNode node) {
        if (node != null) {
            inorder(node.left);
            System.out.print(node.key + " ");
            inorder(node.right);
        }
    }

    // Preorder traversal
    private void preorder(AVLNode node) {
        if (node != null) {
            System.out.print(node.key + " ");
            preorder(node.left);
            preorder(node.right);
        }
    }

    // Postorder traversal
    private void postorder(AVLNode node) {
        if (node != null) {
            postorder(node.left);
            postorder(node.right);
            System.out.print(node.key + " ");
        }
    }
}

// Main class that provides a menu-driven interface for AVL Tree operations
public class AVLMenuDemo {
    public static void main(String[] args) {
        AVLTree tree = new AVLTree();   // create an empty AVL tree
        Scanner sc = new Scanner(System.in);

        while (true) {
            // Print menu for user
            System.out.println("\n--- AVL Tree Menu ---");
            System.out.println("1. Insert an element");
            System.out.println("2. Delete an element");
            System.out.println("3. Search for an element");
            System.out.println("4. Display tree (inorder, preorder, postorder)");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    // Insert operation
                    System.out.print("Enter element to insert: ");
                    int ins = sc.nextInt();
                    tree.insert(ins);
                    System.out.println("Inserted " + ins + " into the AVL tree.");
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
