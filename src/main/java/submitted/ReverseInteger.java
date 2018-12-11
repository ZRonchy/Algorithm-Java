package submitted;

/**
 * https://leetcode.com/submissions/detail/194607194/
 * 32-bit signed integer range: [−231,  231 − 1]
 */
public class ReverseInteger {
    public int reverse(int x) {
        int sign = 1;
        if (x < 0) {
            sign = -1;
        }
        long res = 0;
        x = Math.abs(x); // Math.abs(Integer.MIN_VALUE) = Integer.MIN_VALUE = -2147483648
        while (x / 10 >= 1) {
            int remainder = x % 10;
            res = res * 10 + remainder;
            x = x / 10;
        }
        res = res * 10 + x;
        if (res > Integer.MAX_VALUE || -1 * res <= Integer.MIN_VALUE || res <= Integer.MIN_VALUE) {
            return 0;
        }
        return (int) res * sign;
    }
}
