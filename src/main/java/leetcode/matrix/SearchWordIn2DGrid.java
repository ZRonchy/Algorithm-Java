package leetcode.matrix;
/**
 * Given a 2D grid of characters and a word, find all occurrences of given word in grid. A word can be matched in all 8 directions at any point. Word is said be found in a direction if all characters match in this direction (not in zig-zag form).
 * The 8 directions are, Horizontally Left, Horizontally Right, Vertically Up and 4 Diagonal directions.
 * Example:
     Input:  grid[][] = {"GEEKSFORGEEKS",
     "GEEKSQUIZGEEK",
     "IDEQAPRACTICE"};
     word = "GEEKS"

     Output: pattern found at 0, 0
     pattern found at 0, 8
     pattern found at 1, 0

     Input:  grid[][] = {"GEEKSFORGEEKS",
     "GEEKSQUIZGEEK",
     "IDEQAPRACTICE"};
     word = "EEE"

     Output: pattern found at 0, 2
     pattern found at 0, 10
     pattern found at 2, 2
     pattern found at 2, 12

 Solution: The idea used here is simple, we check every cell.
 If cell has first character, then we one by one try all 8 directions from that cell for a match.
 * */
public class SearchWordIn2DGrid {

    // Rows and columns in given grid
    static int R = 3;
    static int C = 13;

    // For searching in all 8 directions
    static int x[] = { -1, -1, -1, 0, 0, 1, 1, 1 };
    static int y[] = { -1, 0, 1, -1, 1, -1, 0, 1 };

    public static void main(String[] args) {
        char[][] grid = {
                {'G','E','E','K','S','F','O','R','G','E','E','K','S'},
                {'G','E','E','K','S','Q','U','I','Z','G','E','E','K'},
                {'I','D','E','Q','A','P','R','A','C','T','I','C','E'}
        };

        patternSearch(grid, "GEEKS");
        System.out.println();
        patternSearch(grid, "EEE");
    }

    // This function searches in all 8-direction from point(row, col) in grid[][]
    public static boolean search2D(char grid[][], int row, int col, String word) {
        int rows = grid.length;
        int cols = grid[0].length;

        // If first character of word doesn't match with
        // given starting point in grid.
        if (grid[row][col] != word.charAt(0)) {
            return false;
        }

        int len = word.length();
        // Search word in all 8 directions starting from (row,col)
        for (int dir = 0; dir < 8; dir++) {
            // Initialize starting point for current direction
            int k, rd = row + x[dir], cd = col + y[dir];
            // First character is already checked, match remaining
            // characters
            for (k = 1; k < len; k++) {
                // If out of bound break
                if (rd >= R || rd < 0 || cd >= C || cd < 0) {
                    break;
                }

                // If not matched,  break
                if (grid[rd][cd] != word.charAt(k)) {
                    break;
                }

                //  Moving in particular direction
                rd += x[dir];
                cd += y[dir];
            }
            // If all character matched, then value of must
            // be equal to length of word
            if (k == len) {
                return true;
            }
        }

        return false;
    }

    //  Searches given word in a given matrix in all 8 directions
    public static void patternSearch(char grid[][], String word) {
        // Consider every point as starting point and search given word
        for (int row = 0; row < R; row++) {
            for (int col = 0; col < C; col++) {
                if (search2D(grid, row, col, word)) {
                    System.out.println( "pattern found at (" +row + ","+col+")");
                }
            }
        }
    }
}
