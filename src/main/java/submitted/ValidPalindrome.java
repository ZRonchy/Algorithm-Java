package submitted;

/**
 * https://leetcode.com/submissions/detail/184862608/
 */
public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        if (s.isEmpty()) {
            return true;
        }
        int left = 0, right = s.length() - 1;
        char cHead, cTail;
        while (left <= right) {
            cHead = s.charAt(left);
            cTail = s.charAt(right);
            if (!Character.isLetterOrDigit(cHead)) {
                left++;
            } else if (!Character.isLetterOrDigit(cTail)) {
                right--;
            } else {
                if (Character.toLowerCase(cHead) != Character.toLowerCase(cTail)) {
                    return false;
                }
                left++;
                right--;
            }
        }

        return true;
    }
}
