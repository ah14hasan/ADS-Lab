// Heap sort
import java.util.*;   
import java.io.*;     

public class HeapSort 
{

    // Method to perform heap sort on an integer array (ascending order)
    public static void heapSort(int[] arr) 
    {
        int n = arr.length;   // Number of elements in the array

        // Step 1: Build a max heap from the input array.
        // After this, the largest element will be at index 0 (root of the heap).
        for (int i = n / 2 - 1; i >= 0; i--) 
        {
            heapify(arr, n, i);   // Heapify each non-leaf node
        }

        // Step 2: One by one move the current root (maximum element)
        // to the end of the array, and reduce the heap size. 
        for (int i = n - 1; i >= 0; i--) 
        {
            // Swap arr[0] (largest) with arr[i]
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // Call heapify on the reduced heap (size i)
            heapify(arr, i, 0);
        }
        // After this loop, the array is sorted in ascending order.
    }

    // To heapify a subtree rooted with node i.
    // n is the size of the heap part of the array (0 to n-1).
    public static void heapify(int[] arr, int n, int i) 
    {
        int largest = i;        // Assume the current index i is the largest
        int left = 2 * i + 1;   // Left child index in array representation of heap
        int right = 2 * i + 2;  // Right child index

        // If left child exists and is greater than current largest, update largest
        if (left < n && arr[left] > arr[largest]) 
        {
            largest = left;
        }

        // If right child exists and is greater than current largest, update largest
        if (right < n && arr[right] > arr[largest]) 
        {
            largest = right;
        }

        // If largest is not i, then one of the children is larger than the root.
        // Swap root with the largest child and recursively heapify the affected subtree. 
        if (largest != i) 
        {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            // Recursively heapify the sub-tree that was affected by the swap
            heapify(arr, n, largest);
        }
    }

    public static void main(String[] args) 
    {

        // Create a Scanner object to read from standard input (keyboard).
        Scanner sc = new Scanner(System.in);

        // Ask the user for the number of elements in the array
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();          // Read the size of the array from the user

        int[] arr = new int[n];       // Create an integer array of size n

        // Ask the user to enter the array elements
        System.out.println("Enter " + n + " integers:");
        for (int i = 0; i < n; i++) 
        {
            arr[i] = sc.nextInt();    // Read each integer and store it in the array
        }

        // Print the array before sorting
        System.out.println("Before sort: " + Arrays.toString(arr));

        // Call heapSort method to sort the array in ascending order
        heapSort(arr);

        // Print the array after sorting
        System.out.println("After sort (ascending): " + Arrays.toString(arr));

        // Close the Scanner to free the resource
        sc.close();   // Good practice to close Scanner when done.
    }
}
