package submitted;

import java.util.TreeSet;

/**
 * https://leetcode.com/submissions/detail/207249510/
 * time O(2nk)
 * space O(n)
 */
public class KEmptySlots {
    public int kEmptySlots(int[] flowers, int k) {
        int n = flowers.length;
        if (n == 0 || k >= n) return -1;
        int[] f = new int[n + 1];

        for (int i = 0; i < n; ++i)
            if (IsValid(flowers[i], k, n, f))
                return i + 1;

        return -1;
    }

    private boolean IsValid(int x, int k, int n, int[] f) {
        f[x] = 1;
        if (x + k + 1 <= n && f[x + k + 1] == 1) {
            boolean valid = true;
            for (int i = 1; i <= k; ++i)
                if (f[x + i] == 1) {
                    valid = false;
                    break;
                }
            if (valid) return true;
        }
        if (x - k - 1 > 0 && f[x - k - 1] == 1) {
            for (int i = 1; i <= k; ++i)
                if (f[x - i] == 1) return false;
            return true;
        }
        return false;
    }

    // Use TreeSet
    public int kEmptySlots_TreeSet(int[] flowers, int k) {
        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int i = 0; i < flowers.length; i++) {
            int current = flowers[i];
            Integer next = treeSet.higher(current);
            if (next != null && next - current == k + 1) {
                return i + 1;
            }
            Integer pre = treeSet.lower(current);
            if (pre != null && current - pre == k + 1) {
                return i + 1;
            }
            treeSet.add(current);
        }
        return -1;
    }
}
