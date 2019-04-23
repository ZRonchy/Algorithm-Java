package submitted;

/**
 * https://leetcode.com/submissions/detail/190788637/
 */
public class EditDistance {
    public int minDistance(String word1, String word2) {
        if (word1 == null && word2 == null) {
            return 0;
        }
        if (word1 == null || word1.length() == 0) {
            return word2.length();
        }

        if (word2 == null || word2.length() == 0) {
            return word1.length();
        }

        int[][] dp = new int[word1.length()+1][word2.length()+1];

        for (int i=0;i<=word1.length(); i++) {
            dp[i][0] = i;
        }

        for (int j=0;j<=word2.length(); j++) {
            dp[0][j] = j;
        }

        for (int i=1;i<=word1.length(); i++) {
            for (int j=1; j<=word2.length(); j++) {
                if (word1.charAt(i-1) == word2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    dp[i][j] = 1 + min(
                            dp[i-1][j-1], // replace
                            dp[i][j-1],   // insert
                            dp[i-1][j]    // remove
                    );
                }
            }
        }
        return dp[word1.length()][word2.length()];

    }

    int min(int i, int j, int k) {
        // return Math.min(i, Math.min(j, k))
        int small = i;

        if (j < small) {
            small = j;
        }

        if (k < small) {
            small = k;
        }

        return small;
    }
}
