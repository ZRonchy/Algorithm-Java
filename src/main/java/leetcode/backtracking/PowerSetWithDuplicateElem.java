package leetcode.backtracking;

import java.util.*;

public class PowerSetWithDuplicateElem {

   public static List<List<Integer>> subsetsWithDup(int[] nums){
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        Arrays.sort(nums);
        subsetsWithDup(nums, 0, new ArrayList<Integer>(), result);
        return result;
    }
    
    private static void subsetsWithDup(int[] nums, int start, List<Integer> temp, List<List<Integer>> result){
        result.add(new ArrayList<Integer>(temp));
        for(int i = start; i < nums.length; i++){
            if(i != start && nums[i] == nums[i-1]) continue;
            temp.add(nums[i]);
            subsetsWithDup(nums, i + 1, temp, result);
            temp.remove(temp.size() - 1);
        }
    }

    // main
    public static void main(String[] args) {
        int[] arr = {1,2,3};
        System.out.println(subsetsWithDup(arr));
    }
}
