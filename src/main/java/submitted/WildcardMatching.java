package submitted;

/**
 * https://leetcode.com/submissions/detail/198502184/
 * boolean dp[i][j] means whether s[0-i] matches p[0-j]
 * dp[0][0] = true  s="" and p="" matches
 * 1. p.charAt(j) == s.charAt(i) : dp[i][j] = dp[i-1][j-1]
 * 2. if p.charAt(j) == '?' : dp[i][j] = dp[i-1][j-1]
 * 3. if p.charAt(j) == '*' :
 *     a. dp[i][j] = dp[i-1][j]
 *     b. dp[i][j] = dp[i][j-1] // * only counts as empty in this case
 *
 *  time O(m*n)
 *  space O(m*n)
 */
public class WildcardMatching {
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return false;
        }

        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true; // just a base case

        for (int i=1; i<=p.length(); i++) {
            // initialize for "*"
            if (p.charAt(i-1) == '*' && dp[0][i-1]) {
                dp[0][i] = true;
            }
        }

        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < p.length(); j++) {
                if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?') {
                    dp[i+1][j+1] = dp[i][j];
                } else if (p.charAt(j) == '*') {
                    // dp[i][j+1] is for "abc" and "a*", dp[i+1][j] is for "*" matches empty
                    dp[i+1][j+1] = dp[i][j+1] || dp[i+1][j];
                }
            }
        }

        return dp[s.length()][p.length()];
    }

    //    time : O(n)
    //    space : O(1)
    public boolean isMatch2(String s, String p) {
        int sp = 0;
        int pp = 0;
        int match = 0;
        int star = -1;
        while (sp < s.length()) {
            if (pp < p.length() && (s.charAt(sp) == p.charAt(pp) || p.charAt(pp) == '?')) {
                sp++;
                pp++;
            } else if (pp < p.length() && p.charAt(pp) == '*') {
                star = pp;
                match = sp;
                pp++;
            } else if (star != -1) {
                pp = star + 1;
                match++;
                sp = match;
            } else return false;
        }
        while (pp < p.length() && p.charAt(pp) == '*') {
            pp++;
        }
        return pp == p.length();
    }
}
