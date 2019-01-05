package submitted;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/submissions/detail/199261211/
 * Reference: https://www.youtube.com/watch?v=v05R1OIIg08
 * time: O(n * 4^(n-1)): n-1 spaces with 4 possibilities ('+', '-', '*', ' '), evaluation of value needs O(n)
 * space: O(n)
 */
public class ExpressionAddOperators {
    public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<>();
        if (num == null || num.length() == 0) return res;
        helper(res, "", num, target, 0, 0, 0);
        return res;
    }

    /**
     * @param res result to return
     * @param path the whole expression
     * @param num original string
     * @param target target number to match
     * @param pos position of current processing digit in original string
     * @param val value of the current expression
     * @param pre value of the previous digit/node
     */
    private void helper(List<String> res, String path, String num, int target, int pos, long val, long pre) {
        if (pos == num.length()) {
            if (target == val) {
                res.add(path);
                return;
            }
        }
        for (int i = pos; i < num.length(); i++) {
            // "105" -> "05" is the same as 5 and not valid as a new number, so break directly
            if (i != pos && num.charAt(pos) == '0') break;
            long cur = Long.parseLong(num.substring(pos, i + 1)); // operator is " " between two digits
            if (pos == 0) {
                helper(res, path + cur, num, target, i + 1, cur, cur);
            } else {
                helper(res, path + "+" + cur, num, target, i + 1, val + cur, cur);
                helper(res, path + "-" + cur, num, target, i + 1, val - cur, -cur);
                helper(res, path + "*" + cur, num, target, i + 1, val - pre + pre * cur, pre * cur);
            }
        }
    }
}
