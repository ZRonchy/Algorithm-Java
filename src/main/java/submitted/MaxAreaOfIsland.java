package submitted;

/**
 * https://leetcode.com/submissions/detail/194248237/
 * time : O(m * n)
 * space : O(n)
 */
public class MaxAreaOfIsland {
    int row;
    int col;

    public int maxAreaOfIsland(int[][] grid) {
        int res = 0;
        row = grid.length;
        if (row == 0) {
            return 0;
        }
        col = grid[0].length;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    res = Math.max(dfs(grid, i, j, 0), res);
                }
            }
        }
        return res;
    }

    int dfs(int[][] grid, int i, int j, int max) {
        if (i < 0 || j < 0 || i >= row || j >= col || grid[i][j] == 0) return 0;
        grid[i][j] = 0;
        max++;
        int right = dfs(grid, i, j + 1, 0);
        int left = dfs(grid, i, j - 1, 0);
        int up = dfs(grid, i + 1, j, 0);
        int down = dfs(grid, i - 1, j, 0);
        return right + left + up + down + max;
    }
}
