package submitted;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/submissions/detail/202311629/
 * 00 - 0
 * 01 - 1
 * 11 - 3
 * 10 - 2
 * G(i) = i ^ (i/2)
 * time : O(1 << n) / O(n)
 * space : O(1 << n) / O(n)
 */
public class GrayCode {
    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < 1 << n; i++) {
            res.add(i ^ i >> 1);
        }
        return res;
    }
}
