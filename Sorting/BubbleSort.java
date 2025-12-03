// Bubble sort
import java.util.*;
import java.io.*;    

public class BubbleSort 
{

    public static void bubbleSort(int[] arr) 
    {
        int n = arr.length;     // Store the length of the array
        boolean swapped;        // This will tell if any swapping happened in a pass

        // Outer loop: number of passes
        // After each pass, the largest element among the unsorted part
        // moves (or "bubbles") to its correct position at the end.
        for (int i = 0; i < n - 1; i++) 
        {
            swapped = false;    // At the start of each pass, reset swapped to false
            // Inner loop: compare adjacent elements in the unsorted part
            // We go only up to (n - i - 1) because the last i elements are already sorted.
            for (int j = 0; j < n - i - 1; j++) 
            {

                // If the current element is greater than the next element,
                // then they are in the wrong order for ascending sort, so swap them.
                if (arr[j] > arr[j + 1]) 
                {
                    // Swap arr[j] and arr[j + 1]
                    int temp = arr[j];       // Store current element in a temporary variable
                    arr[j] = arr[j + 1];     // Move the next element to the current position
                    arr[j + 1] = temp;       // Move the stored value to the next position

                    swapped = true;          // A swap happened in this pass
                }
            }

            // Optimization: if no elements were swapped in this pass,
            // it means the array is already sorted, so we can stop early.
            if (!swapped) {
                break;  // Exit the outer loop
            }
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

        // Call bubbleSort method to sort the array in ascending order
        bubbleSort(arr);

        // Print the array after sorting
        System.out.println("After sort (ascending): " + Arrays.toString(arr));

        // Close the Scanner to free the resource
        sc.close();   // Good practice to close Scanner when done.
    }
}
