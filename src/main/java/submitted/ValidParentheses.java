package submitted;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * https://leetcode.com/submissions/detail/190574311/
 */
public class ValidParentheses {
    public boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i<s.length(); i++) {
            char ch = s.charAt(i);
            if (map.keySet().contains(ch)) {
                stack.push(ch);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char preChar = stack.pop();
                if (map.get(preChar) != ch) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}
