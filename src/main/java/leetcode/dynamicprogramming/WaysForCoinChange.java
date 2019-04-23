package leetcode.dynamicprogramming;

import java.util.Arrays;

/**
 * Given a value N, if we want to make change for N cents, and we have infinite supply
 * of each of S = { S1, S2, .. , Sm} valued coins, how many ways can we make the change?
 * The order of coins does not matter.
 * For example, for N = 4 and S = {1,2,3}, there are four solutions: {1,1,1,1},{1,1,2},{2,2},{1,3}.
 * So output should be 4. For N = 10 and S = {2, 5, 3, 6}, there are five solutions:
 * {2,2,2,2,2}, {2,2,3,3}, {2,2,6}, {2,3,5} and {5,5}. So the output should be 5.
 * <p>
 * time: O(mn)
 *
 * dp[i][j] = dp[i][j-w[i]] + dp[i-1][j], i is the first i-th coins and j is the amount.
 * dp[0][j] = 0, dp[i][0] = 1;
 * 1. dp[i][j-w[i]] means among the first i coins, we could always make amount j by using at least one or more ith coin.
 * w[i] means at least one or more coins[i].
 * 2. dp[i-1][j] means without using coin[i], how many ways we could make amount j.
 * 3. the above state transfer function could be improved
 */
public class WaysForCoinChange {

    static long countWays(int coins[], int amount) {
        // dp[i] will be storing the number of solutions
        // for value i. We need amount+1 rows as the table is
        // constructed in bottom up manner using the base
        // case (amount = 0)
        int length = coins.length;
        long[] dp = new long[amount + 1];

        // Initialize all table values as 0
        Arrays.fill(dp, 0);   //O(n)

        // Base case (If given value is 0). In any case, only one way to make 0 amount which is use 0 coins.
        dp[0] = 1;

        // Pick all coins one by one and update the dp[]
        // values after the index greater than or equal to
        // the value of the picked coin.
        for (int i = 0; i < length; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                dp[j] += dp[j - coins[i]];
            }
        }

        return dp[amount];
    }

}
