package leetcode.stringarray;
// Given a string containing just the characters '(' and ')',
// find the length of the longest valid (well-formed) parentheses substring.
// For "(()", the longest valid parentheses substring is "()", which has length = 2.
// Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4.
// https://leetcode.com/submissions/detail/212120378/

import java.util.Stack;

public class LongestValidParentheses {
    public static void main(String[] args) {
        System.out.println(longestValidParentheses("))()())"));
    }

    public static int longestValidParentheses(String s) {
        Stack<int[]> stack = new Stack<int[]>();
        int result = 0;

        for (int i = 0; i <= s.length() - 1; i++) {
            char c = s.charAt(i);
            if (c == '(') {
                int[] a = {i, 0}; // 0 to respresnt ( and 1 to represent )
                stack.push(a);
            } else {
                if (stack.empty() || stack.peek()[1] == 1) {
                    int[] a = {i, 1};
                    stack.push(a);
                } else {
                    stack.pop(); // Found a valid pair ()
                    int currentLen = 0;
                    if (stack.empty()) { // all previous substring is valid
                        currentLen = i + 1;
                    } else {
                        // or the substring from current i to previous invalid index stack.peek()[0] is valid
                        currentLen = i - stack.peek()[0];
                    }
                    result = Math.max(result, currentLen);
                }
            }
        }

        return result;
    }

}
