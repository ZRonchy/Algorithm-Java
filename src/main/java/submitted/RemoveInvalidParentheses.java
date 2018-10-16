package submitted;

import java.util.*;

/**
 * https://leetcode.com/submissions/detail/183038919/
 * BFS to find the shortest remove. Note how to check if it's valid.
 */
public class RemoveInvalidParentheses {
    public List<String> removeInvalidParentheses(String s) {
        List<String> result = new ArrayList<>();
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        if (s == null) {
            return result;
        }

        queue.add(s);
        visited.add(s);
        while(!s.isEmpty()) {
            String test = queue.poll();

            if (isValid(test)) {
                result.add(test);
                break;
            }

            for (int i=0;i<test.length();i++) {
                if (test.charAt(i) != '(' && test.charAt(i) != ')') continue;
                String next = test.substring(0, i) + test.substring(i+1);
                if (!visited.contains(next)) {
                    queue.add(next);
                    visited.add(next);
                }
            }
        }

        while(!queue.isEmpty()) {
            String prepared = queue.poll();
            if(isValid(prepared)) {
                result.add(prepared);
            }
        }


        return result;
    }


    boolean isValid(String s) {
        int count = 0;
        for (int i=0; i<s.length(); i++) {
            if(s.charAt(i) == '(') {
                count++;
            }

            if(s.charAt(i) == ')') {
                if (count==0) {
                    return false;
                }

                count--;
            }
        }

        return count==0;
    }
}
