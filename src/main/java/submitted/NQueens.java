package submitted;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/submissions/detail/197600891/
 */
public class NQueens {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        if (n <= 0) {
            return res;
        }

        helper(res, new int[n], 0);
        return res;
    }

    // queens is the column of each queen in every row
    // row is the row to place queens
    private void helper(List<List<String>> res, int[] queens, int row) {
        if (row == queens.length) {
            addSolution(res, queens);
            return;
        }

        for (int i = 0; i < queens.length; i++) {
            queens[row] = i;
            if (isValid(queens, row)) {
                helper(res, queens, row + 1);
            }
        }
    }

    public boolean isValid(int[] queens, int row) {
        for (int i = 0; i < row; i++) {
            if (queens[i] == queens[row]) { // 同一列
                return false;
            } else if (Math.abs(queens[row] - queens[i]) == Math.abs(i - row)) { //是否在对角线上
                return false;
            }
        }
        return true;
    }

    public void addSolution(List<List<String>> res, int[] queens) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < queens.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < queens.length; j++) {
                if (queens[i] == j) {
                    sb.append('Q');
                } else {
                    sb.append('.');
                }
            }
            list.add(sb.toString());
        }
        res.add(list);
    }
}
