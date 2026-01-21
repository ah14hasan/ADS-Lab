// Merge sort
import java.util.*;   
import java.io.*;    

public class MergeSort 
{

    // Method to perform merge sort on the array from index left to right (inclusive)
    public static void mergeSort(int[] arr, int left, int right) 
    {
        // Base condition: if left is not less than right, the subarray has 0 or 1 element,
        // which is already sorted.
        if (left < right) 
        {

            // Find the middle index to divide the array into two halves
            int mid = (left + right) / 2;

            // Recursively sort the left half: from left to mid
            mergeSort(arr, left, mid);

            // Recursively sort the right half: from mid + 1 to right
            mergeSort(arr, mid + 1, right);

            // Merge the two sorted halves into a single sorted subarray
            merge(arr, left, mid, right);
        }
    }

    // Method to merge two sorted subarrays of arr[]
    // First subarray is arr[left..mid]
    // Second subarray is arr[mid+1..right]
    public static void merge(int[] arr, int left, int mid, int right) 
    {

        // Calculate sizes of the two subarrays to be merged
        int n1 = mid - left + 1;   // Number of elements in the left subarray
        int n2 = right - mid;      // Number of elements in the right subarray

        // Create temporary arrays to hold the left and right parts
        int[] L = new int[n1];
        int[] R = new int[n2];

        // Copy data to temporary arrays L[] and R[]
        for (int i = 0; i < n1; i++) 
        {
            L[i] = arr[left + i];
        }
        for (int j = 0; j < n2; j++) 
        {
            R[j] = arr[mid + 1 + j];
        }

        // Initial indexes of the first (L) and second (R) subarrays
        int i = 0;        // Index for L[]
        int j = 0;        // Index for R[]
        int k = left;     // Index for merged subarray arr[left..right]

        // Merge the temporary arrays back into arr[left..right] in sorted order
        // Compare elements of L and R and copy the smaller one each time.
        while (i < n1 && j < n2) 
        {
            if (L[i] <= R[j]) 
            {   // For ascending order
                arr[k] = L[i];
                i++;
            } 
            else 
            {
                arr[k] = R[j];
                j++;
            }
            k++;  // Move to the next position in the main array
        }

        // Copy any remaining elements of L[], if there are any
        while (i < n1) 
        {
            arr[k] = L[i];
            i++;
            k++;
        }

        // Copy any remaining elements of R[], if there are any
        while (j < n2) 
        {
            arr[k] = R[j];
            j++;
            k++;
        }
        // At this point, arr[left..right] is sorted.
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

        // Call mergeSort method to sort the entire array (from index 0 to n-1)
        mergeSort(arr, 0, n - 1);

        // Print the array after sorting
        System.out.println("After sort (ascending): " + Arrays.toString(arr));

        // Close the Scanner to free the resource
        sc.close();   // Good practice to close Scanner when done.
    }
}
