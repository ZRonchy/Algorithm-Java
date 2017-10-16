package leetcode.stringarray;
// Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0?
// Find all unique triplets in the array which gives the sum of zero.
// Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
// The solution set must not contain duplicate triplets. e.g.
// given array S = {-1 0 1 2 -1 -4}, a solution set is:
// (-1, 0, 1) and (-1, -1, 2)

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class ThreeSum2 {
    public static void main(String[] args) {
        int[] S = {-1, 0, 1, 2, -1, -4};
        Set<Triple>  set = threeSum(S);
        set.forEach(System.out::println);
    }

    private static Set<Triple> threeSum(int[] nums) {
        Set<Triple> result = new HashSet<>();
        if(nums==null || nums.length<3)
            return result;

        for(int i=0; i<nums.length; i++){
            int target = 0-nums[i];
            HashMap<Integer, Integer> map = new HashMap<>();
            for(int j=i+1;j<nums.length;j++) {
                if(map.containsKey(nums[j])){
                    Triple l = new Triple(nums[i], nums[j], map.get(nums[j]));
                    result.add(l);
                }else{
                    map.put(target-nums[j], nums[j]);
                }
            }
        }

        return result;
    }

}


class Triple {
    private int i,j,k;
    Triple(int i, int j, int k) {
        int[] array = {i, j, k};
        Arrays.sort(array);
        this.i=array[0];
        this.j=array[1];
        this.k=array[2];
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Triple triple = (Triple) o;

        return i == triple.i && j == triple.j && k == triple.k;

    }

    @Override
    public int hashCode() {
        int result = i;
        result = 31 * result + j;
        result = 31 * result + k;
        return result;
    }

    @Override
    public String toString() {
        return "("+i+","+j+","+k+")";
    }
}