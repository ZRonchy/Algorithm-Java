package submitted;

/**
 * https://leetcode.com/submissions/detail/183524936/
 * Typical DP but be careful with "0" character
 */
public class DecodeWays {
    public int numDecodings(String s) {
        if (s==null || s.length() == 0) {
            return 0;
        }

        int[] dp = new int[s.length()+1];
        dp[0] = 1; // To cover string like "10"

        if (Character.getNumericValue(s.charAt(0)) <=26 && Character.getNumericValue(s.charAt(0)) >= 1) {
            dp[1] = 1;
        } else {
            dp[1] = 0;
        }
        // "02" has no mapping
        if (s.charAt(0) == '0') {
            return 0;
        }

        for (int i=2; i<=s.length(); i++) {
            int bit = Character.getNumericValue(s.charAt(i-1));
            int preBit = Character.getNumericValue(s.charAt(i-2));
            int sum = preBit * 10 + bit;

            // Careful with "1200", no mapping
            if (preBit == 0) {
                if(bit > 26 || bit < 1) {
                    return 0;
                } else {
                    dp[i] = dp[i-1];
                }
            }

            // Careful with "102"
            if (bit == 0) {
                if(sum > 26 || sum < 1) {
                    return 0;
                } else {
                    dp[i] = dp[i-2];
                }
            }

            if (bit != 0 && preBit != 0) {
                if( sum <= 26 && sum >= 1) {
                    dp[i] = dp[i-1] + dp[i-2];
                } else {
                    dp[i] = dp[i-1];
                }
            }
        }

        return dp[s.length()];
    }
}
