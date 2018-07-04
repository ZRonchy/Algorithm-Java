package leetcode.stringarray;

import java.util.Arrays;
import java.util.Collections;

/**
 * Given an array of integers (both odd and even), sort them in such a
 * way that the first part of the array contains odd numbers sorted in
 * descending order, rest portion contains even numbers sorted in ascending order.
 * Input  : arr[] = {1, 2, 3, 5, 4, 7, 10}
 * Output : arr[] = {7, 5, 3, 1, 2, 4, 10}
 * <p>
 * Input  : arr[] = {0, 4, 5, 3, 7, 2, 1}
 * Output : arr[] = {7, 5, 3, 1, 0, 2, 4}
 */
public class SortArrayByOddEven {
    // To do two way sort. First sort even numbers in
    // ascending order, then odd numbers in descending
    // order.
    static void twoWaySort(Integer arr[], int n) {
        // Current indexes from left and right
        int l = 0, r = n - 1;

        // Count of odd numbers
        int k = 0;

        while (l < r) {
            // Find first odd number from left side.
            while (arr[l] % 2 != 0) {
                l++;
                k++;
            }

            // Find first even number from right side.
            while (arr[r] % 2 == 0 && l < r)
                r--;

            // Swap odd number present on left and even
            // number right.
            if (l < r) {
                //  swap arr[l] arr[r]
                int temp = arr[l];
                arr[l] = arr[r];
                arr[r] = temp;

            }

        }

        // Sort odd number in descending order
        Arrays.sort(arr, 0, k, Collections.reverseOrder());

        // Sort even number in ascending order
        Arrays.sort(arr, k, n);
    }

    // 1.Make all odd numbers negative
    // 2. Sort all numbers.
    // 3. Revert the changes made in step 1 to get original elements back.
    static void twoWaySort2(int arr[], int n) {
        // Make all odd numbers negative
        for (int i = 0; i < n; i++)
            if ((arr[i] & 1) != 0) // Check for odd
                arr[i] *= -1;

        // Sort all numbers
        Arrays.sort(arr);

        // Retaining original array
        for (int i = 0; i < n; i++)
            if ((arr[i] & 1) != 0)
                arr[i] *= -1;
    }

    public static void main(String[] args) {
        Integer arr[] = {1, 3, 2, 7, 5, 4};
        twoWaySort(arr, arr.length);
        System.out.println(Arrays.toString(arr));
    }
}
