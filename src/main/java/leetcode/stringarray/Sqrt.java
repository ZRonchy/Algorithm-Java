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

    // 牛顿迭代法
    public double sqrt(double x) {
        if (x == 0) {
            return 0;
        }
        // first guess the sqrt is 1.0, then do res = (res + x / res) / 2; until res stops changing
        double last = 0.0;
        double res = 1.0;
        while (res != last) {
            last = res;
            res = (res + x / res) / 2;
        }
        return res;
    }

    public int sqrt(int x) {
        if (x == 0) {
            return 0;
        }
        double last = 0;
        double res = 1;
        while (res != last) {
            last = res;
            res = (res + x / res) / 2;
        }
        return new Double(res).intValue();
    }
}
