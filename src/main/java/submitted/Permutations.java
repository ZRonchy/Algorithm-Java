package submitted;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/submissions/detail/187473979/
 * time O(n! * n)
 * space O(n)
 */
public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }

        List<List<Integer>> result = new ArrayList<>();
        helper(result, new ArrayList<>(), nums);
        return result;
    }

    void helper(List<List<Integer>> result, List<Integer> list, int[] nums) {
        if (list.size() == nums.length) {
            result.add(new ArrayList<>(list)); // note new ArrayList<>(list) here
            return;
        }

        for (int i=0; i<nums.length; i++) {
           if (list.contains(nums[i])) { //time is O(n) so the whole time is O(n!*n)
               continue;
           }

           list.add(nums[i]);
           helper(result, list, nums);
           list.remove(list.size()-1);
        }
    }

    /**
     * list.contains(nums[i]) is O(n), we could skip this check and make the whole time O(n!)
     */
    public List<List<Integer>> permute2(int[] nums) {
        List<List<Integer>> allList = new ArrayList<>();
        helper2(nums, 0, new ArrayList<>(), allList);
        return allList;
    }

    public void helper2(int[] nums, int from, List<Integer> cur, List<List<Integer>> allList) {
        if(cur.size() == nums.length) {
            allList.add(new ArrayList<Integer>(cur));
            return;
        }
        for(int i = from; i < nums.length; ++i) {
            swap(nums, from, i);
            cur.add(nums[from]);
            helper2(nums, from+1, cur, allList);
            cur.remove(cur.size()-1);
            swap(nums, from, i);
        }
    }
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


}
