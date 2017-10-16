package leetcode.bit;

// Get maximum binary Gap.
// For example, 9's binary form is 1001, the gap is 2.
// An integer x & 1 will get the last digit of the integer.
public class MaxBinaryGap {
    public static int getGap(int N) {
        int max = 0;
        int count = -1;
        int r = 0;

        while (N > 0) {
            // get right most bit & shift right
            r = N & 1;
            N = N >> 1;

            if (0 == r && count >= 0) {
                count++;
            }

            if (1 == r) {
                max = count > max ? count : max;
                count = 0;
            }
        }

        return max;
    }
}
