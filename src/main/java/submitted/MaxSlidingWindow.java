package submitted;

import java.util.Deque;
import java.util.LinkedList;

/**
 *  https://leetcode.com/submissions/detail/202321138/
 */
public class MaxSlidingWindow {
    // Brute Force time O((n – k + 1) * k), space O(1)
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (k == 0) return new int[0];

        int[] ans = new int[nums.length - k + 1];
        for (int i = k - 1; i < nums.length; ++i) {
            int maxNum = nums[i];
            for (int j = 1; j < k; ++j)
                if (nums[i - j] > maxNum) maxNum = nums[i - j];
            ans[i - k + 1] = maxNum;
        }
        return ans;
    }

    // Monotonic Queue time O(n), space O(k)
    // http://zxi.mytechroad.com/blog/heap/leetcode-239-sliding-window-maximum/
    public int[] maxSlidingWindow1(int[] nums, int k) {
        if (k == 0) return nums;

        int[] ans = new int[nums.length - k + 1];
        Deque<Integer> indices = new LinkedList<>();

        for (int i = 0; i < nums.length; ++i) {
            while (indices.size() > 0 && nums[i] >= nums[indices.getLast()]) {
                indices.removeLast();
            }

            indices.addLast(i);
            if (i - k + 1 >= 0) {
                ans[i - k + 1] = nums[indices.getFirst()];
            }
            if (i - k + 1 >= indices.getFirst()) {
                indices.removeFirst();
            }
        }

        return ans;
    }
}
