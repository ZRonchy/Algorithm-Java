package submitted;

/**
 * https://leetcode.com/submissions/detail/210134677/
 * time O(n*n*n)
 * space O(n*n)
 */
public class BurstBallons {
    public int maxCoins(int[] nums) {
        int[] inums = new int[nums.length + 2];
        int n = nums.length;
        inums[0] = 1;
        inums[inums.length - 1] = 1;
        for (int i = 0; i < nums.length; i++) {
            inums[i + 1] = nums[i];
        }

        //dp[i][j]: maxCoins from nums[i] to nums[j]
        int[][] dp = new int[n + 2][n + 2];
        // l is the length, represents how many ballons have been burst
        for (int l = 1; l <= n; ++l)
            // i is the starting position, l is the length so j = i+l-1 is the ending position
            for (int i = 1; i <= n - l + 1; ++i) {
                int j = i + l - 1;
                for (int k = i; k <= j; ++k) {
                    dp[i][j] = Math.max(dp[i][j], dp[i][k - 1] + inums[i - 1] * inums[k] * inums[j + 1] + dp[k + 1][j]);
                }
            }
        return dp[1][n];
    }

    public int maxCoins_recursion(int[] iNums) {
        int[] nums = new int[iNums.length + 2];
        int n = 1;
        for (int x : iNums) if (x > 0) nums[n++] = x;
        nums[0] = nums[n++] = 1;


        int[][] memo = new int[n][n];
        return burst(memo, nums, 0, n - 1);
    }

    public int burst(int[][] memo, int[] nums, int left, int right) {
        if (left + 1 == right) return 0;
        if (memo[left][right] > 0) return memo[left][right];
        int ans = 0;
        for (int i = left + 1; i < right; ++i)
            ans = Math.max(ans, nums[left] * nums[i] * nums[right]
                    + burst(memo, nums, left, i) + burst(memo, nums, i, right));
        memo[left][right] = ans;
        return ans;
    }
}
