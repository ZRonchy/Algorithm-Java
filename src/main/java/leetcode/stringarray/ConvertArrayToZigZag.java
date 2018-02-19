package leetcode.stringarray;

import java.util.Arrays;

/**
 * Given an array of distinct elements, rearrange the elements of array in zig-zag fashion
 * in O(n) time. The converted array should be in form a < b > c < d > e < f.
 * <p>
 * Example:
 * Input:  arr[] = {4, 3, 7, 8, 6, 2, 1}
 * Output: arr[] = {3, 7, 4, 8, 2, 6, 1}
 * <p>
 * Input:  arr[] =  {1, 4, 3, 2}
 * Output: arr[] =  {1, 4, 2, 3}
 */
public class ConvertArrayToZigZag {
    static int arr[] = new int[]{4, 3, 7, 8, 6, 2, 1};

    // Method for zig-zag conversion of array
    static void zigZag() {
        // Flag true indicates relation "<" is expected,
        // else ">" is expected.  The first expected relation
        // is "<"
        boolean flag = true;

        int temp = 0;

        for (int i = 0; i <= arr.length - 2; i++) {
            if (flag)  /* "<" relation expected */ {
                /* If we have a situation like A > B > C,
                   we get A > B < C by swapping B and C */
                if (arr[i] > arr[i + 1]) {
                    // swap
                    temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                }

            } else /* ">" relation expected */ {
                /* If we have a situation like A < B < C,
                   we get A < C > B by swapping B and C */
                if (arr[i] < arr[i + 1]) {
                    // swap
                    temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                }
            }
            flag = !flag; /* flip flag */
        }
    }

    // Driver method to test the above function
    public static void main(String[] args) {
        zigZag();
        System.out.println(Arrays.toString(arr));
    }
}
