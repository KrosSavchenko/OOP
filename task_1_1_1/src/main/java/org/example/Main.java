package org.example;

/**
 * Main class.
 */
public class Main {
    public static void main(String[] args) {

    }

    /**
     * Corrects the sorting tree.
     *
     * @param arr Sorting tree vertex array
     * @param n Quantity vertex
     * @param i Vertex from which the correction begins
     */
    public static void correctSortTree(int[] arr, int n, int i) {
        int leftChild = 2 * i + 1;
        int rightChild = 2 * i + 2;
        int indxMax = i;
        if (leftChild < n && arr[leftChild] > arr[indxMax]) {
            indxMax = leftChild;
        }
        if (rightChild < n && arr[rightChild] > arr[indxMax]) {
            indxMax = rightChild;
        }
        if (indxMax != i) {
            swapElemArray(arr, i, indxMax);
            correctSortTree(arr, n, indxMax);
        }
    }

    /**
     * Function for heapsort.
     *
     * @param arr Array for sorting
     */
    public static void pyrSort(int[] arr) {
        int len = arr.length;
        int n = len / 2 - 1;

        for (int i = n; i >= 0; i--) {
            correctSortTree(arr, len, i);
        }

        for (int i = len - 1; i > 0; i--) {
            swapElemArray(arr, 0, i);
            correctSortTree(arr, i, 0);
        }

    }

    /**
     * Function for swap elements with index i1 and i2.
     *
     * @param arr Array
     * @param i1 First index
     * @param i2 Second index
     */
    public static void swapElemArray(int[] arr, int i1, int i2) {
        int tmp = arr[i1];
        arr[i1] = arr[i2];
        arr[i2] = tmp;
    }
}
