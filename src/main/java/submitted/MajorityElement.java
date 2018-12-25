package submitted;

import java.util.Arrays;

/**
 * https://leetcode.com/submissions/detail/196982888/
 */
public class MajorityElement {
    // time : O(nlogn) space : O(1)
    public int majorityElement1(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    // Moore voting algorithm
    // 每次都找出一对不同的元素，从数组中删掉，直到数组为空或只有一种元素。
    // 不难证明，如果存在元素e出现频率超过半数，那么数组中最后剩下的就只有e。
    // [1,2,3,3,3]
    // time : O(n) space : O(1)
    public int majorityElement2(int[] nums) {
        int count = 0;
        int res = 0;
        for (int num : nums) {
            if (count == 0) {
                res = num;
            }
            if (num != res) {
                count--;
            } else {
                count++;
            }
        }
        return res;
    }

}
