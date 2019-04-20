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
            // if dp[i] is only affected by dp[i-1], could be improved by using one int dp
            dp[i] = Math.max(nums[i], dp[i-1]+nums[i]);
            max = Math.max(max, dp[i]);
        }

        return max;
    }

    public int maxSubArray_imp(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int dp = nums[0]; //  dp means max value end here
        int max = nums[0]; // max means max value so far

        for (int i=1; i < nums.length; i++) {
            dp = Math.max(nums[i], dp+nums[i]);
            max = Math.max(max, dp);
        }

        return max;

    }
}
