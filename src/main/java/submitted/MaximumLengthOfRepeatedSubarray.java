package submitted;

/**
 * https://leetcode.com/submissions/detail/186204605/
 * Classic dynamic programming task. Similar idea to Longest Common Substring.
 */
public class MaximumLengthOfRepeatedSubarray {
    public int findLength(int[] A, int[] B) {
        int[][] dp = new int[A.length+1][B.length+1];
        int result = 0;
        for (int i = 0; i<=A.length;i++) {
            for (int j =0; j<=B.length;j++) {
                if (i==0 || j==0) {
                    dp[i][j] = 0;
                } else if (A[i-1] == B[j-1]) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = 0;
                }
                result = Math.max(result, dp[i][j]);
            }
        }
        return result;
    }
}
