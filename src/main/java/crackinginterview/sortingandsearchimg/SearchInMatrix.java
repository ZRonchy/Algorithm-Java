package crackinginterview.sortingandsearchimg;

/**
 * Given a matrix in which each row and
 * each column is sorted, write a method to find an element in it.
 * Assumptions:
 »»Rows are sorted left to right in ascending order. Columns are sorted top to bottom in ascending order.
 »»Matrix is of size MxN.
 */
public class SearchInMatrix {
    boolean FindElem(int[][] mat, int elem, int M, int N) {
        int row = 0;
        int col = N - 1;
        while (row < M && col >= 0) {
            if (mat[row][col] == elem) {
                return true;
            } else if (mat[row][col] > elem) {
                col--;
            } else {
                row++;
            }
        }
        return false;
    }
}
