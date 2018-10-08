package leetcode.matrix;

/**
 * Given a 2D matrix matrix, find the sum of the elements inside the rectangle
 * defined by its upper left corner (row1, col1) and lower right corner (row2, col2).
 * <p>
 * The above rectangle (with the red border) is defined by (row1, col1) = (2, 1) and
 * (row2, col2) = (4, 3), which contains sum = 8.
 * 样例：
 * <p>
 * Given matrix = [
 * [3, 0, 1, 4, 2],
 * [5, 6, 3, 2, 1],
 * [1, 2, 0, 1, 5],
 * [4, 1, 0, 1, 7],
 * [1, 0, 3, 0, 5]
 * ]
 * <p>
 * sumRegion(2, 1, 4, 3) -> 8
 * sumRegion(1, 1, 2, 2) -> 11
 * sumRegion(1, 2, 2, 4) -> 12
 * <p>
 * You may assume that the matrix does not change.
 * There are many calls to sumRegion function.
 * You may assume that row1 ≤ row2 and col1 ≤ col2.
 * <p>
 * Analysis
 * Since the assumption is that there are many calls to sumRegion method, we should use
 * some extra space to store the intermediate results.
 * dp[x][y] = dp[x][y-1] + dp[x-1][y] - dp[x-1][y-1] + matrix[x][y]
 */
public class RangeSumQuery {
    private int[][] sum;
    boolean hasNum = true;

    public RangeSumQuery(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            hasNum = false;
            return;
        }
        sum = new int[matrix.length + 1][matrix[0].length + 1];
        for (int i = 0; i < sum.length; i++) {
            sum[i][0] = 0;
        }
        for (int i = 1; i < sum[0].length; i++) {
            sum[0][i] = 0;
        }
        for (int i = 1; i < sum.length; i++) {
            for (int j = 1; j < sum[0].length; j++) {
                sum[i][j] = sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1] + matrix[i - 1][j - 1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        if (!hasNum) return 0;
        return sum[row2 + 1][col2 + 1] - sum[row2 + 1][col1] - sum[row1][col2 + 1] + sum[row1][col1];
    }
}
