package submitted;

/**
 * 两个36进制的大整数以字符串的形式给出，求出两个大整数的和，并以字符串方式输出。
 * 比如：12346 + GSFTYHS = GSGW1LY
 */
public class BigIntegerSum {
    public static void main(String[] args) {
        System.out.println(sum("12346", "GSFTYHS"));
    }

    public static String sum(String num1, String num2) {
        String ascii = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        if (num1.length() > num2.length()) {
            StringBuilder sb = new StringBuilder(num2);
            for (int i = 0; i < num1.length() - num2.length(); i++) {
                sb.insert(0, '0');
            }
            num2 = sb.toString();
        }
        if (num1.length() < num2.length()) {
            StringBuilder sb = new StringBuilder(num1);
            for (int i = 0; i < num2.length() - num1.length(); i++) {
                sb.insert(0, '0');
            }
            num1 = sb.toString();
        }

        int add = 0;//进位
        StringBuilder sb = new StringBuilder();
        for (int i = num1.length() - 1; i >= 0; i--) {
            int n1 = ascii.indexOf(num1.charAt(i));
            int n2 = ascii.indexOf(num2.charAt(i));
            int sum = n1 + n2 + add;
            System.out.println(sum);
            sb.insert(0, ascii.charAt(sum % 36));
            add = sum / 36;
        }
        if (add != 0)
            sb.insert(0, add);
        return sb.toString();
    }
}
