package submitted;

/**
 * https://leetcode.com/submissions/detail/192287658/
 * time : O(n)
 * space : O(n)
 */
public class IntegerToRoman {
    public String intToRoman(int num) {
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] strs = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        String result = "";

        for (int i = 0; i < values.length; i++) {
            while (num >= values[i]) {
                num -= values[i];
                result += strs[i];
            }
        }
        return result;
    }
}
