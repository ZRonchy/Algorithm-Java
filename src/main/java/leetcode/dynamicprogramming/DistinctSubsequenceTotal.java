package leetcode.dynamicprogramming;

/**
 * Given a string S and a string T, count the number of distinct subsequences of T in S.

 A subsequence of a string is a new string which is formed from the original string by
 deleting some (can be none) of the characters without disturbing the relative positions
 of the remaining characters. (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).
 Here is an example:
 S = "rabbbit", T = "rabbit"
 Return 3.
 When you see string problem that is about subsequence or matching, dynamic programming
 method should come to mind naturally. The key is to find the initial and changing condition.

 Input: S = "rabbbit", T = "rabbit"
 Output: 3
 Explanation:

 As shown below, there are 3 ways you can generate "rabbit" from S.
 (The caret symbol ^ means the chosen letters)

 rabbbit
 ^^^^ ^^
 rabbbit
 ^^ ^^^^
 rabbbit
 ^^^ ^^^
 */
public class DistinctSubsequenceTotal {
    //1、i为0时，dp[i][j] = 1，因为空串可以匹配任何字符串，包括空串。
    //2、j为0时，dp[i][j] = 0，此时i >= 1。
    //3、i和j都不为0时，如果T.charAt(i) == S.charAt(j)，那么dp[i][j] = dp[i][j-1] + dp[i-1][j-1]。
    // 否则dp[i][j] = dp[i][j-1]。
    public int findDistinctSubsequences(String S, String T) {
        int len1 = S.length();
        int len2 = T.length();
        if(len1 < len2){
            return 0;
        }
        int dp[][] = new int[len2+1][len1+1];
        for(int i = 0; i <= len2; i++){
            dp[i][0] = 0;
        }
        for(int j = 0; j <= len1; j++){
            dp[0][j] = 1;
        }
        for(int i = 1; i <= len2; i++){
            for(int j = 1; j <= len1; j++){
                if(T.charAt(i-1) == S.charAt(j-1)){
                    dp[i][j] = dp[i][j-1] + dp[i-1][j-1];
                }else{
                    dp[i][j] = dp[i][j-1];
                }
            }
        }
        return dp[len2][len1];
    }
}
