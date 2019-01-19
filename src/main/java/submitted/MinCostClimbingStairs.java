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
    public int minCostClimbingStairs(int[] cost) {
        for(int i = 2; i < cost.length; i++) {
            cost[i] += Math.min(cost[i-1], cost[i-2]);
        }

        return Math.min(cost[cost.length-1], cost[cost.length-2]);
    }
}
