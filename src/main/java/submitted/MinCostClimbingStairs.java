package submitted;

/**
 * https://leetcode.com/submissions/detail/202139857/
 * 1. dp[n] min cost to climb to n-ith step
 *    dp[n] = min(dp[n-1] + cost[n-1], dp[n-2]+cost[n-2])
 * 2. dp[n] min cost before leaving n-ith step
 *    dp[n] = min(dp[n-1], dp[n-2]) + cost[n]
 *    answer = min(dp[n-1], dp[n-2])
 */
public class MinCostClimbingStairs {
    // time O(n) space O(n)
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length+1];
        for (int i = 2; i <= cost.length; ++i) {
            dp[i] = Math.min(dp[i - 1] + cost[i - 1],
                    dp[i - 2] + cost[i - 2]);
        }
        return dp[cost.length];
    }

    // time O(n) space O(1)
    public int minCostClimbingStairs1(int[] cost) {
        int dp1 = 0;
        int dp2 = 0;
        for (int i = 2; i <= cost.length; ++i) {
            int dp = Math.min(dp1 + cost[i - 1], dp2 + cost[i - 2]);
            dp2 = dp1;
            dp1 = dp;
        }
        return dp1;
    }

    public int minCostClimbingStairs2(int[] cost) {
        for(int i = 2; i < cost.length; i++) {
            cost[i] += Math.min(cost[i-1], cost[i-2]);
        }

        return Math.min(cost[cost.length-1], cost[cost.length-2]);
    }
}
