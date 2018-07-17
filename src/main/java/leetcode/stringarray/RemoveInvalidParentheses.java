package leetcode.stringarray;

import java.util.*;

/**
 * Femove the minimum number of invalid parentheses in order to make the input
 * string valid. Return all possible results.
 * <p>
 * Note: The input string may contain letters other than the parentheses ( and ).
 * Examples:
 * "()())()" -> ["()()()", "(())()"]
 * "(a)())()" -> ["(a)()()", "(a())()"]
 * ")(" -> [""]
 */
public class RemoveInvalidParentheses {
    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<>();
        if (s == null) return res;
        Queue<String> q = new LinkedList<>();
        Set<String> visited = new HashSet<>(); // avoid duplicate results
        q.offer(s);
        visited.add(s);
        boolean foundValid = false;
        while (!q.isEmpty()) {
            String t = q.poll();
            if (isValid(t)) {
                res.add(t);
                foundValid = true;
            }
            // found valid, no need to remove anymore, just iterative the rest of q
            // and add to res when necessary
            if (foundValid)
                continue;
            for (int i = 0; i < t.length(); i++) {
                if (t.charAt(i) != '(' && t.charAt(i) != ')')
                    continue;
                String r = t.substring(0, i) + t.substring(i + 1);
                if (visited.contains(r)) continue;
                visited.add(r);
                q.offer(r);
            }
        }
        return res;
    }

    private boolean isValid(String s) {
        int count = 0; // stack variable
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') count++;
            if (s.charAt(i) == ')' && count-- == 0)
                return false;
        }
        return count == 0;
    }
}
