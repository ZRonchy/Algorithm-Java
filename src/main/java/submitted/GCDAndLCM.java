package submitted;

/**
 * Use Euclid's algorithm to find the greatest common divisor of two numbers;
 * Least common multiple can be found by the approach "reduction by the GCD"
 */
public class GCDAndLCM {
    // find gcd of two numbers
    private static long gcd(long a, long b) {
        while (b > 0) {
            long temp = b;
            b = a % b; // % is remainder
            a = temp;
        }
        return a;
    }

    // find gcd of two numbers using recursion
    public static int gcd_recur(int a, int b) {
        if (b==0) {
            return a;
        }
        return gcd_recur(b,a%b);
    }

    // find gcd of a list of numbers
    private static long gcd(long[] input) {
        long result = input[0];
        for (int i = 1; i < input.length; i++) {
            result = gcd(result, input[i]);
        }
        return result;
    }

    // find lcm of two numbers
    private static long lcm(long a, long b) {
        return a * (b / gcd(a, b));
    }

    // find lcm of a list of numbers
    private static long lcm(long[] input) {
        long result = input[0];
        for (int i = 1; i < input.length; i++) {
            result = lcm(result, input[i]);
        }
        return result;
    }
}
