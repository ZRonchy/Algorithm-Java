package submitted;

/**
 * https://leetcode.com/submissions/detail/191144818/
 * 1. dynamic programming
 * 2. 中心扩散法
 */
public class LongestPalindromicSubstring {
    // time : O(n^2) space : O(n^2);
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) return s;
        String res = "";
        boolean[][] dp = new boolean[s.length()][s.length()];
        int max = 0;
        for (int j = 0; j < s.length(); j++) {
            for (int i = 0; i <= j; i++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (j - i <= 2) { // a, aa, aba
                        dp[i][j] = true;
                    } else { // abba, a*****a
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }

                if (dp[i][j]) {
                    if (j - i + 1 > max) {
                        max = j - i + 1;
                        res = s.substring(i, j + 1);
                    }
                }
            }
        }
        return res;
    }

    String res = "";
    // time : O(n^2) space : O(1)
    public String longestPalindrome2(String s) {
        if (s == null || s.length() == 0) return s;
        for (int i = 0; i < s.length(); i++) {
            helper(s, i, i); // aba
            helper(s, i, i + 1); // abba
        }
        return res;
    }
    public void helper(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        String cur = s.substring(left + 1, right);
        if (cur.length() > res.length()) {
            res = cur;
        }
    }
}
