package leetcode.greedyalgorithm;

/**
 * Given a string which consists of lowercase or uppercase letters, find the length
 * of the longest palindromes that can be built with those letters.
 * <p>
 * This is case sensitive, for example "Aa" is not considered a palindrome here.
 * <p>
 * Note:
 * Assume the length of given string will not exceed 1,010.
 * <p>
 * Example:
 * Input:
 * "abccccdd"
 * <p>
 * Output:
 * 7
 * <p>
 * Explanation:
 * One longest palindrome that can be built is "dccaccd", whose length is 7.
 * <p>
 * 1. Count the frequency of each character
 * 2. Build from center, pick a pair (same char), put one at the front and one
 * at the end
 * 3. If there is a single char left, put it in the middle
 */
public class LongestPalindrome {
    public int longestPalindrome(String s) {
        boolean[] map = new boolean[128];
        int len = 0;
        for (char c : s.toCharArray()) {
            map[c] = !map[c];         // flip on each occurrence, false when seen n*2 times
            if (!map[c]) len+=2;
        }
        if (len < s.length()) len++; // if more than len, atleast one single is present
        return len;
    }

    public int longestPalindrome2(String s) {
        int[] cnt = new int[58];
        int max = 0;
        int len = 0;
        for (int i = 0; i < s.length(); i++) {
            cnt[s.charAt(i) - 'A']++;
        }
        for (int i = 0; i < 58; i++) {
            if (cnt[i] % 2 == 0) len += cnt[i];
            else {
                if (cnt[i] > max) {
                    len += max - 1;
                    max = cnt[i];
                } else len = len + cnt[i] - 1;
            }
        }
        return max == 0 ? len : len + max + 1;
    }
}