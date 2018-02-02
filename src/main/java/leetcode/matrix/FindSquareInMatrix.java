package leetcode.matrix;

/**
 * Imagine you have a square matrix, where each cell is filled with either black or white.
 * Design an algorithm to find the maximum subsquare such that all four borders are filled with black pixels.
 *Assumption: Square is of size NxN.
 This algorithm does the following:
 1. Iterate through every (full) column from left to right.
 2. At each (full) column (call this currentColumn), look at the subcolumns (from biggest to smallest).
 3. At each subcolumn, see if you can form a square with the subcolumn as the left side.
    If so, update currentMaxSize and go to the next (full) column.
 4. If N - currentColumn <= currentMaxSize, then break completely. We’ve found the largest square possible.
    Why? At each column, we’re trying to create a square with that column as the left side.
    The largest such square we could possibly create is N - currentColumn. Thus,
    if N-currentColumn <= currentMaxSize, then we have no need to proceed.
 */
public class FindSquareInMatrix {
    public static Subsquare findSquare(int[][] matrix) {
        assert (matrix.length > 0);
        for (int row = 0; row < matrix.length; row++) {
            assert (matrix[row].length == matrix.length);
        }

        int N = matrix.length;

        int currentMaxSize = 0;
        Subsquare sq = null;
        int col = 0;

        // Iterate through each column from left to right
        while (N - col > currentMaxSize) { // See step 4 above
            for (int row = 0; row < matrix.length; row++) {
                // starting from the biggest
                int size = N - Math.max(row, col);
                while (size > currentMaxSize) {
                    if (isSquare(matrix, row, col, size)) {
                        currentMaxSize = size;
                        sq = new Subsquare(row, col, size);
                        break; // go to next (full) column
                    }
                    size--;
                }
            }
            col++;
        }
        return sq;
    }

    private static boolean isSquare(int[][] matrix, int row, int col, int size) {
        // Check top and bottom border.
        for (int j = 0; j < size; j++) {
            if (matrix[row][col + j] == 1) {
                return false;
            }
            if (matrix[row + size - 1][col + j] == 1) {
                return false;
            }
        }

        // Check left and right border.
        for (int i = 1; i < size - 1; i++) {
            if (matrix[row + i][col] == 1) {
                return false;
            }
            if (matrix[row + i][col + size - 1] == 1) {
                return false;
            }
        }
        return true;
    }
}


class Subsquare {
    public int row, column, size;

    public Subsquare(int r, int c, int sz) {
        row = r;
        column = c;
        size = sz;
    }
}
