package submitted;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/submissions/detail/192285387/
 * time : O(n)
 * space : O(1)
 */
public class RomanToInteger {
    public int romanToInt(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int result = map.get(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            int pre = map.get(s.charAt(i - 1));
            int cur = map.get(s.charAt(i));
            if (pre < cur) {
                result = result + cur - 2 * pre;
            } else {
                result = result + cur;
            }
        }
        return result;
    }
}
