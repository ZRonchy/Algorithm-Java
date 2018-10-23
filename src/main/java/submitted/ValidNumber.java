package submitted;

/**
 * https://leetcode.com/submissions/detail/184854060/
 * time O(n)
 * space O(1)
 */
public class ValidNumber {
    public boolean isNumber(String s) {
        s = s.trim();
        boolean numberSeen = false;
        boolean pointSeen = false;
        boolean eSeen = false;
        boolean numberAfterE = true;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) <= '9' && s.charAt(i) >= '0') {
                numberSeen = true;
                numberAfterE = true;
            } else if (s.charAt(i) == '.' && !pointSeen && !eSeen) {
                pointSeen = true;
            } else if (s.charAt(i) == 'e' && !eSeen && numberSeen) {
                eSeen = true;
                numberAfterE = false;
            } else if (s.charAt(i) == '+' || s.charAt(i) == '-') {
                if (i != 0 && s.charAt(i - 1) != 'e') { // 1e+12 is valid
                    return false;
                }
            } else {
                return false;
            }
        }
        return (numberSeen && numberAfterE);
    }
}
