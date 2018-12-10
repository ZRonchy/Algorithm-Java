package submitted;
/**
 * https://leetcode.com/submissions/detail/194441444/
 * time : O(n)
 * space : O(1)
 */
public class StringToInteger {
    public int myAtoi(String str) {
        if (str == null) {
            return 0;
        }

        str = str.trim();
        if (str.length() == 0) {
            return 0;
        }
        long res = 0;
        int sign = 1;
        int start=0;
        if (str.charAt(start) == '-') {
            sign = -1;
            start++;
        } else if (str.charAt(start) == '+') {
            sign = 1;
            start++;
        }

        for (int i=start; i<str.length();i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return (int) res * sign;
            }
            res = 10* res + (str.charAt(i)-'0');
            if (sign == 1 && res > Integer.MAX_VALUE) return  Integer.MAX_VALUE;
            if (sign == -1 && res > Integer.MAX_VALUE) return Integer.MIN_VALUE;
        }
        return (int) res * sign;
    }
}
