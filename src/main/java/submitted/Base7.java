package submitted;

/**
 * https://leetcode.com/submissions/detail/200405675/
 */
public class Base7 {
    public String convertToBase7(int num) {
        if (num == 0) {
            return "0";
        }

        boolean sign = true;
        if (num < 0) {
            sign = false;
        }

        StringBuilder sb = new StringBuilder();
        while(num != 0) {
            sb.append(Math.abs(num%7));
            num = num / 7;
        }

        if (!sign) {
            sb.append("-");
        }

        return sb.reverse().toString();
    }

    public String convertToBase72(int num) {
        if (num < 0) {
            return "-" + convertToBase72(-num);
        }
        if (num < 7) {
            return num + "";
        }
        return convertToBase72(num / 7) + num % 7;
    }
}
