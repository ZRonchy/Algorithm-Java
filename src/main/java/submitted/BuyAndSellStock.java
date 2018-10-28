package submitted;

/**
 * https://leetcode.com/submissions/detail/185960287/
 * lowestPrice[i] keeps lowest price till i-th day
 * profit[i] keeps maximum profit till i-th day
 * max keeps the maximum profit globally
 */
public class BuyAndSellStock {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length==0) {
            return 0;
        }

        int[] lowestPrice = new int[prices.length];
        int[] profit = new int[prices.length];
        int maxProfit = 0;
        lowestPrice[0] = prices[0];
        profit[0] = 0;

        for (int i=1; i<prices.length;i++) {
            lowestPrice[i] = Math.min(lowestPrice[i-1], prices[i]);
            profit[i] = Math.max(profit[i-1], prices[i] - lowestPrice[i]);
            maxProfit = Math.max(profit[i], maxProfit);
        }

        return maxProfit;
    }
}
