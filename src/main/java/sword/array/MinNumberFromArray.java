package sword.array;

import java.util.Arrays;

/**
 * 入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 */
public class MinNumberFromArray {
    public String printMinNumber(int [] numbers) {
        if (numbers == null || numbers.length == 0) {
            return "";
        }
        int n = numbers.length;
        String[] strs = new String[n];
        for (int i=0; i<n; i++) {
            // prevent from very large numbers
            strs[i] = String.valueOf(numbers[i]);
        }
        Arrays.sort(strs, (a, b) -> {
            String s1 = a + b;
            String s2 = b + a;
            return s1.compareTo(s2);
        });

        StringBuilder sb  = new StringBuilder();
        for (int i=0; i<n; i++) {
            sb.append(strs[i]);
        }
        return sb.toString();
    }
}
