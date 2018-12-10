package submitted;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/submissions/detail/188377327/
 */
public class FindAllAnagramsInAString {
    public List<Integer> findAnagrams(String s, String p) {
        ArrayList<Integer> result = new ArrayList<>();
        if (s == null || p == null) return result;
        int left = 0, right = 0, count = p.length();
        int[] map = new int[256];
        char[] sc = s.toCharArray();
        for (char c : p.toCharArray()) {
            map[c]++;
        }
        while (right < s.length()) {
            if (map[sc[right]] >= 1) {
                // Found a valid character
                count--;
            }

            // everytime we move right pointer forward
            map[sc[right]]--;
            right++;

            if (count == 0) {
                // Found an anagram
                result.add(left);
            }

            if (right - left != p.length()) {
                // Won't have any anagram as length not match
                continue;
            }

            // Current length of substring has been evaluated, move left pointer forward
            if (right - left == p.length()) {
                if (map[sc[left]] >= 0) {
                    // if current left character is a valid character, rank should add 1 as we miss it
                    count++;
                }

                //Start to move left pointer forward
                map[sc[left]]++;
                left++;
            }
        }
        return result;
    }

    //Sliding Window template
    public List<Integer> template(String s, String p) {
        ArrayList<Integer> result = new ArrayList<>();
        if (s == null || p == null) return result;
        int left = 0, right = 0, count = p.length();

        int[] map = new int[256];
        char[] sc = s.toCharArray();
        //初始化map
        for (char c : p.toCharArray()) {
            map[c]++;
        }
        while (right < s.length()) {
            //1：扩展窗口，窗口中包含一个T中子元素，rank--；
            //2：通过count或其他限定值，得到一个可能解。
            //3：只要窗口中有可能解，那么缩小窗口直到不包含可能解。
        }
        return result;
    }
}
