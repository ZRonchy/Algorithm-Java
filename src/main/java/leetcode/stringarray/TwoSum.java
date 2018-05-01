package leetcode.stringarray;
// Given an array of integers, find two numbers such that they add up to a specific target number.
// The function twoSum should return indices of the two numbers such that they add up to the target,
// where index1 must be less than index2.
// Please note that your returned answers (both index1 and index2) are not zero-based. e.g.
// Input: numbers={2, 7, 11, 15}, target=9
// Output: index1=0, index2=1

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {
    public static void main(String[] args) {
        int[] S = {2, 7, 11, 15};
        int[] lists = twoSum(S, 13);
        Arrays.stream(lists).forEach(l -> System.out.print(l + ","));
    }

    private static int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length < 2)
            return new int[]{0, 0};

        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                return new int[]{map.get(nums[i]), i};
            } else {
                map.put(target - nums[i], i);
            }
        }

        return new int[]{0, 0};
    }

    // meet in the middle
    static boolean twoSum_mim(int A[], int arr_size, int sum) {
        int l, r;

        /* Sort the elements */
        Arrays.sort(A);

        /* Now look for the two candidates
        in the sorted array*/
        l = 0;
        r = arr_size - 1;
        while (l < r) {
            if (A[l] + A[r] == sum)
                return true;
            else if (A[l] + A[r] < sum)
                l++;
            else // A[i] + A[j] > sum
                r--;
        }
        return false;
    }
}
