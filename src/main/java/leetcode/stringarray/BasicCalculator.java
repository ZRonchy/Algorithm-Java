package leetcode.stringarray;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Implement a basic calculator to evaluate a simple expression string.
 * <p>
 * The expression string may contain open ( and closing parentheses ), the
 * plus + or minus sign -, non-negative integers and empty spaces.You may
 * assume that the given expression is always valid.
 * Some examples: "1 + 1" = 2, "(1)" = 1, "(1-(4-5))" = 2
 *
 * This problem can be solved by using a stack. We keep pushing element to
 * the stack, when ')" is met, calculate the expression up to the first "(".
 */
public class BasicCalculator {
    public int calculate_recu(String s) {
        int res = 0, num = 0, sign = 1, n = s.length();
        for (int i = 0; i < n; ++i) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                num = 10 * num + (c - '0');
            } else if (c == '(') {
                int j = i, cnt = 0;
                for (; i < n; ++i) {
                    if (s.charAt(i) == '(') ++cnt;
                    if (s.charAt(i) == ')') --cnt;
                    if (cnt == 0) break;
                }
                num = calculate_recu(s.substring(j + 1, i - j - 1));
            }
            if (c == '+' || c == '-' || i == n - 1) {
                res += sign * num;
                num = 0;
                sign = (c == '+') ? 1 : -1;
            }
        }
        return res;
    }

    public int calculate_stack(String s) {
        int res = 0, num = 0, sign = 1, n = s.length();
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n; ++i) {
            char c = s.charAt(i);
            if (c >= '0') {
                num = 10 * num + (c - '0');
            } else if (c == '+' || c == '-') {
                res += sign * num;
                num = 0;
                sign = (c == '+') ? 1 : -1;
            } else if (c == '(') {
                st.push(res);
                st.push(sign);
                res = 0;
                sign = 1;
            } else if (c == ')') {
                res += sign * num;
                num = 0;
                res *= st.peek(); st.pop();
                res += st.peek(); st.pop();
            }
        }
        res += sign * num;
        return res;
    }
}
