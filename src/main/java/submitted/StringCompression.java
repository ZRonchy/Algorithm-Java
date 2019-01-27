package submitted;

/**
 * https://leetcode.com/submissions/detail/204097546/
 * time : O(n)
 * space : O(1)
 */
public class StringCompression {
    public int compress(char[] chars) {
        int res = 0, index = 0;
        while (index < chars.length) {
            char cur = chars[index];
            int count = 0;
            while (index < chars.length && chars[index] == cur) {
                index++;
                count++;
            }
            chars[res++] = cur;
            if (count != 1) {
                for (char c : String.valueOf(count).toCharArray()) {
                    chars[res++] = c;
                }
            }
        }
        return res;
    }
}
