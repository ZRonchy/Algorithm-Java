package submitted;

import java.util.Stack;

/**
 * https://leetcode.com/submissions/detail/210635176/
 * time : O(n)
 * space : O(n)
 */
public class LongestAbsoluteFilePath {
    public int lengthLongestPath(String input) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0); // "dummy" length
        int res = 0;
        for (String s : input.split("\n")) {
            int level = s.lastIndexOf("\t") + 1; // number of "\t"
            while (level + 1 < stack.size()) { // find parent
                stack.pop();
            }
            // remove "/t", add "/", stack.peek() is the parent dir length
            int len = stack.peek() + s.length() - level + 1;
            stack.push(len);
            if (s.contains(".")) {
                res = Math.max(res, len - 1);
            }
        }
        return res;
    }
}
