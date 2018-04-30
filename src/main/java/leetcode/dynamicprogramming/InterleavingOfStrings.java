package leetcode.dynamicprogramming;

/**
 * Given three strings A, B and C. Write a function that checks whether C
 * is an interleaving of A and B. C is said to be interleaving A and B, if
 * it contains all characters of A and B and order of all characters in individual
 * strings is preserved.
 */
public class InterleavingOfStrings {
    // A simple recursive function to check whether C is an interleaving of A and B
    static boolean isInterleaved(String A, String B, String C) {
        if (C.length() != A.length() + B.length()) {
            return false;
        }

        // Base Case: If all strings are empty
        if (A.equals("") && B.equals("") && C.equals("")) {
            return true;
        }

        // If C is empty and any of the two strings is not empty
        if (C.equals("") && (!A.equals("") || !B.equals(""))) {
            return false;
        }

        if (C.charAt(0) == A.charAt(0) && A.length() > 1) {
            return isInterleaved(A.substring(1, A.length()), B, C.substring(1, C.length()));
        } else if (C.charAt(0) == A.charAt(0) && A.length() == 1) {
            return true;
        }

        // If any of the above mentioned two possibilities is true,
        // then return true, otherwise false
        if (C.charAt(0) == B.charAt(0) && B.length() > 1) {
            return isInterleaved(A, B.substring(1, B.length()), C.substring(1, C.length()));
        } else if (C.charAt(0) == B.charAt(0) && B.length() == 1) {
            return true;
        }

        return false;
    }

    boolean isInterleaved_dp(char[] A, char[] B, char[] C) {
        // Find lengths of the two strings
        int M = A.length, N = B.length;

        // Let us create a 2D table to store solutions of
        // subproblems.  C[i][j] will be true if C[0..i+j-1]
        // is an interleaving of A[0..i-1] and B[0..j-1].
        boolean[][] IL = new boolean[M + 1][N + 1];

        // C can be an interleaving of A and B only of sum
        // of lengths of A & B is equal to length of C.
        if ((M + N) != C.length) {
            return false;
        }

        // Process all characters of A and B
        for (int i = 0; i <= M; ++i) {
            for (int j = 0; j <= N; ++j) {
                // two empty strings have an empty string
                // as interleaving
                if (i == 0 && j == 0)
                    IL[i][j] = true;

                    // A is empty
                else if (i == 0 && B[j - 1] == C[j - 1])
                    IL[i][j] = IL[i][j - 1];

                    // B is empty
                else if (j == 0 && A[i - 1] == C[i - 1])
                    IL[i][j] = IL[i - 1][j];

                    // Current character of C matches with current character of A,
                    // but doesn't match with current character of B
                else if (A[i - 1] == C[i + j - 1] && B[j - 1] != C[i + j - 1])
                    IL[i][j] = IL[i - 1][j];

                    // Current character of C matches with current character of B,
                    // but doesn't match with current character of A
                else if (A[i - 1] != C[i + j - 1] && B[j - 1] == C[i + j - 1])
                    IL[i][j] = IL[i][j - 1];

                    // Current character of C matches with that of both A and B
                else if (A[i - 1] == C[i + j - 1] && B[j - 1] == C[i + j - 1])
                    IL[i][j] = (IL[i - 1][j] || IL[i][j - 1]);
            }
        }

        return IL[M][N];
    }

    public static void main(String[] args) {
        System.out.println(isInterleaved("ace", "bd", "abcde"));
    }
}
