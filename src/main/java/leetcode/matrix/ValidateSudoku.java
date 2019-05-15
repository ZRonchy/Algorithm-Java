package leetcode.matrix;

import java.util.HashSet;
import java.util.Set;

/**
 * Check if a sudoku is valid
 * 每一行，每一列以及每一个3x3宫都没有重复的数字出现
 */
public class ValidateSudoku {
    private Set<Character> visited = new HashSet<>();

    public boolean isValidSudoku(char[][] board) {
        //row
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (!check(board[i][j])) return false;
            }
            visited.clear();
        }
        //column
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (!check(board[j][i])) return false;
            }
            visited.clear();
        }
        //sub matrix
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (!check(board[i / 3 * 3 + j / 3][i % 3 * 3 + j % 3])) {
                    return false;
                }
            }
            visited.clear();
        }
        return true;
    }

    public boolean check(char c) {
        if (c == '.') {
            return true;
        } else if (c >= '1' && c <= '9') {
            if (visited.contains(c)) {
                return false;
            } else {
                visited.add(c);
                return true;
            }
        } else {
            return false;
        }
    }
}
