package submitted;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/submissions/detail/187493503/
 * time O(2^n)
 * space O(n)
 */
public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (candidates == null || candidates.length == 0) {
            return result;
        }

        helper(result, new ArrayList<>(), candidates, target, 0);
        return result;
    }

    void helper(List<List<Integer>> result, List<Integer> list, int[] candidates, int target, int start) {
        if (target < 0) {
            return;
        }

        if (target == 0) {
            result.add(new ArrayList<>(list));
        }

        for (int i=start; i<candidates.length;i++) {
            list.add(candidates[i]);
            helper(result, list, candidates, target-candidates[i], i);
            list.remove(list.size()-1);
        }
    }
}
