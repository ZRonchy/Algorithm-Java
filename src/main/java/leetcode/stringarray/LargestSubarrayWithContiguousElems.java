package leetcode.stringarray;

import java.util.HashSet;

/**
 * Given an array of distinct integers, find length of the longest subarray
 * which contains numbers that can be arranged in a continuous sequence.
 * Examples:
 * <p>
 * Input:  arr[] = {10, 12, 11};
 * Output: Length of the longest contiguous subarray is 3
 * <p>
 * Input:  arr[] = {14, 12, 11, 20};
 * Output: Length of the longest contiguous subarray is 2
 * <p>
 * Input:  arr[] = {1, 56, 58, 57, 90, 92, 94, 93, 91, 45};
 * Output: Length of the longest contiguous subarray is 5
 * <p>
 * The important thing to note in question is, it is given that all elements are
 * distinct. If all elements are distinct, then a subarray has contiguous elements
 * if and only if the difference between maximum and minimum elements in subarray
 * is equal to the difference between last and first indexes of subarray. So the
 * idea is to keep track of minimum and maximum element in every subarray.
 */
public class LargestSubarrayWithContiguousElems {
    // Returns length of the longest contiguous subarray
    // only work if all elements are unique
    int findLength(int arr[], int n) {
        int max_len = 1;  // Initialize result
        for (int i = 0; i < n - 1; i++) {
            // Initialize min and max for all subarrays starting with i
            int mn = arr[i], mx = arr[i];

            // Consider all subarrays starting with i and ending with j
            for (int j = i + 1; j < n; j++) {
                // Update min and max in this subarray if needed
                mn = Math.min(mn, arr[j]);
                mx = Math.max(mx, arr[j]);

                // If current subarray has all contiguous elements
                if ((mx - mn) == j - i)
                    max_len = Math.max(max_len, mx - mn + 1);
            }
        }
        return max_len;  // Return result
    }

    /**
     * we checked whether maximum value minus minimum value is equal to
     * ending index minus starting index or not. Since duplicate elements
     * are allowed, we also need to check if the subarray contains duplicate
     * elements or not. For example, the array {12, 14, 12} follows the first
     * property, but numbers in it are not contiguous elements. To check duplicate
     * elements in a subarray, we create a hash set for every subarray and if we find
     * an element already in hash, we don’t consider the current subarray.
     */
    static int findLength(int arr[]) {
        int n = arr.length;
        int max_len = 1; // Inialize result

        // One by one fix the starting points
        for (int i = 0; i < n - 1; i++) {
            // Create an empty hash set and add i'th element
            // to it.
            HashSet<Integer> set = new HashSet<>();
            set.add(arr[i]);

            // Initialize max and min in current subarray
            int mn = arr[i], mx = arr[i];

            // One by one fix ending points
            for (int j = i + 1; j < n; j++) {
                // If current element is already in hash set, then
                // this subarray cannot contain contiguous elements
                if (set.contains(arr[j])) {
                    break;
                }

                // Else add curremt element to hash set and update
                // min, max if required.
                set.add(arr[j]);
                mn = Math.min(mn, arr[j]);
                mx = Math.max(mx, arr[j]);

                // We have already cheched for duplicates, now check
                // for other property and update max_len if needed
                if (mx - mn == j - i) {
                    max_len = Math.max(max_len, mx - mn + 1);
                }
            }
        }
        return max_len; // Return result
    }

}
