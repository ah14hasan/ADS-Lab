// Min-Heap
import java.util.*;
import java.io.*;

public class MinHeapDemo {

    // Heap array (1-based indexing for simplicity; index 0 unused)
    private int[] heap;
    private int size;

    public MinHeapDemo(int capacity) {
        heap = new int[capacity + 1]; // index 0 unused
        size = 0;
    }

    // Insert a value and percolate it up
    public void insert(int value) {
        size++;
        heap[size] = value;
        int i = size;
        while (i > 1 && heap[i] < heap[i / 2]) {
            swap(i, i / 2);
            i = i / 2;
        }
    }

    // Build min-heap using bottom-up heapify
    public void buildMinHeap() {
        for (int i = size / 2; i >= 1; i--) {
            heapify(i);
        }
    }

    // Heapify (min-heap) at index i
    private void heapify(int i) {
        int smallest = i;
        int left = 2 * i;
        int right = 2 * i + 1;

        if (left <= size && heap[left] < heap[smallest]) {
            smallest = left;
        }
        if (right <= size && heap[right] < heap[smallest]) {
            smallest = right;
        }
        if (smallest != i) {
            swap(i, smallest);
            heapify(smallest);
        }
    }

    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    public void printHeap() {
        System.out.println("Min-Heap array representation:");
        for (int i = 1; i <= size; i++) {
            System.out.print(heap[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        MinHeapDemo minHeap = new MinHeapDemo(n);

        System.out.println("Enter " + n + " integers:");
        for (int i = 0; i < n; i++) {
            int val = sc.nextInt();
            minHeap.heap[i + 1] = val;  // fill array directly
            minHeap.size++;
        }

        // Build min-heap from the given elements
        minHeap.buildMinHeap();

        // Print the constructed min-heap
        minHeap.printHeap();

        sc.close();
    }
}
