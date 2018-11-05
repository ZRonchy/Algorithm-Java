package submitted;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/submissions/detail/187496955/
 */
public class PalindromePartition {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return result;
        }

        helper(result, new ArrayList<>(), s);

        return result;
    }

    void helper(List<List<String>> result, List<String> list, String s) {
        if (s.length() == 0) {
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i=1; i<=s.length();i++) {
            String tempString = s.substring(0, i);
            if (!isPalindrome(tempString)) {
                continue;
            }
            list.add(tempString);
            helper(result, list, s.substring(i));
            list.remove(list.size()-1);
        }
    }

    boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length()-1;

        while(left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
}
