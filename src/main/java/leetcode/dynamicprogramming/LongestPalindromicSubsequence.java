package leetcode.dynamicprogramming;

/**
 * Given a string s, find the longest palindromic subsequence's length in s. You may assume that the maximum length of s is 1000.
 * <p>
 * Example 1:
 * Input:
 * <p>
 * "bbbab"
 * Output:
 * 4
 * One possible longest palindromic subsequence is "bbbb".
 * Example 2:
 * Input:
 * <p>
 * "cbbd"
 * Output:
 * 2
 * One possible longest palindromic subsequence is "bb".
 */
public class LongestPalindromicSubsequence {
    // lps("ABBASYA", 0, 6)
    static int lps(String seq, int i, int j) {
        // Base Case 1: If there is only 1 character
        if (i == j)
            return 1;

        // Base Case 2: If there are only 2 characters and both are same
        if (seq.charAt(i) == seq.charAt(j) && i + 1 == j)
            return 2;

        // If the first and last characters match
        if (seq.charAt(i) == seq.charAt(j))
            return lps(seq, i + 1, j - 1) + 2;

        // If the first and last characters do not match
        return Math.max(lps(seq, i, j - 1), lps(seq, i + 1, j));
    }

    static int lps_dp(String seq) {
        int n = seq.length();
        int i, j, cl;
        int L[][] = new int[n][n];  // Create a table to store results of subproblems

        // Strings of length 1 are palindrome of lentgh 1
        for (i = 0; i < n; i++)
            L[i][i] = 1;

        // Build the table. Note that the lower diagonal values of table are
        // useless and not filled in the process. The values are filled in a
        // manner similar to Matrix Chain Multiplication DP solution (See
        // https://www.geeksforgeeks.org/archives/15553). cl is length of
        // substring
        for (cl = 2; cl <= n; cl++) {
            for (i = 0; i < n - cl + 1; i++) {
                j = i + cl - 1;
                if (seq.charAt(i) == seq.charAt(j) && cl == 2)
                    L[i][j] = 2;
                else if (seq.charAt(i) == seq.charAt(j))
                    L[i][j] = L[i + 1][j - 1] + 2;
                else
                    L[i][j] = Math.max(L[i][j - 1], L[i + 1][j]);
            }
        }

        return L[0][n - 1];
    }

    public static void main(String[] args) {
        System.out.println(lps("ABBCSYA", 0, 6));
        System.out.println(lps_dp("ABBCSYA"));
    }

}
