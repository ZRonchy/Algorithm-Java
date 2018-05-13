package leetcode.stringarray;

import java.util.Arrays;

/**
 * Given an array of distinct integers and a sum value. Find count
 * of triplets with sum smaller than given sum value. Expected Time
 * Complexity is O(n2).
 * Input : arr[] = {-2, 0, 1, 3}
 * sum = 2.
 * Output : 2
 * Explanation :  Below are triplets with sum less than 2
 * (-2, 0, 1) and (-2, 0, 3)
 * <p>
 * Input : arr[] = {5, 1, 3, 4, 7}
 * sum = 12.
 * Output : 4
 * Explanation :  Below are triplets with sum less than 4
 * (1, 3, 4), (1, 3, 5), (1, 3, 7) and
 * (1, 4, 5)
 * <p>
 * 1) Sort the input array in increasing order.
 * 2) Initialize result as 0.
 * 3) Run a loop from i = 0 to n-2.  An iteration of this loop finds all
 * triplets with arr[i] as first element.
 * a) Initialize other two elements as corner elements of subarray
 * arr[i+1..n-1], i.e., j = i+1 and k = n-1
 * b) Move j and k toward each other until they meet, i.e., while (j < k)
 * (i) if (arr[i] + arr[j] + arr[k] >= sum), then do k--
 * <p>
 * // Else for current i and j, there can (k-j) possible third elements
 * // that satisfy the constraint.
 * (ii) Else Do ans += (k - j) followed by j++
 */
public class CountTripletsSumSmallerThanX {
    int countTripletsSumLessThanX(int[] arr, int sum) {
        Arrays.sort(arr);
        int result = 0;
        int n = arr.length;
        for (int i = 0; i < n - 2; i++) {
            // Initialize other two elements as corner elements
            // of subarray arr[j+1..k]
            int j = i + 1, k = n - 1;

            // Use Meet in the Middle concept
            while (j < k) {
                // If sum of current triplet is more or equal,
                // move right corner to look for smaller values
                if (arr[i] + arr[j] + arr[k] >= sum) {
                    k--;
                }
                    // Else move left corner
                else {
                    // This is important. For current i and j, there
                    // can be total k-j third elements.
                    result += (k - j);
                    j++;
                }
            }
        }

        return result;
    }
}
