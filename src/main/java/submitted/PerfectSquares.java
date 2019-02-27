package submitted;

import java.util.Arrays;

/**
 * https://leetcode.com/submissions/detail/211130083/
 * time : O(n * sqrt(n))
 * space: O(n)
 */
public class PerfectSquares {
    public int numSquares(int n) {
        int[] res = new int[n + 1];
        Arrays.fill(res, Integer.MAX_VALUE);
        res[0] = 0;
        for (int i = 0; i <= n; i++) {
            for (int j = 1; j * j <= i; j++) {
                res[i] = Math.min(res[i], res[i - j * j] + 1);
            }
        }
        return res[n];
    }
}
