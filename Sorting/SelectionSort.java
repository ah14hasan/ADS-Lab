// Selection sort
import java.util.*;
import java.io.*;

public class SelectionSort 
{

    // Method to perform selection sort on an integer array (ascending order)
    public static void selectionSort(int[] arr) 
    {
        int n = arr.length;    // Store the length of the array

        // Outer loop: move the boundary of the unsorted subarray
        // After each iteration, the element at index i will be in its correct position.
        for (int i = 0; i < n - 1; i++) 
        {

            int minIndex = i;  // Assume the current index i has the minimum element

            // Inner loop: find the index of the minimum element in the unsorted part
            // Unsorted part starts from i+1 to n-1.
            for (int j = i + 1; j < n; j++) 
            {

                // If we find an element smaller than the current minimum,
                // update minIndex to this position.
                if (arr[j] < arr[minIndex]) 
                {
                    minIndex = j;
                }
            }

            // After the inner loop, minIndex holds the index of the smallest element
            // in the unsorted part. If minIndex is not i, swap it with arr[i]. 
            if (minIndex != i) 
            {
                int temp = arr[i];        // Store the element at i in temp
                arr[i] = arr[minIndex];   // Move the minimum element to position i
                arr[minIndex] = temp;     // Put the old arr[i] at the minIndex position
            }
            // At this point, all elements from index 0 to i are in sorted order.
        }
    }

    public static void main(String[] args) 
    {

        // Create a Scanner object to read from standard input (keyboard).
        Scanner sc = new Scanner(System.in);

        // Ask the user for the number of elements in the array
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();        // Read the size of the array from the user

        int[] arr = new int[n];     // Create an integer array of size n

        // Ask the user to enter the array elements
        System.out.println("Enter " + n + " integers:");
        for (int i = 0; i < n; i++) 
        {
            arr[i] = sc.nextInt();  // Read each integer and store it in the array
        }

        // Print the array before sorting
        System.out.println("Before sort: " + Arrays.toString(arr));

        // Call selectionSort method to sort the array in ascending order
        selectionSort(arr);

        // Print the array after sorting
        System.out.println("After sort (ascending): " + Arrays.toString(arr));

        // Close the Scanner to free the resource
        sc.close();   // Good practice to close Scanner when done.
    }
}
