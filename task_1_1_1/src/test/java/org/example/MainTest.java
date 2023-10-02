package org.example;

import org.junit.jupiter.api.Assertions;

import org.junit.jupiter.api.Test;

/** Main class for the tests.*/
public class MainTest {
    @Test
    void test1RandomFrom1To15WithRepetitions() {
        int[] notSorted = {10, 5, 6, 3, 7, 13, 12, 14, 5, 8, 8, 14, 6, 4, 9, 7, 5, 8, 8, 6};
        int[] sorted = {3, 4, 5, 5, 5, 6, 6, 6, 7, 7, 8, 8, 8, 8, 9, 10, 12, 13, 14, 14};
        int n = notSorted.length;
        Main.pyrSort(notSorted);
        for (int i = 0; i < n; i++) {
            Assertions.assertEquals(notSorted[i], sorted[i]);
        }
    }

    @Test
    void test2SevenEquals() {
        int[] notSorted = {0, 0, 0, 0, 0, 0, 0};
        int[] sorted = {0, 0, 0, 0, 0, 0, 0};
        int n = notSorted.length;
        Main.pyrSort(notSorted);
        for (int i = 0; i < n; i++) {
            Assertions.assertEquals(notSorted[i], sorted[i]);
        }
    }

    @Test
    void test3TwentyNumbersWithNegative() {
        int[] notSorted = {71, 20, -63, 36, 79, 46, -79, 90, 66, 35,
            32, 43, -35, 13, 63, -66, 23, 10, 94, 83};
        int[] sorted = {-79, -66, -63, -35, 10, 13, 20, 23, 32,
            35, 36, 43, 46, 63, 66, 71, 79, 83, 90, 94};
        int n = notSorted.length;
        Main.pyrSort(notSorted);
        for (int i = 0; i < n; i++) {
            Assertions.assertEquals(notSorted[i], sorted[i]);
        }
    }

    @Test
    void test4LargestInts() {
        int[] notSorted = {2147483645, 2147483643, 2147483640, 2147483642,
            2147483644, 2147483641, 2147483647, 2147483646};
        int[] sorted =  {2147483640, 2147483641, 2147483642, 2147483643,
            2147483644, 2147483645, 2147483646, 2147483647};
        int n = notSorted.length;
        Main.pyrSort(notSorted);
        for (int i = 0; i < n; i++) {
            Assertions.assertEquals(notSorted[i], sorted[i]);
        }
    }

    @Test
    void test5SmallestInts() {
        int[] notSorted = {-2147483644, -2147483646, -2147483640, -2147483643,
            -2147483642, -2147483647, -2147483641, -2147483645};
        int[] sorted = {-2147483647, -2147483646, -2147483645, -2147483644,
            -2147483643, -2147483642, -2147483641, -2147483640};
        int n = notSorted.length;
        Main.pyrSort(notSorted);
        for (int i = 0; i < n; i++) {
            Assertions.assertEquals(notSorted[i], sorted[i]);
        }
    }

    @Test
    void test6LargestWithSmaller() {
        int[] notSorted = {2147483647, -2147483647};
        int[] sorted = {-2147483647, 2147483647};
        int n = notSorted.length;
        Main.pyrSort(notSorted);
        for (int i = 0; i < n; i++) {
            Assertions.assertEquals(notSorted[i], sorted[i]);
        }
    }

    @Test
    void test7LargeNumbers() {
        int[] notSorted = {9422811, 2309890, 8603666, 4560173, 2730642, 2667067,
            8540634, 3535193, 6584937, 4753014, 4213291, 3028952,
            2684175, 828514, 4555449, 1155942, 1225390};
        int[] sorted = {828514, 1155942, 1225390, 2309890, 2667067, 2684175,
            2730642, 3028952, 3535193, 4213291, 4555449, 4560173,
            4753014, 6584937, 8540634, 8603666, 9422811};
        int n = notSorted.length;
        Main.pyrSort(notSorted);
        for (int i = 0; i < n; i++) {
            Assertions.assertEquals(notSorted[i], sorted[i]);
        }
    }

    @Test
    void test8FifteenNumbers() {
        int[] notSorted = {5, 3, 14, 1, 4, 12, 10, 15, 6, 9, 8, 2, 7, 13, 11};
        int[] sorted = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        int n = notSorted.length;
        Main.pyrSort(notSorted);
        for (int i = 0; i < n; i++) {
            Assertions.assertEquals(notSorted[i], sorted[i]);
        }
    }
    @Test
    void test9SixteenNumbers() {
        int[] notSorted = {6, 11, 8, 12, 9, 3, 14, 13, 2, 5, 10, 1, 7, 4, 16, 15};
        int[] sorted = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16};
        int n = notSorted.length;
        Main.pyrSort(notSorted);
        for (int i = 0; i < n; i++) {
            Assertions.assertEquals(notSorted[i], sorted[i]);
        }
    }

    @Test
    void test10SeventeenNumbers() {
        int[] notSorted = {17, 16, 15, 14, 13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        int[] sorted = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17};
        int n = notSorted.length;
        Main.pyrSort(notSorted);
        for (int i = 0; i < n; i++) {
            Assertions.assertEquals(notSorted[i], sorted[i]);
        }
    }
}
