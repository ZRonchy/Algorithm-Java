package submitted;

/**
 * https://leetcode.com/submissions/detail/183260279/
 * Use recursion to deal with number bits
 */
public class IntegerToEnglishWords {
    public String numberToWords(int num) {
        if (num == 0) return "Zero";
        return helper(num, 0).trim();
    }

    public String helper(int num, int index) {
        String[] strs = {"Billion", "Million", "Thousand", "Hundred", "Ninety", "Eighty", "Seventy",
                "Sixty", "Fifty", "Forty", "Thirty", "Twenty", "Nineteen", "Eighteen",
                "Seventeen", "Sixteen", "Fifteen", "Fourteen", "Thirteen", "Twelve", "Eleven",
                "Ten", "Nine", "Eight", "Seven", "Six", "Five", "Four", "Three", "Two", "One"};
        int[] nums = {1000000000, 1000000, 1000, 100, 90, 80, 70, 60, 50, 40, 30, 20, 19, 18, 17,
                16, 15, 14, 13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1};

        StringBuilder build = new StringBuilder();

        for (int i = index; i < nums.length; i++) {
            if (num / nums[i] > 0) {
                if (num >= 100)
                    build.append(helper(num / nums[i], i + 1));
                build.append(strs[i]);
                build.append(" ");
                num = num % nums[i];
            }

        }

        return build.toString();
    }
}
