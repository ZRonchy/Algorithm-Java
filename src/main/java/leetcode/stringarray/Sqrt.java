package leetcode.stringarray;

/**
 * https://leetcode.com/submissions/detail/197424849/
 * Binary Search
 * time : O(logn)
 * space : O(1)
 */
public class Sqrt {
    public int mySqrt(int x) {
        if (x <= 0) return 0;
        int low = 1, high = x;
        while (low <= high) {
            // if mid * mid > Integer.MAX_VALUE, have to cast it to long to compare with x
            long mid = (high - low) / 2 + low;
            if (mid * mid == x) {
                return (int) mid;
            } else if (mid * mid < x) {
                low = (int) mid + 1;
            } else {
                high = (int) mid - 1;
            }
        }
        if (high * high < x) {
            return (int) high;
        } else {
            return (int) low;
        }
    }
}
