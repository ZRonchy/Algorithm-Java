package submitted;

/**
 * https://leetcode.com/submissions/detail/195131068/
 * time O(n)
 * space O(n)
 */
public class FruitIntoBaskets {
    public int totalFruit(int[] tree) {
        int[] map = new int[tree.length];
        int left = 0;
        int right = 0;
        int count = 0;
        int max = 0;
        int localCount = 0;
        while (right < tree.length) {
            map[tree[right]]++;
            // A distinct number
            if (map[tree[right]] == 1) {
                count++;
            }

            while (count > 2) {
                map[tree[left]]--;
                localCount--;
                if (map[tree[left]] == 0) {
                    count--;
                }
                left++;
            }
            if (count <= 2) {
                localCount++;
                max = Math.max(localCount, max);
            }

            right++;
        }
        return max;
    }
}
