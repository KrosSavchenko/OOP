package org.example;

/**
 * Main class.
 */
public class Main {
    public static void main(String[] args) {

    }

    /**
     * Corrects the sorting tree.
     * @param arr Sorting tree vertex array
     * @param n Quantity vertex
     * @param i Vertex from which the correction begins
     */
    public static void correctSortTree(int[] arr, int n, int i) {
        int l = 2 * i + 1;
        int r = 2 * i + 2;
        int iMax = i;
        if (l < n && arr[l] > arr[iMax]) {
            iMax = l;
        }
        if (r < n && arr[r] > arr[iMax]) {
            iMax = r;
        }
        if (iMax != i){
            SwapElemArray(arr, i, iMax);
            correctSortTree(arr, n, iMax);
        }
    }

    public static void pyrSort(int[] arr) {
        int len = arr.length;
        int n = len / 2 - 1;

        for (int i = n; i >= 0; i--) {
            correctSortTree(arr, len, i);
        }

        for (int i = len - 1; i > 0; i--){
            SwapElemArray(arr, 0, i);
            correctSortTree(arr, i, 0);
        }

    }

    public static void SwapElemArray(int[] arr, int indx1, int indx2) {
        int tmp = arr[indx1];
        arr[indx1] = arr[indx2];
        arr[indx2] = tmp;
    }
}
