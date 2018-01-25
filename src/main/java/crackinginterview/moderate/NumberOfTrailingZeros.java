package crackinginterview.moderate;

/**
 * Write an algorithm which computes the number of trailing zeros in n factorial.
 * Solutions: Suppose num = 26. In the first loop, we count how many multiples of five
 * there are by doing 26 / 5 = 5 (these multiples are 5, 10, 15, 20, and 25). In the next loop,
 * we count how many multiples of 25 there are: 26 / 25 = 1 (this multiple is 25). Thus,
 * we see that we get one zero from 5, 10, 15 and 20, and two zeros from 25
 * (note how it was counted twice in the loops). Therefore, 26!
 * No need to worry about 2 would be enough
 */
public class NumberOfTrailingZeros {
    public static int numZeros(int num) {
        int count = 0;
        if (num < 0) {
            System.out.println("Factorial is not defined for < 0");
            return 0;
        }
        for (int i = 5; num / i > 0; i *= 5) {
            count += num / i;
        }
        return count;
    }
}
