package leetcode.stringarray;
// Given an unsorted array of integers, find the length of longest increasing subsequence.
// For example,
// Given [10, 9, 2, 5, 3, 7, 101, 18],
// The longest increasing subsequence is [2, 3, 7, 101], therefore the length is 4.
// Note that there may be more than one LIS combination, it is only necessary for you to return the length.

import java.util.Arrays;

public class LongestIncreasingSubsequence {
    public static void main(String... args) {
        int[] nums = {10, 9, 4, 5, 3, 7, 101, 2};
        System.out.println(longestIncreasingSubsequence(nums));

    }

    /**
     * Let arr[0..n-1] be the input array and L(i) be the length of the LIS ending at index i
     * such that arr[i] is the last element of the LIS. Then, L(i) can be recursively written as:
     L(i) = 1 + max( L(j) ) where 0 < j < i and arr[j] < arr[i]; or
     L(i) = 1, if no such j exists.
     To find the LIS for a given array, we need to return max(L(i)) where 0 < i < n.
     Thus, we see the LIS problem satisfies the optimal substructure property as the main problem
     can be solved using solutions to subproblems.
     * @param arr
     * @return
     */
    static int longestIncreasingSubsequence(int arr[]) {
        int n = arr.length;
        int lis[] = new int[n];
        int i, j, max = 0;

        /* Initialize LIS values for all indexes */
        for (i = 0; i < n; i++) {
            lis[i] = 1;
        }

        /* Compute optimized LIS values in bottom up manner */
        for (i = 1; i < n; i++) {
            for (j = 0; j < i; j++) {
                if (arr[i] > arr[j] && lis[i] < lis[j] + 1) {
                    lis[i] = lis[j] + 1;
                }
            }
        }

        /* Pick maximum of all LIS values */
        for (i = 0; i < n; i++) {
            if (max < lis[i]) {
                max = lis[i];
            }
        }

        return max;
    }

}