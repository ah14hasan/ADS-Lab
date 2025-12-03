// Btree menu demo program
import java.util.*;
import java.io.*;

// Node of a B-Tree
class BTreeNode {
    int[] keys;           // Array to store keys in this node (kept sorted)
    int t;                // Minimum degree (defines min & max keys per node)
    BTreeNode[] children; // References to child subtrees
    int n;                // Current number of keys stored in this node
    boolean leaf;         // true if node is a leaf (no children), false otherwise

    // Constructor: create a node with given minimum degree and leaf flag
    BTreeNode(int t, boolean leaf) {
        this.t = t;
        this.leaf = leaf;

        // A B-Tree node of degree t can hold at most (2t - 1) keys. [web:135][web:147]
        this.keys = new int[2 * t - 1];

        // And at most (2t) children.
        this.children = new BTreeNode[2 * t];

        this.n = 0;  // Initially, node contains 0 keys
    }

    // Traversal of the subtree rooted at this node (keys printed in sorted order)
    // This is like an inorder traversal for B-Trees. [web:135]
    void traverse() {
        int i;

        // For each key, first traverse the child before it (if not leaf),
        // then print the key. This maintains sorted order. [web:135][web:139]
        for (i = 0; i < n; i++) {
            if (!leaf) {
                children[i].traverse();
            }
            System.out.print(keys[i] + " ");
        }

        // Traverse the last child (after the last key)
        if (!leaf) {
            children[i].traverse();
        }
    }

    // Search for key k in the subtree rooted at this node. [web:135][web:139]
    BTreeNode search(int k) {
        int i = 0;

        // Find the first key >= k
        while (i < n && k > keys[i]) {
            i++;
        }

        // If this key equals k, we found it
        if (i < n && keys[i] == k) {
            return this;
        }

        // If this is a leaf, the key is not present anywhere below
        if (leaf) {
            return null;
        }

        // Otherwise, descend into the appropriate child
        return children[i].search(k);
    }

    // Insert a new key k into the subtree rooted at this node.
    // This node is assumed to be non-full when called. [web:129][web:138]
    void insertNonFull(int k) {
        int i = n - 1;   // Start from the last key index

        if (leaf) {
            // Leaf case: just insert key into this node in sorted order

            // Move all keys greater than k one position ahead to make space
            while (i >= 0 && keys[i] > k) {
                keys[i + 1] = keys[i];
                i--;
            }

            // Insert the new key at the found position
            keys[i + 1] = k;
            n = n + 1;   // Increase key count
        } else {
            // Internal node case: find child that should get the new key

            while (i >= 0 && keys[i] > k) {
                i--;
            }
            i++;  // Child index where key should go

            // If that child is full, split it first
            if (children[i].n == 2 * t - 1) {
                splitChild(i, children[i]);

                // After splitting, the middle key moves up into this node.
                // Decide whether the new key should go to left or right of that key. [web:129]
                if (keys[i] < k) {
                    i++;
                }
            }

            // Now insert recursively into the correct (non-full) child
            children[i].insertNonFull(k);
        }
    }

    // Split the full child 'y' of this node at index i.
    // After split, this node gets a new child at i+1 and one key is moved up. [web:129]
    void splitChild(int i, BTreeNode y) {
        // Create new node z that will store (t-1) keys from y
        BTreeNode z = new BTreeNode(y.t, y.leaf);
        z.n = t - 1;  // z will hold t-1 keys

        // Copy the last (t-1) keys from y into z
        for (int j = 0; j < t - 1; j++) {
            z.keys[j] = y.keys[j + t];
        }

        // Copy the last t children of y into z (if y is not a leaf)
        if (!y.leaf) {
            for (int j = 0; j < t; j++) {
                z.children[j] = y.children[j + t];
            }
        }

        // Reduce number of keys in y (it keeps only first t-1 keys now)
        y.n = t - 1;

        // Make room in this node's children[] to insert new child z
        for (int j = n; j >= i + 1; j--) {
            children[j + 1] = children[j];
        }

        // Link new child at index i+1
        children[i + 1] = z;

        // Move a key from y up into this node (the median key)
        for (int j = n - 1; j >= i; j--) {
            keys[j + 1] = keys[j];
        }
        keys[i] = y.keys[t - 1];   // Middle key goes up

        // This node now has one more key
        n = n + 1;
    }

    // Find index of first key >= k in this node. [web:130]
    int findKey(int k) {
        int idx = 0;
        while (idx < n && keys[idx] < k) {
            idx++;
        }
        return idx;
    }

    // Remove key k from the subtree rooted at this node. [web:130][web:138]
    void remove(int k) {
        int idx = findKey(k);

        // Case 1: key is present in this node at position idx
        if (idx < n && keys[idx] == k) {
            if (leaf) {
                // If node is leaf, just remove the key from this node
                removeFromLeaf(idx);
            } else {
                // If node is internal, use predecessor/successor logic
                removeFromNonLeaf(idx);
            }
        } else {
            // Case 2: key is not present in this node

            if (leaf) {
                // If this is leaf and key is not here, it doesn't exist in tree
                System.out.println("Key " + k + " not found in the tree.");
                return;
            }

            // Flag indicates whether the key is possibly present in the last child
            boolean flag = (idx == n);

            // If child where key should be has fewer than t keys, fix it so it has at least t
            if (children[idx].n < t) {
                fill(idx);
            }

            // After filling, if the child was merged, it may have moved to index idx-1
            if (flag && idx > n) {
                children[idx - 1].remove(k);
            } else {
                children[idx].remove(k);
            }
        }
    }

    // Remove key at index idx from a leaf node: simple array shift.
    void removeFromLeaf(int idx) {
        // Shift all keys after idx one position left
        for (int i = idx + 1; i < n; i++) {
            keys[i - 1] = keys[i];
        }
        n--;  // Decrease key count
    }

    // Remove key at index idx from an internal node. [web:130]
    void removeFromNonLeaf(int idx) {
        int k = keys[idx];

        // Case 1: Left child has at least t keys -> use predecessor
        if (children[idx].n >= t) {
            int pred = getPredecessor(idx);
            keys[idx] = pred;                // Replace k by predecessor
            children[idx].remove(pred);      // Remove predecessor from left subtree
        }
        // Case 2: Right child has at least t keys -> use successor
        else if (children[idx + 1].n >= t) {
            int succ = getSuccessor(idx);
            keys[idx] = succ;                // Replace k by successor
            children[idx + 1].remove(succ);  // Remove successor from right subtree
        }
        // Case 3: Both children have t-1 keys -> merge and then delete from merged child
        else {
            merge(idx);
            children[idx].remove(k);
        }
    }

    // Get predecessor of keys[idx] (max key in left subtree).
    int getPredecessor(int idx) {
        // Go to rightmost node in left child
        BTreeNode cur = children[idx];
        while (!cur.leaf) {
            cur = cur.children[cur.n];   // move to rightmost child
        }
        return cur.keys[cur.n - 1];
    }

    // Get successor of keys[idx] (min key in right subtree).
    int getSuccessor(int idx) {
        // Go to leftmost node in right child
        BTreeNode cur = children[idx + 1];
        while (!cur.leaf) {
            cur = cur.children[0];       // move to leftmost child
        }
        return cur.keys[0];
    }

    // Ensure that child[idx] has at least t keys by borrowing or merging. [web:130]
    void fill(int idx) {
        // If previous sibling has extra keys, borrow from it
        if (idx != 0 && children[idx - 1].n >= t) {
            borrowFromPrev(idx);
        }
        // Else if next sibling has extra keys, borrow from it
        else if (idx != n && children[idx + 1].n >= t) {
            borrowFromNext(idx);
        }
        // Else merge with a sibling (either left or right)
        else {
            if (idx != n) {
                merge(idx);
            } else {
                merge(idx - 1);
            }
        }
    }

    // Borrow a key from previous sibling of children[idx].
    void borrowFromPrev(int idx) {
        BTreeNode child = children[idx];
        BTreeNode sibling = children[idx - 1];

        // Shift child's keys one step forward to create space at start
        for (int i = child.n - 1; i >= 0; i--) {
            child.keys[i + 1] = child.keys[i];
        }

        // If child is not leaf, shift its children also
        if (!child.leaf) {
            for (int i = child.n; i >= 0; i--) {
                child.children[i + 1] = child.children[i];
            }
        }

        // Bring a key from parent down to child
        child.keys[0] = keys[idx - 1];

        // Move sibling's last child as child's first child
        if (!child.leaf) {
            child.children[0] = sibling.children[sibling.n];
        }

        // Move sibling's last key up to parent
        keys[idx - 1] = sibling.keys[sibling.n - 1];

        // Update key counts
        child.n += 1;
        sibling.n -= 1;
    }

    // Borrow a key from next sibling of children[idx].
    void borrowFromNext(int idx) {
        BTreeNode child = children[idx];
        BTreeNode sibling = children[idx + 1];

        // Bring a key from parent down to child (at the end)
        child.keys[child.n] = keys[idx];

        // Sibling's first child becomes child's last child (if not leaf)
        if (!child.leaf) {
            child.children[child.n + 1] = sibling.children[0];
        }

        // First key from sibling moves up to parent
        keys[idx] = sibling.keys[0];

        // Shift sibling's keys left
        for (int i = 1; i < sibling.n; i++) {
            sibling.keys[i - 1] = sibling.keys[i];
        }

        // Shift sibling's children left (if not leaf)
        if (!sibling.leaf) {
            for (int i = 1; i <= sibling.n; i++) {
                sibling.children[i - 1] = sibling.children[i];
            }
        }

        // Update key counts
        child.n += 1;
        sibling.n -= 1;
    }

    // Merge children[idx] and children[idx+1] into a single node child. [web:130][web:138]
    void merge(int idx) {
        BTreeNode child = children[idx];
        BTreeNode sibling = children[idx + 1];

        // Pull down the key from current node into child at position t-1
        child.keys[t - 1] = keys[idx];

        // Copy sibling's keys into child
        for (int i = 0; i < sibling.n; i++) {
            child.keys[i + t] = sibling.keys[i];
        }

        // Copy sibling's children into child (if not leaf)
        if (!child.leaf) {
            for (int i = 0; i <= sibling.n; i++) {
                child.children[i + t] = sibling.children[i];
            }
        }

        // Shift keys after idx in current node one step left
        for (int i = idx + 1; i < n; i++) {
            keys[i - 1] = keys[i];
        }

        // Shift children after sibling in current node one step left
        for (int i = idx + 2; i <= n; i++) {
            children[i - 1] = children[i];
        }

        // Update key count of merged child and this node
        child.n += sibling.n + 1;
        n--;
    }
}

// B-Tree wrapper class that stores the root and minimum degree t
class BTree {
    BTreeNode root;  // Root node of the B-Tree
    int t;           // Minimum degree

    BTree(int t) {
        this.root = null;
        this.t = t;
    }

    // Traverse the whole tree (prints keys in sorted order). [web:135]
    void traverse() {
        if (root != null) {
            root.traverse();
        }
        System.out.println();
    }

    // Search for key k in the B-Tree
    boolean search(int k) {
        if (root == null) return false;
        return root.search(k) != null;
    }

    // Insert a new key into the B-Tree. [web:129][web:135]
    void insert(int k) {
        // If tree is empty, create root
        if (root == null) {
            root = new BTreeNode(t, true);
            root.keys[0] = k;
            root.n = 1;
        } else {
            // If root is full, the tree grows in height
            if (root.n == 2 * t - 1) {
                // Create new node s as new root
                BTreeNode s = new BTreeNode(t, false);

                // Old root becomes child 0 of new root
                s.children[0] = root;

                // Split the old root (child 0 of s)
                s.splitChild(0, root);

                // Decide which of the two children gets new key
                int i = 0;
                if (s.keys[0] < k) {
                    i++;
                }
                s.children[i].insertNonFull(k);

                // Update root pointer
                root = s;
            } else {
                // Root is not full: insert directly
                root.insertNonFull(k);
            }
        }
    }

    // Delete key k from the B-Tree. [web:130]
    void delete(int k) {
        if (root == null) {
            System.out.println("The tree is empty.");
            return;
        }

        // Call recursive remove on root
        root.remove(k);

        // If root has 0 keys now, adjust root reference
        if (root.n == 0) {
            if (root.leaf) {
                // Tree becomes empty
                root = null;
            } else {
                // Make first child the new root (tree height decreases)
                root = root.children[0];
            }
        }
    }
}

// Main class: Menu-driven interface similar to your AVL/BST programs
public class BTreeMenuDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Ask user to choose minimum degree t (e.g., 3, 4, ...)
        System.out.print("Enter minimum degree (t) of B-Tree (e.g., 3): ");
        int t = sc.nextInt();

        BTree tree = new BTree(t);  // Create an empty B-Tree with degree t

        while (true) {
            // Display menu options
            System.out.println("\n--- B-Tree Menu ---");
            System.out.println("1. Insert an element");
            System.out.println("2. Delete an element");
            System.out.println("3. Search for an element");
            System.out.println("4. Traverse tree");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    // Insert operation
                    System.out.print("Enter element to insert: ");
                    int ins = sc.nextInt();
                    tree.insert(ins);
                    System.out.println("Inserted " + ins + " into the B-Tree.");
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
                        System.out.println(s + " found in the B-Tree.");
                    else
                        System.out.println(s + " not found in the B-Tree.");
                    break;

                case 4:
                    // Traversal (prints all keys in sorted order)
                    System.out.print("B-Tree traversal (sorted order): ");
                    tree.traverse();
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
