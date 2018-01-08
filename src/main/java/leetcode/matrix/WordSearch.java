package leetcode.matrix;

import java.util.Arrays;

/**
 * Given a 2D board and a word, find if the word exists in the grid.
 * The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.
 * For example, given board =

     [
     ["ABCE"],
     ["SFCS"],
     ["ADEE"]
     ]
     word = "ABCCED", -> returns true,
     word = "SEE", -> returns true,
     word = "ABCB", -> returns false.
 This problem can be solve by using a typical DFS method.
 * */
public class WordSearch {

    public static void main(String[] args) {
        char[][] grid = {
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}
        };

        System.out.println(exist(grid.clone(), "ABCCED"));
//        System.out.println(exist(grid.clone(), "SEE"));
//        System.out.println(exist(grid.clone(), "ABCB"));
    }

    public static boolean exist(char[][] grid, String word) {
        int rows = grid.length;
        int cols = grid[0].length;

        boolean result = false;
        for (int i=0; i<rows; i++) {
            for (int j=0; j<cols; j++) {
                if (dfs(grid, word, i, j, 0)) {
                    result = true;
                }
            }
        }

        return result;
    }

    private static boolean dfs(char[][] grid, String word, int i, int j, int k) {
        int rows = grid.length;
        int cols = grid[0].length;

        if (i<0 || j<0 || i>= rows || j>=cols) {
            return false;
        }

        if (grid[i][j] == word.charAt(k)) {
            char temp = grid[i][j];
            grid[i][j] = '#';
            if (k == word.length()-1) {
                return true;
            } else if(dfs(grid, word, i-1, j, k+1) ||
                    dfs(grid, word, i+1, j, k+1) ||
                    dfs(grid, word, i, j-1, k+1) ||
                    dfs(grid, word, i, j+1, k+1)) {
                return true;
            }
            grid[i][j] = temp;
        }

        return false;
    }

}
