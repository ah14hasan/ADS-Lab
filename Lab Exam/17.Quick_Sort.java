// Quick sort
import java.util.*;   
import java.io.*;    

public class QuickSort 
{

    // Method to perform quick sort on the array from index low to high (inclusive)
    public static void quickSort(int[] arr, int low, int high) 
    {
        // Only sort if the subarray has at least 2 elements
        if (low < high) 
        {
            // pi is the partition index: element at pi will be at correct position
            int pi = partition(arr, low, high);  

            // Recursively sort elements before partition index
            quickSort(arr, low, pi - 1);

            // Recursively sort elements after partition index
            quickSort(arr, pi + 1, high);
        }
    }

    // Partition method: places pivot in correct position and
    // arranges smaller elements to its left and greater to its right.
    public static int partition(int[] arr, int low, int high) 
    {

        int pivot = arr[high];   // Choose the last element as pivot
        int i = low - 1;         // Index of smaller element; boundary of "smaller than pivot" region

        // Traverse from low to high - 1 and rearrange elements
        for (int j = low; j < high; j++) 
        {
            // If current element is smaller than or equal to pivot (for ascending order)
            if (arr[j] <= pivot) 
            {
                i++;  // Move boundary of smaller elements

                // Swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // Place pivot at its correct sorted position: after the last smaller element
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        // Return the partition index
        return i + 1;
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

        // Call quickSort method to sort the entire array (from index 0 to n-1)
        quickSort(arr, 0, n - 1);

        // Print the array after sorting
        System.out.println("After sort (ascending): " + Arrays.toString(arr));

        // Close the Scanner to free the resource
        sc.close();   // Good practice to close Scanner when done.
    }
}
