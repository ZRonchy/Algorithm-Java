package leetcode.matrix;

/**
 * Given a n*n matrix where all numbers are distinct, find the maximum length path (starting from any cell)
 * such that all cells along the path are in increasing order with a difference of 1.
 * We can move in 4 directions from a given cell (i, j), i.e., we can move to (i+1, j) or (i, j+1) or (i-1, j)
 * or (i, j-1) with the condition that the adjacent cells have a difference of 1.
 * <p>
 * Example:
 * <p>
 * Input:  mat[][] = {{1, 2, 9}
 * {5, 3, 8}
 * {4, 6, 7}}
 * Output: 4
 * The longest path is 6-7-8-9.
 */
public class LongestPathInMatrix {
    public static int n = 3;

    // Function that returns length of the longest path
    // beginning with mat[i][j]
    // This function mainly uses lookup table dp[n][n]
    static int findLongestFromACell(int i, int j, int mat[][], int dp[][]) {
        // Base case
        if (i < 0 || i >= n || j < 0 || j >= n)
            return 0;

        // If this subproblem is already solved
        if (dp[i][j] != -1)
            return dp[i][j];

        // Since all numbers are unique and in range from 1 to n*n,
        // there is at most one possible direction from any cell
        if (j < n - 1 && ((mat[i][j] + 1) == mat[i][j + 1]))
            return dp[i][j] = 1 + findLongestFromACell(i, j + 1, mat, dp);

        if (j > 0 && (mat[i][j] + 1 == mat[i][j - 1]))
            return dp[i][j] = 1 + findLongestFromACell(i, j - 1, mat, dp);

        if (i > 0 && (mat[i][j] + 1 == mat[i - 1][j]))
            return dp[i][j] = 1 + findLongestFromACell(i - 1, j, mat, dp);

        if (i < n - 1 && (mat[i][j] + 1 == mat[i + 1][j]))
            return dp[i][j] = 1 + findLongestFromACell(i + 1, j, mat, dp);

        // If none of the adjacent fours is one greater
        return dp[i][j] = 1;
    }

    // Function that returns length of the longest path
    // beginning with any cell
    static int finLongestOverAll(int mat[][]) {
        // Initialize result
        int result = 1;

        // Create a lookup table and fill all entries in it as -1
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                dp[i][j] = -1;

        // Compute longest path beginning from all cells
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (dp[i][j] == -1)
                    findLongestFromACell(i, j, mat, dp);

                //  Update result if needed
                result = Math.max(result, dp[i][j]);
            }
        }

        return result;
    }

    // driver program
    public static void main(String[] args) {
        int mat[][] = {{1, 2, 9},
                {5, 3, 8},
                {4, 6, 7}};
        System.out.println("Length of the longest path is " +
                finLongestOverAll(mat));
    }
}

