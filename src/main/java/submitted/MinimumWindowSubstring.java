package submitted;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/submissions/detail/187440034/
 * Classic Sliding Window problem
 */
public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        if (s == null || t == null) {
            return "";
        }

        if (s.length() < t.length()) {
            return "";
        }

        Map<Character, Integer> wordDict = constructWordDict(t);
        int slow = 0;
        int minLength = Integer.MAX_VALUE;
        int matchCount = 0;
        int index = 0;

        for(int fast = 0; fast < s.length(); fast++) {
            char ch = s.charAt(fast);
            Integer count = wordDict.get(ch);
            if (count == null) {
                continue;
            }
            wordDict.put(ch, count - 1);
            // match another character
            if (count == 1) {
                // 1->0 means one character has been matched
                matchCount++;
            }
            // not t.length() to avoid duplicate characters "aa"
            while(matchCount == wordDict.size()) {
                // found a valid substring
                if (fast - slow + 1 < minLength) {
                    minLength = fast - slow + 1;
                    index = slow; // for current valid substring, keep track of start index
                }
                // keep removing the leftMost character to try to get the smallest valid substring
                char leftMost = s.charAt(slow);
                slow++;
                Integer leftMostCount = wordDict.get(leftMost);
                if (leftMostCount == null) {
                    continue; // not matched character, could continue
                }

                wordDict.put(leftMost, leftMostCount + 1);
                if (leftMostCount == 0) {
                    // 0 -> 1 current substring is not valid, break the while loop.
                    matchCount--;
                }
            }
        }

        return minLength == Integer.MAX_VALUE ? "" : s.substring(index, index + minLength);
    }

    private Map<Character, Integer> constructWordDict(String t) {
        Map<Character, Integer> map = new HashMap<>();
        for (char ch: t.toCharArray()) {
            Integer count = map.get(ch);
            if (count == null) {
                map.put(ch, 1);
            } else {
                map.put(ch, count+1);
            }
        }
        return map;
    }
}
