package submitted;

/**
 * https://leetcode.com/submissions/detail/197420373/
 */
public class CountAndSay {
    public String countAndSay(int n) {
        if (n == 0) {
            return null;
        }

        int level = 1;
        String res = "1";

        while(level < n) {
            char cur = res.charAt(0);
            int count = 1;
            if (res.length()==1) {
                res = "11";
                level++;
                continue;
            }
            StringBuilder sb = new StringBuilder();
            for (int i=1; i<res.length();i++) {
                char next = res.charAt(i);
                if(next == cur) {
                    count++;
                } else {
                    sb.append(""+count+cur);
                    cur = next;
                    count=1;
                }

                if (i == res.length()-1) {
                    sb.append(""+count+cur);
                }
            }
            res = "".equals(sb.toString()) ? res : sb.toString();

            level++;
        }
        return res;
    }
}
