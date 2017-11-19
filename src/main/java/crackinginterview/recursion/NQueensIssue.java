package crackinginterview.recursion;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.
 * Given an integer n, return all distinct solutions to the n-queens puzzle.
 * Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.
 * For example,
 * There exist two distinct solutions to the 4-queens puzzle:
     [
     [".Q..",  // Solution 1
     "...Q",
     "Q...",
     "..Q."],
     ["..Q.",  // Solution 2
     "Q...",
     "...Q",
     ".Q.."]
     ]
 * Reference
     [1] https://segmentfault.com/a/1190000006121957
     [2] http://rleetcode.blogspot.co.uk/2014/02/leetcode-n-queens-puzzle-is-problem-of.html
 * */
public class NQueensIssue {
    public ArrayList<String[]> solveNQueens(int n) {
        ArrayList<String[]> result = new ArrayList<>();
        if (n<1){
            return result;
        }
        String[] rows = new String[n];
        int row = 0;
        solutions(row, n, rows, result);

        return result;
    }

    // DFS soluve question
    private void solutions(int stRow, int n, String[] rows, ArrayList<String[]> result){
        if (stRow >= n) {
            result.add(rows.clone());
            return;
        }

        for (int col=0; col<n; col++) {
            if (!isValid(col, stRow,  rows)){
                continue;
            }

            char[] chars = new char[n];
            Arrays.fill(chars, '.');
            chars[col]='Q';


            rows[stRow]=String.copyValueOf(chars);
            solutions(stRow+1, n, rows, result);

        }

    }

    // check if current col has conflict with previous Q
    private boolean isValid(int col,int stRow,  String[] rows){
        // checkColumn
        for (int i=0; i<stRow; i++){
            int qCol = rows[i].indexOf("Q");

            if (qCol == col){
                return false;
            }

            int rowDistance = Math.abs(stRow-i);
            int colDistance = Math.abs(col-qCol);

            if (rowDistance == colDistance){
                return false;
            }
        }

        return true;
    }
}
