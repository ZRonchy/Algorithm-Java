package leetcode.matrix;

import java.util.HashSet;

/**
 * Write a program to solve a Sudoku puzzle by filling the empty cells.
 */
public class SudokuSolver {
    public void solveSudoku(char[][] board) {
        if (board==null||board.length==0)
            return;
        helper(board);
    }

    private boolean helper(char[][] board){
        for(int i=0; i<board.length; i++){
            for (int j=0; j<board[0].length; j++){
                if (board[i][j]=='.'){
                    for (char num='1'; num<='9'; num++){//尝试
                        if(isValid(board, i, j, num)){
                            board[i][j]=num;

                            if (helper(board))
                                return true;
                            else
                                board[i][j]='.';//回退
                        }
                    }
                    return false;
                }
            }
        }

        return true;
    }

    private boolean isValid(char[][] board, int i, int j, char c){
        // check column
        for (int row=0; row<9; row++)
            if (board[row][j] == c)
                return false;

        // check row
        for (int col=0; col<9; col++)
            if (board[i][col]==c)
                return false;

        // check block
        for(int row=i/3*3; row<i/3*3+3; row++)
            for (int col=j/3*3; col<j/3*3+3; col++)
                if (board[row][col]==c)
                    return false;

        return true;
    }
}
