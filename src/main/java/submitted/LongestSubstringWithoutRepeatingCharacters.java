package submitted;

/**
 * https://leetcode.com/submissions/detail/190981657/
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        char[] map = new char[256];
        int left=0, right=0, max=0, count=0;

        while(right < s.length()) {
            //Found the different character
            if (map[s.charAt(right)] == 0) {
                map[s.charAt(right)]++;
                count++;
                max = Math.max(max, count);
                right++; // move window to right
            } else if (map[s.charAt(right)] >= 1) {
                // Move left pointer forward until find the char that is duplicate
                while (s.charAt(left) != s.charAt(right)) {
                    map[s.charAt(left)]--;
                    left++;
                    count--;
                }
                // Found the duplicate char, move left pointer and right pointer forward
                left++;
                max = Math.max(max, count);
                right++;
            }
        }
        return max;
    }
}
