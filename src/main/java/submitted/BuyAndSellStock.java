package submitted;

/**
 * https://leetcode.com/submissions/detail/186190734/
 * lowestPrice[i] keeps lowest price till i-th day
 * profit[i] keeps maximum profit till i-th day
 * max keeps the maximum profit globally
 */
public class BuyAndSellStock {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length==0) {
            return 0;
        }

        int lowestPrice = prices[0];
        int[] profit = new int[prices.length];
        int maxProfit = 0;

        for (int i=1; i<prices.length;i++) {
            profit[i] = Math.max(profit[i-1], prices[i] - lowestPrice); //today's price cannot be lowest price
            lowestPrice = Math.min(lowestPrice, prices[i]);
            maxProfit = Math.max(profit[i], maxProfit);
        }

        return maxProfit;
    }
}
