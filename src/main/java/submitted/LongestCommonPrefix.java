package submitted;

/**
 * https://leetcode.com/submissions/detail/192288185/
 * time : O(n);
 * space : O(1);
 */
public class LongestCommonPrefix {
    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        String res = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(res) != 0) { // str.indexOf("") = 0, "ab".indexOf("a") = 0
                res = res.substring(0, res.length() - 1);
            }
        }
        return res;
    }
}
