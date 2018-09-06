package leetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Given a set of candidate numbers (candidates) (without duplicates) and a
 * target number (target), find all unique combinations in candidates where
 * the candidate numbers sums to target.

 The same repeated number may be chosen from candidates unlimited number of times.

 Note:

 All numbers (including target) will be positive integers.
 The solution set must not contain duplicate combinations.
 Example 1:

 Input: candidates = [2,3,6,7], target = 7,
 A solution set is:
 [
 [7],
 [2,2,3]
 ]
 Example 2:

 Input: candidates = [2,3,5], target = 8,
 A solution set is:
 [
 [2,2,2,2],
 [2,3,3],
 [3,5]
 ]
 */
public class CombinationSum {
    /*Could use the same element*/
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        combinationSum(candidates, 0, target, result, new ArrayList<Integer>());
        return result;
    }

    private void combinationSum(int[] candidates, int start, int target,
                                List<List<Integer>> result, List<Integer> temp) {
        if(target == 0)
            result.add(new ArrayList<>(temp));
        else if(target < 0)
            return;
        else{
            for(int i = start; i < candidates.length; i++){
                temp.add(candidates[i]);
                combinationSum(candidates, i, target - candidates[i], result, temp);
                temp.remove(temp.size() - 1);
            }
        }
    }
    /*Could not use the same element*/
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        Arrays.sort(candidates);
        combinationSum2(candidates, 0, target, result, new ArrayList<Integer>());
        return result;
    }

    private void combinationSum2(int[] candidates, int start, int target,
                                 List<List<Integer>> result, List<Integer> temp) {
        if(target == 0)
            result.add(new ArrayList<>(temp));
        else if(target < 0)
            return;
        else{
            for(int i = start; i < candidates.length; i++){
                if(i != start && candidates[i] == candidates[i-1])
                    continue;
                temp.add(candidates[i]);
                combinationSum2(candidates, i + 1, target - candidates[i], result, temp);
                temp.remove(temp.size() - 1);
            }
        }
    }
}
