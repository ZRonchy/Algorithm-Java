package leetcode.stringarray;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an integer array of size n, find all elements that appear more
 * than ⌊ n/3 ⌋ times. The algorithm should run in linear time and in O(1) space.
 *
 * Moore Voting algorithm: Find two different values and delete them, the elements left
 * could be the majority element (or not).
 */
public class MajorityElement2 {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> result = new ArrayList<>();

        Integer n1 = null, n2 = null;
        int c1 = 0, c2 = 0;

        for (int i : nums) {
            if (n1 != null && i == n1) {
                c1++;
            } else if (n2 != null && i == n2) {
                c2++;
            } else if (c1 == 0) {
                c1 = 1;
                n1 = i;
            } else if (c2 == 0) {
                c2 = 1;
                n2 = i;
            } else {
                // delete a three element tuple
                c1--;
                c2--;
            }
        }

        c1 = c2 = 0;

        for (int i : nums) {
            if (i == n1) {
                c1++;
            } else if (i == n2) {
                c2++;
            }
        }

        if (c1 > nums.length / 3)
            result.add(n1);
        if (c2 > nums.length / 3)
            result.add(n2);

        return result;
    }
}
