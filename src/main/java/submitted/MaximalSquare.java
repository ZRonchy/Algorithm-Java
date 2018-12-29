package submitted;

/**
 * https://leetcode.com/submissions/detail/197781251/
 */
public class MaximalSquare {
    // O(n*n*n)
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }

        int m = matrix.length;
        int n = matrix[0].length;

        // sums[i][j] = sum(matrix[0][0] ~ matrix[i-1][j-1])
        //sums[x][y] = sums[x][y-1] + sums[x-1][y] - sums[x-1][y-1] + matrix[x][y]
        int[][] sums = new int[m + 1][n + 1];
        // i<=m, j<=n to include square with matrix[m-1][n-1]
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                sums[i][j] = matrix[i - 1][j - 1] - '0'
                        + sums[i - 1][j]
                        + sums[i][j - 1]
                        - sums[i - 1][j - 1];
            }
        }

        int res = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // From largest square to smallest square,
                // if larger square is full of 1s, no need to
                // check smaller one
                for (int k = Math.min(m - i + 1, n - j + 1); k > 0; --k) {
                    int sum = sums[i + k - 1][j + k - 1]
                            - sums[i + k - 1][j - 1]
                            - sums[i - 1][j + k - 1]
                            + sums[i - 1][j - 1];
                    // full of 1
                    if (sum == k * k) {
                        res = Math.max(res, sum);
                        break;
                    }
                }
            }
        }

        return res;
    }

    /**
     * dp[x][y] := max size can achieve at (x,y) as bottom right
     * (x-dp[x][y], y-[x][y]) - (x,y) are all 1s
     * dp[x][y] = 0, if matrix[x][y] == 0;
     * dp[x][y] = min(dp[x-1][y], dp[x][y-1], dp[x-1][y-1]) + 1, if matrix[x][y] == 1
     * time O(n*n)
     */
    public int maximalSquare2(char[][] matrix) {
        if (matrix.length == 0) return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int res = 0;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (matrix[i - 1][j - 1] == '1') {
                    dp[i][j] = Math.min(Math.min(dp[i][j - 1], dp[i - 1][j - 1]), dp[i - 1][j]) + 1;
                    res = Math.max(res, dp[i][j]);
                }
            }
        }
        return res * res;
    }
}
