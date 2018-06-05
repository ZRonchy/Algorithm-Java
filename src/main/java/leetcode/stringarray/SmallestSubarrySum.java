package leetcode.stringarray;

/**
 * Given an array of integers and a positive number x, find the smallest subarray with sum
 * greater than the given value.
 * <p>
 * Examples:
 * arr[] = {1, 4, 45, 6, 0, 19}
 * x  =  51
 * Output: 3
 * Minimum length subarray is {4, 45, 6}
 * <p>
 * arr[] = {1, 10, 5, 2, 7}
 * x  = 9
 * Output: 1
 * Minimum length subarray is {10}
 * <p>
 * arr[] = {1, 11, 100, 1, 0, 200, 3, 2, 1, 250}
 * x = 280
 * Output: 4
 * Minimum length subarray is {100, 1, 0, 200}
 * <p>
 * arr[] = {1, 2, 4}
 * x = 8
 * Output : Not Possible
 * Whole array sum is smaller than 8.
 */
public class SmallestSubarrySum {
    //Sliding window
    static int smallestSubWithSum(int arr[], int x) {
        int n = arr.length;
        // Initialize current sum and minimum length
        int currSum = 0, minLen = n + 1;

        // Initialize starting and ending indexes
        int start = 0, end = 0;
        while (end < n) {
            // Keep adding array elements while current sum
            // is smaller than x
            while (currSum <= x && end < n) {
                if (currSum <= 0 && x > 0) {
                    start = end;
                    currSum = 0;
                }
                currSum += arr[end++];
            }

            // If current sum becomes greater than x.
            while (currSum > x && start < n) {
                // Update minimum length if needed
                if (end - start < minLen) {
                    minLen = end - start;
                }

                // remove starting elements
                currSum -= arr[start++];
            }
        }
        return minLen;
    }

    public static void main(String[] args) {
        int arr1[] = {1, 4, 45, 6, 52, 19};
        int x = 51;
        int n1 = arr1.length;
        int res1 = smallestSubWithSum(arr1, x);
        if (res1 == n1 + 1) {
            System.out.println("Not Possible");
        } else {
            System.out.println(res1);
        }

        int arr2[] = {1, 10, 5, 2, 7};
        int n2 = arr2.length;
        x = 9;
        int res2 = smallestSubWithSum(arr2, x);
        if (res2 == n2 + 1) {
            System.out.println("Not Possible");
        } else {
            System.out.println(res2);
        }
    }
}
