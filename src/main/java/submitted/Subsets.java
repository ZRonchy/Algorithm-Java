package submitted;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/submissions/detail/187482506/
 */
public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }

        helper(result, 0, new ArrayList<>(), nums);
        return result;
    }

    private void helper(List<List<Integer>> result, int start, ArrayList<Integer> list, int[] nums) {
        result.add(new ArrayList<>(list));

        for (int i=start; i<nums.length; i++) {
            list.add(nums[i]);
            helper(result, i+1, list, nums);
            list.remove(list.size() -1);
        }
    }
}
