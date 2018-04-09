package leetcode.dynamicprogramming;

/**
 * Given two sequences, find the length of longest subsequence present in both of them.
 * A subsequence is a sequence that appears in the same relative order, but not necessarily
 * contiguous. For example, “abc”, “abg”, “bdf”, “aeg”, ‘”acefg”, .. etc are subsequences of
 * “abcdefg”. So a string of length n has 2^n different possible subsequences.
 * Examples:
 * LCS for input Sequences “ABCDGH” and “AEDFHR” is “ADH” of length 3.
 * LCS for input Sequences “AGGTAB” and “GXTXAYB” is “GTAB” of length 4.
 * <p>
 * Solution:
 * 1) Consider the input strings “AGGTAB” and “GXTXAYB”. Last characters match for the strings.
 * So length of LCS can be written as:
 * L(“AGGTAB”, “GXTXAYB”) = 1 + L(“AGGTA”, “GXTXAY”)
 * 2) Consider the input strings “ABCDGH” and “AEDFHR. Last characters do not match for the strings.
 * So length of LCS can be written as:
 * L(“ABCDGH”, “AEDFHR”) = MAX ( L(“ABCDG”, “AEDFHR”), L(“ABCDGH”, “AEDFH”) )
 */
public class LongestCommonSubsequence {
    /* Returns length of LCS for X[0..m-1], Y[0..n-1] */
    int lcs_dps(char[] X, char[] Y, int m, int n) {
        if (m == 0 || n == 0)
            return 0;
        if (X[m - 1] == Y[n - 1])
            return 1 + lcs_dps(X, Y, m - 1, n - 1);
        else
            return max(lcs_dps(X, Y, m, n - 1), lcs_dps(X, Y, m - 1, n));
    }

    /* Returns length of LCS for X[0..m-1], Y[0..n-1] */
    int lcs_dp(char[] X, char[] Y, int m, int n) {
        int L[][] = new int[m + 1][n + 1];

    /* Following steps build L[m+1][n+1] in bottom up fashion. Note
         that L[i][j] contains length of LCS of X[0..i-1] and Y[0..j-1] */
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) {
                    L[i][j] = 0;
                } else if (X[i - 1] == Y[j - 1]) {
                    L[i][j] = L[i - 1][j - 1] + 1;
                } else {
                    L[i][j] = max(L[i - 1][j], L[i][j - 1]);
                }
            }
        }
        return L[m][n];
    }

    /* Utility function to get max of 2 integers */
    int max(int a, int b) {
        return (a > b) ? a : b;
    }

    public static void main(String[] args) {
        LongestCommonSubsequence lcs = new LongestCommonSubsequence();
        String s1 = "AGGTAB";
        String s2 = "GXTXAYB";

        char[] X = s1.toCharArray();
        char[] Y = s2.toCharArray();
        int m = X.length;
        int n = Y.length;

        System.out.println("Length of LCS is" + " " +
                lcs.lcs_dps(X, Y, m, n));
    }
}
