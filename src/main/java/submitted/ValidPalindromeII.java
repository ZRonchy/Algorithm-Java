package submitted;

/**
 * https://leetcode.com/submissions/detail/184865751/
 */
public class ValidPalindromeII {
    public boolean validPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                if (isPalindrome(s, left + 1, right) || isPalindrome(s, left, right - 1)) {
                    return true;
                } else {
                    return false;
                }
            }
            left++;
            right--;
        }
        return true;
    }

    private boolean isPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            } else {
                i++;
                j--;
            }
        }
        return true;
    }
}
