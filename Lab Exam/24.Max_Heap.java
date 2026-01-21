// Max-Heap
import java.util.*;

public class MaxHeapDemo {

    // Heap array (1-based indexing; index 0 unused)
    private int[] heap;
    int size; // package-private so main can access, same as your MinHeapDemo

    public MaxHeapDemo(int capacity) {
        heap = new int[capacity + 1]; // index 0 unused
        size = 0;
    }

    // Insert a value and percolate it up (optional, similar to min-heap)
    public void insert(int value) {
        size++;
        heap[size] = value;
        int i = size;
        while (i > 1 && heap[i] > heap[i / 2]) {  // > for max-heap
            swap(i, i / 2);
            i = i / 2;
        }
    }

    // Build max-heap using bottom-up heapify
    public void buildMaxHeap() {
        for (int i = size / 2; i >= 1; i--) {
            heapify(i);
        }
    }

    // Heapify (max-heap) at index i
    private void heapify(int i) {
        int largest = i;
        int left = 2 * i;
        int right = 2 * i + 1;

        if (left <= size && heap[left] > heap[largest]) {
            largest = left;
        }
        if (right <= size && heap[right] > heap[largest]) {
            largest = right;
        }
        if (largest != i) {
            swap(i, largest);
            heapify(largest);
        }
    }

    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    public void printHeap() {
        System.out.println("Max-Heap array representation:");
        for (int i = 1; i <= size; i++) {
            System.out.print(heap[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        MaxHeapDemo maxHeap = new MaxHeapDemo(n);

        System.out.println("Enter " + n + " integers:");
        for (int i = 0; i < n; i++) {
            int val = sc.nextInt();
            maxHeap.heap[i + 1] = val;  // fill array directly like your MinHeapDemo
            maxHeap.size++;
        }

        // Build max-heap from the given elements
        maxHeap.buildMaxHeap();

        // Print the constructed max-heap
        maxHeap.printHeap();

        sc.close();
    }
}
