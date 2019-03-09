package crackinginterview.arraysandstrings;

/**
 * Given an image represented by an NxN matrix, where each pixel in the image is 4 bytes,
 * write a method to rotate the image by 90 degrees. Can you do this in place?
 * https://leetcode.com/submissions/detail/201723365/
 */
public class RotateImage {
    public void rotate(int[][] matrix, int n) {
        for (int layer = 0; layer < n / 2; ++layer) {
            int first = layer;
            int last = n - 1 - layer;
            for (int i = first; i < last; ++i) {
                int offset = i - first;
                int top = matrix[first][i]; //save top
                //left -> top
                matrix[first][i] = matrix[last-offset][first];

                //bottom -> left
                matrix[last-offset][first] = matrix[last][last-offset];

                //right -> bottom
                matrix[last][last-offset] = matrix[i][last];

                //top -> right
                matrix[i][last] = top; // right <- saved top
            }
        }
    }

    //    The idea was firstly transpose the matrix and then flip it symmetrically. For instance,
    //        1  2  3
    //        4  5  6
    //        7  8  9
    //    after transpose, it will be swap(matrix[i][j], matrix[j][i])
    //
    //        1  4  7
    //        2  5  8
    //        3  6  9
    //    Then flip the matrix horizontally. (swap(matrix[i][j], matrix[i][matrix.length-1-j])
    //
    //        7  4  1
    //        8  5  2
    //        9  6  3
    public void rotate2(int[][] matrix) {
        for(int i = 0; i<matrix.length; i++){
            for(int j = i; j<matrix[0].length; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        for(int i =0 ; i<matrix.length; i++){
            for(int j = 0; j<matrix.length/2; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix.length-1-j];
                matrix[i][matrix.length-1-j] = temp;
            }
        }
    }
}
