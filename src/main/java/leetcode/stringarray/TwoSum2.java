package leetcode.stringarray;
// Similar to twosum but input array is sorted

import java.util.Arrays;

public class TwoSum2 {
    public static void main(String[] args) {
        int[] S = {2, 7, 11, 15};
        int[] lists = twoSum(S, 13);
        Arrays.stream(lists).forEach(l -> System.out.print(l + ","));
    }

    private static int[] twoSum(int[] numbers, int target) {
        if (numbers == null || numbers.length == 0)
            return null;

        int i = 0;
        int j = numbers.length - 1;

        while (i < j) {
            int x = numbers[i] + numbers[j];
            if (x < target) {
                ++i;
            } else if (x > target) {
                j--;
            } else {
                return new int[] {i, j};
            }
        }

        return null;
    }

}
