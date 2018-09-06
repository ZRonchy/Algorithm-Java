package leetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Given a collection of distinct integers, return all possible permutations.

 Example:

 Input: [1,2,3]
 Output:
 [
 [1,2,3],
 [1,3,2],
 [2,1,3],
 [2,3,1],
 [3,1,2],
 [3,2,1]
 ]
 */
public class Permutation {
    /*No duplicates*/
    public List<List<Integer>> permute(int[] nums) {
        boolean[] used = new boolean[nums.length];
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        permute(nums, used, new ArrayList<Integer>(), result);
        return result;
    }

    private void permute(int[] nums, boolean[] used, List<Integer> temp, List<List<Integer>> result){
        if(temp.size() == nums.length)
            result.add(new ArrayList<>(temp));
        else{
            for(int i = 0; i < nums.length; i++){
                if(used[i]) continue;
                used[i] = true;
                temp.add(nums[i]);
                permute(nums, used, temp, result);
                temp.remove(temp.size() - 1);
                used[i] = false;
            }
        }
    }
    /*If contains duplicates*/
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        permuteUnique(nums, used, new ArrayList<Integer>(), result);
        return result;
    }

    private void permuteUnique(int[] nums, boolean[] used,
                               List<Integer> temp, List<List<Integer>> result){
        if(temp.size() == nums.length)
            result.add(new ArrayList<>(temp));
        else{
            for(int i = 0; i < nums.length; i++){
                if(used[i] || (i > 0 && nums[i] == nums[i-1] && !used[i-1]))
                    continue;
                used[i] = true;
                temp.add(nums[i]);
                permuteUnique(nums, used, temp, result);
                used[i] = false;
                temp.remove(temp.size() - 1);
            }
        }
    }
}
