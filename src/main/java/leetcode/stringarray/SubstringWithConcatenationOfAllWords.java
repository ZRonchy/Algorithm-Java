package leetcode.stringarray;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * You are given a string, s, and a list of words, words, that are all of
 * the same length. Find all starting indices of substring(s) in s that is
 * a concatenation of each word in words exactly once and without any intervening characters.
 * For example, given: s="barfoothefoobarman" & words=["foo", "bar"], return [0,9].
 * 思路和Longest Substring Without Repeating Characters差不多。因为那些单词是定长的，所以本质上
 * 和单一个字符一样。和Longest Substring Without Repeating Characters的区别只在于我们需要维护一
 * 个字典，然后保证目前的串包含字典里面的单词有且仅有一次。思路仍然是维护一个窗口，如果当前单词
 * 在字典中，则继续移动窗口右端，否则窗口左端可以跳到字符串下一个单词了。
 */
public class SubstringWithConcatenationOfAllWords {
    public ArrayList<Integer> findSubstring(String S, String[] L) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        ArrayList<Integer> res = new ArrayList<Integer>();
        if (S == null || S.length() == 0 || L == null || L.length == 0)
            return res;
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for (int i = 0; i < L.length; i++) {
            if (map.containsKey(L[i])) {
                map.put(L[i], map.get(L[i]) + 1);
            } else {
                map.put(L[i], 1);
            }
        }
        for (int i = 0; i < L[0].length(); i++) {
            HashMap<String, Integer> curMap = new HashMap<String, Integer>();
            int count = 0;
            int left = i;
            for (int j = i; j <= S.length() - L[0].length(); j += L[0].length()) {
                String str = S.substring(j, j + L[0].length());

                if (map.containsKey(str)) {
                    if (curMap.containsKey(str))
                        curMap.put(str, curMap.get(str) + 1);
                    else
                        curMap.put(str, 1);
                    if (curMap.get(str) <= map.get(str))
                        count++;
                    else {
                        while (curMap.get(str) > map.get(str)) {
                            String temp = S.substring(left, left + L[0].length());
                            if (curMap.containsKey(temp)) {
                                curMap.put(temp, curMap.get(temp) - 1);
                                if (curMap.get(temp) < map.get(temp))
                                    count--;
                            }
                            left += L[0].length();
                        }
                    }
                    if (count == L.length) {
                        res.add(left);
                        //if(left<)
                        String temp = S.substring(left, left + L[0].length());
                        if (curMap.containsKey(temp))
                            curMap.put(temp, curMap.get(temp) - 1);
                        count--;
                        left += L[0].length();
                    }
                } else {
                    curMap.clear();
                    count = 0;
                    left = j + L[0].length();
                }
            }
        }
        return res;
    }

}
