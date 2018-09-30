package leetcode.dynamicprogramming;

import static java.lang.Math.max;

/**
 * Say you have an array for which the ith element is the price of a given stock on day i.

 Design an algorithm to find the maximum profit. You may complete at most two transactions.
 Note:
 A transaction is a buy & a sell. You may not engage in multiple transactions at the same time
 (ie, you must sell the stock before you buy again).

 我们其实可以求至少k次交易的最大利润，找到通解后可以设定 k = 2，即为本题的解答。我们定义local[i][j]为在到达
 第i天时最多可进行j次交易并且最后一次交易在最后一天卖出的最大利润，此为局部最优。然后我们定义global[i][j]为
 在到达第i天时最多可进行j次交易的最大利润，此为全局最优。它们的递推式为：

 local[i][j] = max(global[i - 1][j - 1] + max(diff, 0), local[i - 1][j] + diff)

 global[i][j] = max(local[i][j], global[i - 1][j])

 其中局部最优值是比较前一天并少交易一次的全局最优加上大于0的差值，和前一天的局部最优加上差值中取较大值，而全局
 最优比较局部最优和前一天的全局最优。
 */
public class BuySellStockIII {
    int maxProfit(int[] prices) {
        if (prices.length == 0)
            return 0;
        int n = prices.length;
        int[][] g = new int[n][3];
        int[][] l = new int[n][3];
        for (int i = 1; i < prices.length; ++i) {
            int diff = prices[i] - prices[i - 1];
            for (int j = 1; j <= 2; ++j) {
                l[i][j] = max(g[i - 1][j - 1] + max(diff, 0), l[i - 1][j] + diff);
                g[i][j] = max(l[i][j], g[i - 1][j]);
            }
        }
        return g[n - 1][2];
    }
}