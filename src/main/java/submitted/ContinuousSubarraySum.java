package submitted;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/submissions/detail/190301646/
 * 1. Element maybe zero
 * 2. Input could be empty
 * 3. K maybe zero or negative
 * ### Solution
 * 1. We store the prefix sum mod k rather than prefix sum. When two prefix sums with the same remainder appear,
 * we got our answer. Furthermore, if `nums.length > k` the answer is definitely true.
 */
public class ContinuousSubarraySum {
    public boolean checkSubarraySum_bruteForce(int[] nums, int k) {
        for (int i = 0; i < nums.length; i++) {
            int sum = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                sum += nums[j];
                if (sum == k) { // for k == 0
                    return true;
                }
                if (k != 0 && sum % k == 0) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean checkSubarraySum_prefixSum(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return false;
        }

        int[] prefixSum = new int[nums.length + 1];
        prefixSum[0] = 0;
        for (int i=0; i<nums.length; i++) {
            prefixSum[i+1] = prefixSum[i] + nums[i];
        }

        for (int i = 2; i <= nums.length; i++) {
            for (int j = i - 1; j > 0; j--) {
                if (prefixSum[i] == k) {
                    return true;
                }

                if (k != 0 && (prefixSum[i] - prefixSum[j]) % k == 0) {
                    return true;
                }
            }
        }

        return false;
    }

    // 若数字a和b分别除以数字c，若得到的余数相同，那么(a-b)必定能够整除c
    public boolean checkSubarraySum(int[] nums, int k) {
        // make sure k is positive; if k is zero, we won't do mod at all
        k = k == 0 ? Integer.MAX_VALUE : (k < 0 ? -k : k);
        if (nums.length > k) {
            // we have (k + 1) prefix sum but k remainder, there is at least two prefix with the same remainder
            return true;
        }
        Set<Integer> set = new HashSet<>();
        int last = 0; // the prefix sum one element earlier
        for (int num : nums) {
            int cur = (last + num) % k; // get newest prefix sum mod k
            if (set.contains(cur)) {
                return true;
            }
            set.add(last); // add old prefix sum into HashSet
            last = cur; // update old prefix sum
        }
        return false;
    }
}
