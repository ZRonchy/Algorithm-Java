package submitted;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/submissions/detail/192472457/
 * time: O(n)
 * space: O(n)
 */
public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int max = 0;
        Set<Integer> set = new HashSet<>();
        for (int i=0; i<nums.length; i++) {
            set.add(nums[i]);
        }
        for (int i=0; i<nums.length; i++) {
            int up = nums[i];
            int count = 0;
            while(set.contains(up)) {
                set.remove(up);
                count++;
                up++;
            }
            int down = nums[i]-1;
            while(set.contains(down)) {
                set.remove(down);
                count++;
                down--;
            }
            max = Math.max(max, count);
        }

        return max;
    }
}
