package submitted;

/**
 * https://leetcode.com/submissions/detail/184622550/
 * boolean dp[i][j] means whether s[0-i] matches p[0-j]
 * dp[0][0] = true  s="" and p="" matches
 * 1. p.charAt(j) == s.charAt(i) : dp[i][j] = dp[i-1][j-1]
 * 2. if p.charAt(j) == '.' : dp[i][j] = dp[i-1][j-1]
 * 3. if p.charAt(j) == '*' :
 *     a. if p.charAt(j-1) != s.charAt(i), dp[i][j] = dp[i][j-2] // a* only counts as empty in this case
 *     b. if p.charAt(j-1) == s.charAt(i) or p.charAt(j-1) == '.':
 *       dp[i][j] = dp[i][j-1] // a* counts as single a
 *       dp[i][j] = dp[i-1][j] // a* counts as multiple a
 *       dp[i][j] = dp[i][j-2] // a* counts as empty
 *
 *  time O(m*n)
 *  space O(m*n)
 */
public class RegularExpressionMatching {
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return false;
        }

        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true; // just a base case

        for (int i = 0; i < p.length(); i++) {
            // * must follow a character, so won't be any IndexOutOfBound
            // For p = "a*" and a* counts as empty e.g. "aab" -> "c*aab"
            if (p.charAt(i) == '*' && dp[0][i - 1]) {
                dp[0][i+1] = true;
            }
        }

        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < p.length(); j++) {
                if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.') {
                    dp[i+1][j+1] = dp[i][j];
                } else if (p.charAt(j) == '*') {
                    if (s.charAt(i) != p.charAt(j - 1) && p.charAt(j - 1) != '.') {
                        dp[i+1][j+1] = dp[i+1][j - 1];
                    } else {
                        dp[i+1][j+1] = dp[i+1][j] || dp[i][j+1] || dp[i+1][j - 1];
                    }
                }
            }
        }

        return dp[s.length()][p.length()];
    }
}
