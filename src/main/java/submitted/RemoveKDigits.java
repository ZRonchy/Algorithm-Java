package submitted;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/submissions/detail/194107806/
 * 1) If n == 0, then there is nothing to remove.
 * Append the whole 'str' to 'res' and return
 * 2) Let 'len' be length of 'str'. If 'len' is smaller or equal
 * to n, then everything can be removed
 * Append nothing to 'res' and return
 * 3) Find the smallest character among first (n+1) characters
 * of 'str'.  Let the index of smallest character be minIndex.
 * Append 'str[minIndex]' to 'res' and recur for substring after
 * minIndex and for n = n-minIndex
 */
public class RemoveKDigits {
    public String removeKdigits(String num, int k) {
        if (num == null || num.length() == 0 || k >= num.length()) {
            return "0";
        }
        int index = 0;
        Set<Integer> selected = new HashSet<>();
        StringBuilder res = new StringBuilder();
        int lastIndex = -1;
        while (index < num.length() - k) {
            int minIndex = findMinIndex(index, index + k, selected, num, lastIndex);
            res.append(num.charAt(minIndex) - '0');
            lastIndex = minIndex;
            index++;
        }
        return removeLeadingZero(res.toString());
    }

    int findMinIndex(int start, int end, Set<Integer> selected, String num, int lastIndex) {
        int minV = Integer.MAX_VALUE;
        int minI = start;
        for (int i = start; i <= end; i++) {
            if (selected.contains(i) || i <= lastIndex) {
                continue;
            }
            if (mapToNum(i, num) < minV) {
                minI = i;
                minV = mapToNum(i, num);
            }
        }
        selected.add(minI);
        return minI;
    }

    int mapToNum(int i, String num) {
        return num.charAt(i) - '0';
    }

    String removeLeadingZero(String s) {
        int zeroIndex = -1;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) - '0' != 0) {
                break;
            }
            zeroIndex = i;
        }
        if (zeroIndex == s.length() - 1) {
            return "0";
        }
        return s.substring(zeroIndex + 1);
    }
}
