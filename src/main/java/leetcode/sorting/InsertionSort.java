package leetcode.sorting;

import java.util.Arrays;

// Worst case performance О(n2) comparisons, swaps
// Best case performance O(n) comparisons, O(1) swaps
// Average case performance О(n2) comparisons, swaps
// Worst case space complexity О(n) total, O(1) auxiliary
public class InsertionSort {
    public static void main(String[] args) {
        int[] array = {1, 3, 6, 4, 5, 2};
        insertionSort(array);
        System.out.print(Arrays.toString(array));

    }

    private static void insertionSort(int[] array) {
        for (int i=1; i<array.length; i++) {
            if (array[i-1] > array[i]) {
                int temp = array[i];
                int j = i;
                while (j > 0 && array[j-1] > temp) {
                    array[j] = array[j-1];
                    j--;
                }
                array[j] = temp;
            }
        }
    }

}