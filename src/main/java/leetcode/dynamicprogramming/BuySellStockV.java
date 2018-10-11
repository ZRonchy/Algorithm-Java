package leetcode.dynamicprogramming;

import static java.lang.Math.max;

/**
 * Say you have an array for which the ith element is the price of a given stock on day i.

 Design an algorithm to find the maximum profit. You may complete as many transactions as
 you like (ie, buy one and sell one share of the stock multiple times) with the following restrictions:

 You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 After you sell your stock, you cannot buy stock on next day. (ie, cooldown 1 day)
 Example:

 prices = [1, 2, 3, 0, 2]
 maxProfit = 3
 transactions = [buy, sell, cooldown, buy, sell]

 Solution:
 buy[i]表示在第i天之前最后一个操作是买，此时的最大收益。

 sell[i]表示在第i天之前最后一个操作是卖，此时的最大收益。

 rest[i]表示在第i天之前最后一个操作是冷冻期，此时的最大收益。

 我们写出递推式为：

 buy[i]  = max(rest[i-1] - price[i], buy[i-1])
 sell[i] = max(buy[i-1] + price[i], sell[i-1])
 rest[i] = max(sell[i-1], buy[i-1], rest[i-1])
 rest: cooldown或什么都不做
 上述递推式很好的表示了在买之前有冷冻期，买之前要卖掉之前的股票。一个小技巧是如何保证[buy, rest, buy]的情况不会出现，
 这是由于buy[i] <= rest[i]， 即rest[i] = max(sell[i-1], rest[i-1])，这保证了[buy, rest, buy]不会出现。

 另外，由于冷冻期的存在，我们可以得出rest[i] = sell[i-1]，这样，我们可以将上面三个递推式精简到两个：

 1. 对于sell[i]，最大利润有两种可能，一是今天没动作跟昨天未持股状态一样，二是今天卖了股票，所以状态转移方程如下：
 sell[i] = max{sell[i - 1], buy[i-1] + prices[i]}
 2. 对于buy[i]，最大利润有两种可能，一是今天没动作跟昨天持股状态一样，二是前天卖了股票，今天买了股票，因为 cooldown 只能隔天交易，所以今天买股票要追溯到前天的状态。状态转移方程如下：
 buy[i] = max{buy[i-1], sell[i-2] - prices[i]}
 最终我们要求的结果是sell[n - 1]，表示最后一天结束时，手里没有股票时的最大利润。

 https://www.cnblogs.com/grandyang/p/4997417.html
 https://soulmachine.gitbooks.io/algorithm-essentials/java/dp/best-time-to-buy-and-sell-stock-with-cooldown.html
 */
public class BuySellStockV {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;

        int[] sell = new int[prices.length];
        int[] buy = new int[prices.length];
        sell[0] = 0;
        buy[0] = buy[0] - prices[0];

        for (int i = 1; i < prices.length; ++i) {
            sell[i] = Math.max(sell[i - 1], buy[i - 1] + prices[i]);
            buy[i] = Math.max(buy[i - 1], (i > 1 ? sell[i - 2] : 0) - prices[i]);
        }
        return sell[prices.length - 1];
    }
}
