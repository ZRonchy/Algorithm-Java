package submitted;

/**
 * https://leetcode.com/submissions/detail/210335579/
 * time: O(n * sum), n is the number size, sum is the total sum
 * space: O(n * sum)
 */
public class TargetSum {
    /**
     * Time: O(n^2), Space: O(n^2)
     * sub-problem: dp[i][j] represents number of possible ways to reach sum j by using first ith items
     * base case: dp[0][sum], position sum represents sum 0
     * recurrence relation:
     * dp[i][j] += dp[i - 1][i + nums[i - 1]] if j + nums[i - 1] <= sum * 2
     * dp[i][j] += dp[i - 1][i - nums[i - 1]] if j - nums[i - 1] >= 0
     *
     * explanation: if j + nums[i - 1] or j - nums[i - 1] is in correct range, we can use the number nums[i - 1]
     * to generate next state of dp array
     * */
    public int findTargetSumWays_dp(int[] nums, int S) {
        if (nums.length == 0) {
            return 0;
        }

        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        // corner case: when S is out of range [-sum, sum]
        if (S < -sum || S > sum) {
            return 0;
        }

        int[][] dp = new int[nums.length + 1][sum * 2 + 1];
        dp[0][sum] = 1;
        int leftBound = 0;
        int rightBound = sum * 2;
        for (int i = 1; i <= nums.length; i++) {
            for (int j = leftBound; j < rightBound + 1; j++) {
                // try all possible sum of (previous sum j + current number nums[i - 1]) and all possible difference of
                // (previous sum j - current number nums[i - 1])
                if (j + nums[i - 1] <= rightBound) {
                    dp[i][j] += dp[i - 1][j + nums[i - 1]];
                }
                if (j - nums[i - 1] >= leftBound) {
                    dp[i][j] += dp[i - 1][j - nums[i - 1]];
                }
            }
        }
        return dp[nums.length][sum + S];
    }

    // DFS with memorization
    private int ans;
    public int findTargetSumWays_dfs(int[] nums, int S) {
        int sum = 0;
        for (final int num : nums) {
            sum += num;
        }
        if (sum < Math.abs(S)) {
            return 0;
        }
        ans = 0;
        dfs(nums, 0, S);
        return ans;
    }

    private void dfs(int[] nums, int index, int S) {
        if (index == nums.length) {
            if (S == 0) {
                ++ans;
            }
            return;
        }
        dfs(nums, index + 1, S - nums[index]);
        dfs(nums, index + 1, S + nums[index]);
    }
}
