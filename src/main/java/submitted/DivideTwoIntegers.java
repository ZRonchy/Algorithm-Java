package submitted;

/**
 * https://leetcode.com/submissions/detail/186655649/
 * Note in java, 32-bit signed integer range: [−2^31,  2^31 − 1] Integer.MAX_VALUE is 2^31 − 1
 * But when divide(−2^31, -1), the result is out of the range of Integer.MAX_VALUE, hence
 * we use long to store the result.
 * time O(logn)
 * space less than O(logn)
 */
public class DivideTwoIntegers {
    // divident / divisor
    public int divide (int divident, int divisor) {
        int sign = 1;
        if ((divident > 0 && divisor < 0) || (divident < 0 && divisor > 0)) {
            sign = -1;
        }

        long ldivident = Math.abs((long) divident);
        long ldivisor = Math.abs((long) divisor);

        if (ldivident < ldivisor || ldivident == 0) {
            return 0;
        }

        long lresult = divide(ldivident, ldivisor);
        int result = 0;
        if (lresult > Integer.MAX_VALUE) {
            result = (sign == 1) ? Integer.MAX_VALUE: Integer.MIN_VALUE;
        } else {
            result = (int)(sign * lresult);
        }

        return result;
    }

    public long divide(long ldivident, long ldivisor) {
        if (ldivident < ldivisor) {
            return 0;
        }

        long sum = ldivisor;
        long multiple = 1;
        while ((sum + sum) <= ldivident) {
            sum += sum;
            multiple += multiple;
        }

        return multiple + divide(ldivident - sum, ldivisor);
    }

}