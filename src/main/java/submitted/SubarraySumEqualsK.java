package submitted;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/submissions/detail/186868795/
 * Prefix Sum: prefix_sum[i] = sum(nums[0:i-1]);
 * For every pair (i, j) check sum of nums[i:j] in O(1)
 * sum(nums[i:j]) = prefix_sum[j+1] - prefix_sum[i] (note this is for i = 0)
 * time O(n^2)
 * space O(n)
 */
public class SubarraySumEqualsK {
    /**
     * Prefix Sum: prefix_sum[i] = sum(nums[0:i-1]);
     * For every pair (i, j) check sum of nums[i:j] in O(1)
     * sum(nums[i:j]) = prefix_sum[j+1] - prefix_sum[i] (note this is for i = 0)
     * time O(n^2)
     * space O(n)
     */
    public int subarraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int[] prefixSum = new int[nums.length + 1];
        prefixSum[0] = 0;
        for (int i=0; i<nums.length; i++) {
            prefixSum[i+1] = prefixSum[i] + nums[i];
        }

        int count = 0;
        for (int i = 1; i <= nums.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (prefixSum[i] - prefixSum[j] == k) {
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * https://leetcode.com/submissions/detail/186869830/
     * Use a hashmap to store number of a prefix sum occurs so far,
     * Let sum = nums[0] + ... + nums[i]
     * Check how many prefix sums (j's) equals to sum-k
     * nums[0]+...+nums[j] = sum -k
     * then there are same number of j's that nums[j+1] + ... + nums[i] = k
     * time O(n)
     * space O(n)
     */
    public int subarraySum_improved(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1); // for prefix sum equals to k
        int sum = 0;
        int count = 0;
        for(int num : nums){
            sum += num;
            int target = sum - k;
            if(map.containsKey(target)) {
                count += map.get(target);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }

    //time O(n*n), space O(1)
    public int subarraySum_3(int[] nums, int k) {
        int count = 0;
        for (int start = 0; start < nums.length; start++) {
            int sum=0;
            for (int end = start; end < nums.length; end++) {
                sum+=nums[end];
                if (sum == k)
                    count++;
            }
        }
        return count;
    }
}
