package submitted;

import java.util.Set;

/**
 * https://leetcode.com/submissions/detail/191504624/
 * Backtracking
 */
public class WordSearch {
    public boolean exist(char[][] board, String word) {
        if (board.length == 0) {
            return false;
        }
        for (int i=0; i<board.length;i++) {
            for (int j=0; j<board[0].length; j++) {
                if (exists(board, i, j, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    boolean exists(char[][] board, int i, int j, String word, int start) {
        if (start >= word.length()) {
            return true;
        }
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) {
            return false;
        }
        if (board[i][j] == word.charAt(start)) {
            char c = board[i][j];
            board[i][j] = '#';
            boolean res = exists(board, i + 1, j, word, start+1) ||
                    exists(board, i - 1, j, word, start+1) ||
                    exists(board, i, j + 1, word, start+1) ||
                    exists(board, i, j - 1, word, start+1);
            board[i][j] = c;
            return res;
        }
        return false;
    }
}
