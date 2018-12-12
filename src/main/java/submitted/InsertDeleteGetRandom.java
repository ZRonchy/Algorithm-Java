package submitted;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

/**
 * https://leetcode.com/submissions/detail/194792889/
 * time : O(1);
 */
public class InsertDeleteGetRandom {
    HashMap<Integer, Integer> map;
    ArrayList<Integer> list;
    Random rmd;

    public InsertDeleteGetRandom() {
        map = new HashMap<>();
        list = new ArrayList<>();
        rmd = new Random();
    }

    /**
     * Inserts a value to the set. Returns true if the set did not already contain the specified element.
     */
    public boolean insert(int val) {
        if (map.containsKey(val)) return false;
        // Always insert the new value at the end of the list
        // so that when removing the value, we just remove the last value in O(1)
        map.put(val, list.size());
        list.add(val);
        return true;
    }

    /**
     * Removes a value from the set. Returns true if the set contained the specified element.
     */
    public boolean remove(int val) {
        if (!map.containsKey(val)) return false;

        int index = map.remove(val);
        int lastVal = list.remove(list.size() - 1);
        if (index != list.size()) {
            list.set(index, lastVal);
            map.put(lastVal, index);
        }
        return true;
    }

    /**
     * Get a random element from the set.
     */
    public int getRandom() {
        return list.get(rmd.nextInt(list.size()));
    }
}
