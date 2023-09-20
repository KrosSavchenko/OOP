package org.example;

/**
 * Main class.
 */
public class Main {
    public static void main(String[] args) {
        int a = 1, b = 10;
        int[] den = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        pyrSort(den);
        PrintArray(den);
    }

    public static void CorrectSortTree(int[] arr, int n, int i) {
        int l = 2 * i + 1,
            r = 2 * i + 2,
            i_max = i;
        if (l < n && arr[l] > arr[i_max])
            i_max = l;
        if (r < n && arr[r] > arr[i_max])
            i_max = r;
        if (i_max != i){
            SwapElemArray(arr, i, i_max);
            CorrectSortTree(arr, n, i_max);
        }
    }

    public static void pyrSort(int[] arr) {
        int len = arr.length,
            n = len / 2 - 1;

        for (int i = n; i >= 0; i--)
            CorrectSortTree(arr, len, i);

        for (int i = len - 1; i > 0; i--){
            SwapElemArray(arr, 0, i);
            CorrectSortTree(arr, i, 0);
        }

    }

    public static void SwapElemArray(int[] arr, int indx1, int indx2) {
        int tmp = arr[indx1];
        arr[indx1] = arr[indx2];
        arr[indx2] = tmp;
    }

    public static void PrintArray(int[] arr){
        for (int x : arr)
            System.out.println(x);
    }
}