package leetcode.stringarray;

/**
 * Given a string S, you are allowed to convert it to a palindrome
 * by adding characters in front of it. Find and return the shortest
 * palindrome you can find by performing this transformation.
 * For example, given "aacecaaa", return "aaacecaaa"; given "abcd", return "dcbabcd".
 */
public class ShortestPalindrome {
    public String shortestPalindrome(String s) {
        if (s == null) {
            return "";
        }

        int length = s.length();
        String result = "";
        if (isPalindrome(s)) {
            return s;
        }

        for (int i = length / 2; i >= 1; i--) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                if ((result = scanFromCenter(s, i - 1, i)) != null)
                    return result;
            } else {
                if ((result = scanFromCenter(s, i - 1, i - 1)) != null)
                    return result;
            }
        }

        return result;

    }

    private String scanFromCenter(String s, int l, int r) {
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l -= 1;
            r += 1;
        }

        if (l >= 0) {
            return null;
        }

        StringBuilder sb = new StringBuilder(s.substring(r));
        sb.reverse();

        return sb.append(s).toString();
    }

    public boolean isPalindrome(String s) {
        int length = s.length();
        if (length == 0 || length == 1) {
            return true;
        }

        int left = 0;
        int right = length - 1;
        while (left < right) {
            if (s.charAt(left) == s.charAt(right)) {
                left += 1;
                right -= 1;
            } else {
                return false;
            }
        }
        return true;
    }
}