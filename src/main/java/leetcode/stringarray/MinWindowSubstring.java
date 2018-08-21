package leetcode.stringarray;

/**
 * Given a string S and a string T, find the minimum window in S which will
 * contain all the characters in T in complexity O(n).
 * For example, S = "ADOBECODEBANC", T = "ABC", Minimum window is "BANC".

 可以利用两个指针扫描（两个指针分别为start，i），以S = “e b a d b a c c b”（忽略空格），
 T = “abc”为例：
 1. 初始化 start = i = 0
 2. i 逐渐往后扫描S直到窗口S[start…i]包含所有T的字符，此时i = 6（字符c的位置）
 3. 缩减窗口：此时我们注意到窗口并不是最小的，需要调整 start 来缩减窗口。缩减
 规则为：如果S[start]不在T中 或者 S[start]在T中但是删除后窗口依然可以包含T
 中的所有字符，那么start = start+1， 直到不满足上述两个缩减规则。缩减后i即
 为窗口的起始位置，此例中从e开始窗口中要依次删掉e、b、a、d，start最后等于4 ，
 那么得到一个窗口大小为6-4+1 = 3
 4. start = start+1(此时窗口肯定不会包含所有的T中的字符)，跳转到步骤2继续寻找
 下一个窗口。本例中还以找到一个窗口start = 5，i = 8，比上个窗口大，因此最终的最小窗口是S[4…6]
 */
public class MinWindowSubstring {
    public String minWindow(String S, String T) {
        int[] srcHash = new int[256];
        for (int i = 0; i < T.length(); i++) {
            srcHash[T.charAt(i)]++;
        }
        int start = 0, i = 0;
        int[] destHash = new int[256];
        int found = 0;
        int begin = -1, end = S.length(), minLength = S.length();
        for (start = i = 0; i < S.length(); i++) {
            destHash[S.charAt(i)]++;
            // 加1后这个字符的数量不超过目标串中该字符的数量，则找到了一个匹配字符
            if (destHash[S.charAt(i)] <= srcHash[S.charAt(i)]) found++;
            // 找到的匹配字符数等于目标串长度，说明找到了一个符合要求的子串
            if (found == T.length()) {
                // 将开头没用的都跳过，没用是指该字符出现次数超过了目标串中出现的次数，
                // 并把它们出现次数都减1
                while (start < i && destHash[S.charAt(start)] > srcHash[S.charAt(start)]) {
                    destHash[S.charAt(start)]--;
                    start++;
                }
                // 这时候start指向该子串开头的字母，判断该子串长度
                if (i - start < minLength) {
                    minLength = i - start;
                    begin = start;
                    end = i;
                }
                // 把开头的这个匹配字符跳过，并将匹配字符数减1
                destHash[S.charAt(start)]--;
                found--;
                // 子串起始位置加1，开始看下一个子串了
                start++;
            }
        }

        return begin == -1 ? "" : S.substring(begin, end + 1);
    }
}
