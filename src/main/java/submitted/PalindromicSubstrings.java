package submitted;

/**
 * https://leetcode.com/submissions/detail/197611801/
 * time: O(n*n)
 */
public class PalindromicSubstrings {
    // space : O(n^2);
    public int countSubstrings(String s) {
        if (s == null || s.length() == 0) return 0;
        int res = 0;
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
                    res++;
                }
            }
        }
        return res;
    }

    int count = 0;

    // space : O(1)
    public int countSubstrings2(String s) {
        if (s == null || s.length() == 0) return 0;
        for (int i = 0; i < s.length(); i++) {
            helper(s, i, i);
            helper(s, i, i + 1);
        }
        return count;
    }

    public void helper(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            count++;
            left--;
            right++;
        }
    }
}
