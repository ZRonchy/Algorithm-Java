package leetcode.backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PowerSet {

    public static <T> Set<Set<T>> powerSet(Set<T> originalSet) {
        Set<Set<T>> sets = new HashSet<>();
        if (originalSet.isEmpty()) {
            sets.add(new HashSet<>());
            return sets;
        }
        List<T> list = new ArrayList<>(originalSet);
        T head = list.get(0);
        System.out.println("head is " + head);
        Set<T> rest = new HashSet<>(list.subList(1, list.size()));
        for (Set<T> set : powerSet(rest)) {
            Set<T> newSet = new HashSet<>();
            newSet.add(head);
            newSet.addAll(set);
            System.out.println("set is " + set);
            System.out.println("newSet is " + newSet);
            sets.add(newSet);
            sets.add(set);
            System.out.println("Sets " + sets);
        }
        System.out.println("End loop for head " + head);
        return sets;
    }

    //Simple backtracking
    public List<List<Integer>> subsets(int[] nums){
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        subsets(nums, 0, new ArrayList<Integer>(), result);
        return result;
    }
    
    private void subsets(int[] nums, int start, List<Integer> temp, List<List<Integer>> result){
        result.add(new ArrayList<Integer>(temp));
        for(int i = start; i < nums.length; i++){
            temp.add(nums[i]);
            subsets(nums, i + 1, temp, result);
            temp.remove(temp.size() - 1);
        }
    }
    
    // main
    public static void main(String[] args) {
        Set<Integer> mySet = new HashSet<>();
        mySet.add(1);
        mySet.add(2);
        mySet.add(3);
        for (Set<Integer> s : powerSet(mySet)) {
            System.out.println(s);
        }
    }
}
