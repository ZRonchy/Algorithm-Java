package leetcode.matrix;

/**
 * Given a dictionary, a method to do lookup in dictionary and a
 * M x N board where every cell has one character. Find all possible
 * words that can be formed by a sequence of adjacent characters.
 * Note that we can move to any of 8 adjacent characters, but a word
 * should not have multiple instances of same cell.
 * Input: dictionary[] = {"GEEKS", "FOR", "QUIZ", "GO"};
 * boggle[][]   = {{'G','I','Z'},
 * {'U','E','K'},
 * {'Q','S','E'}};
 * isWord(str): returns true if str is present in dictionary
 * else false.
 * <p>
 * Output:  Following words of dictionary are present
 * GEEKS
 * QUIZ
 */
public class FindAllPossibleWords {
    String[] dictionary = {"GEEKS", "FOR", "QUIZ", "GO"};
    int n = dictionary.length;

    boolean isWord(String str) {
        for (String string : dictionary) {
            if (str.equals(string)) {
                return true;
            }
        }

        return false;
    }

    //A recursive method to print all words present
    void findWordsUntil(char[][] matrix, boolean[][] visited, int i, int j, String str) {
        // Mark current cell as visited and append current character to str
        visited[i][j] = true;
        str = str + matrix[i][j];
        if (isWord(str)) {
            System.out.println(str);
        }

        // Traverse 8 adjacent cells of matrix[i][j]
        for (int row = i - 1; row <= i + 1 && row < matrix.length; row++) {
            for (int col = j - 1; col <= j + 1 && col < matrix[0].length; col++) {
                if (row > 0 && col > 0 && !visited[row][col]) {
                    findWordsUntil(matrix, visited, row, col, str);
                }
            }
        }
    }

    void findWords(char[][] matrix) {
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        String str = "";
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                findWordsUntil(matrix, visited, i, j, str);
            }
        }
    }

}
