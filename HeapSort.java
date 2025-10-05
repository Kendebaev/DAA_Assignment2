package org.example;
import java.util.Arrays;


public class HeapSort {


    public static void sort(double[] arr) {
        int n = arr.length;


        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        for (int i = n - 1; i > 0; i--) {
            // move current root
            swap(arr, 0, i);

            // call max-heapify
            heapify(arr, i, 0);
        }
    }



    private static void heapify(double[] arr, int n, int i) {
        int largest = i;
        int left = 2 * i + 1; // Left child
        int right = 2 * i + 2; // Right child


        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }

        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }

        if (largest != i) {
            swap(arr, i, largest);

            heapify(arr, n, largest);
        }
    }

    private static void swap(double[] arr, int i, int j) {
        double temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        double[] testArray = {12.0, 11.0, 13.0, 5.0, 6.0, 7.0, 88.7, 10.1};

        System.out.println("Original Array: " + Arrays.toString(testArray));

        long startTime = System.nanoTime();
        sort(testArray);
        long endTime = System.nanoTime();

        System.out.println("Sorted Array:   " + Arrays.toString(testArray));
        System.out.println("\n--- Performance ---");
        System.out.println("Execution Time: " + (endTime - startTime) / 1_000_000.0 + " ms");
    }
}