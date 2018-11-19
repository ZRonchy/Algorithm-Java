package submitted;

/**
 * https://leetcode.com/submissions/detail/190580170/
 */
public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = dp[0];

        for (int i=1; i < nums.length; i++) {
            dp[i] = Math.max(nums[i], dp[i-1]+nums[i]);
            max = Math.max(max, dp[i]);

        }

        return max;

    }
}
