package submitted;

import java.util.ArrayList;

/**
 * https://leetcode.com/submissions/detail/189999382/
 * Exactly the same as find anagrams in string
 */
public class PermutationInString {
    public boolean checkInclusion(String s1, String s2) {
        if (s1 == null || s2 == null) {
            return false;
        }

        int left = 0, right = 0, count = s1.length();
        int[] map = new int[256];

        // create map for pattern s1
        for (char ch: s1.toCharArray()) {
            map[ch]++;
        }

        while (right < s2.length()) {
            // Found one character in s1
            if (map[s2.charAt(right)] >= 1) {
                count--;
            }

            // move right pointer forward
            map[s2.charAt(right)]--;
            right++;

            // Found a permutation of s1
            if (count == 0) {
                return true;
            }

            // Ignore if length not match
            if (right - left != s1.length()) {
                continue;
            }

            // Length mathches, move left pointer forward
            if (right - left == s1.length()) {
                // if current left pointer character is a valid character in s1, increase rank as we will delete it
                if (map[s2.charAt(left)] >= 0) {
                    count++;
                }
                // move left pointer forward
                map[s2.charAt(left)]++;
                left++;
            }

        }

        return false;
    }
}
