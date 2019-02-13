package submitted;

/**
 * https://leetcode.com/submissions/detail/207513268/
 */
public class LongestSubstringWithAtMostTwoDistinctCharacters {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        char[] map = new char[256];
        int left=0, right=0, max=0, count=0;
        while(right < s.length()) {
            if (map[s.charAt(right)] == 0) {
                if (count < 2) {
                    count++;
                    max = Math.max(max, right-left+1);
                } else if (count == 2) {
                    while(map[s.charAt(left)] != 1) {
                        map[s.charAt(left)]--;
                        left++;
                    }
                    map[s.charAt(left)]--;
                    left++;
                }
                map[s.charAt(right)]++;
                max = Math.max(max, right-left+1);
                right++;
            } else {
                map[s.charAt(right)]++;
                max = Math.max(max, right-left+1);
                right++;
            }
        }

        return max;

    }
}
