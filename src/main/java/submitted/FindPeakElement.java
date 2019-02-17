package submitted;

import java.util.Stack;

/**
 * https://leetcode.com/submissions/detail/208378987/
 */
public class FindPeakElement {
    // time O(logn) space O(1)
    public int findPeakElement(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        while (start + 1 < end) {
            int mid = (end - start) / 2 + start;
            if (nums[mid] > nums[mid + 1]) {
                end = mid; // nums[end] could be the peak
            } else {
                start = mid + 1; // nums[start] could be the peak
            }
        }
        if (nums[start] > nums[end]) return start;
        return end;
    }

    public int findPeakElement1(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            if (nums[i-1] > nums[i]) {
                return i-1;
            }
        }
        return nums.length - 1;
    }

    // Monotonic Stack time O(n), space O(n)
    public int findPeakElement2(int[] nums) {
        if (nums.length == 1) return 0;
        Stack<Integer> stack = new Stack<>();
        int h = 0;
        for (int i = 0; i <= nums.length; i++) {
            h = (i == nums.length) ? Integer.MIN_VALUE : nums[i];
            if (stack.isEmpty() || nums[stack.peek()] <= h) {
                stack.push(i);
            } else {
                return stack.pop();
            }
        }
        return -1;
    }


}
