package leetcode.matrix;

/**
 * Given a 2D binary matrix filled with 0's and 1's, find the largest square containing
 * all 1's and return its area.
 * <p>
 * For example, given the following matrix:
 * 1101
 * 1101
 * 1111
 * Return 4.
 * This problem can be solved by dynamic programming. The changing condition is:
 * t[i][j] = min(t[i][j-1], t[i-1][j], t[i-1][j-1]) + 1. It means the square formed before this point.
 * <p>
 * Solution 1:
 * Like RangeSumQuery, get all sums at O(mn) and then calculate whether each matrix has all 1s O(n*n*n)
 * dp[x][y] = dp[x][y-1] + dp[x-1][y] - dp[x-1][y-1] + matrix[x][y]
 * <p>
 * Solution 2
 * dp[x][y] := max size can achieve at (x,y) as bottom right
 * (x-dp[x][y], y-[x][y]) - (x,y) are all 1s
 * dp[x][y] =
 * 0, if matrix[x][y] == 0;
 * min(dp[x-1][y], dp[x][y-1], dp[x-1][y-1]) + 1, if matrix[x][y] == 1
 * O(n*n)
 */
public class MaximalSquare {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return 0;

        int m = matrix.length;
        int n = matrix[0].length;

        int[][] dp = new int[m][n];

        //top row
        for (int i = 0; i < m; i++) {
            dp[i][0] = Character.getNumericValue(matrix[i][0]);
        }

        //left column
        for (int j = 0; j < n; j++) {
            dp[0][j] = Character.getNumericValue(matrix[0][j]);
        }

        //cells inside
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == '1') {
                    int min = Math.min(dp[i - 1][j], dp[i - 1][j - 1]);
                    min = Math.min(min, dp[i][j - 1]);
                    dp[i][j] = min + 1;
                } else {
                    dp[i][j] = 0;
                }
            }
        }

        int max = 0;
        //get maximal length
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dp[i][j] > max) {
                    max = dp[i][j];
                }
            }
        }

        return max * max;
    }
}
