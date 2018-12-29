package submitted;

/**
 * https://leetcode.com/submissions/detail/197803814/
 */
public class FindDuplicateNumber {
    // time : O(nlogn) space : O(1)
    public int findDuplicate(int[] nums) {
        int min = 0;
        int max = nums.length - 1;
        while (min <= max) {
            int mid = (max - min) / 2 + min;
            int count = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] <= mid) {
                    count++;
                }
            }
            if (count > mid) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        // Since the duplicate alaways exists, eventually this algorithm
        // will find the duplicate when min <= max not true any more
        return min;
    }

    // time : O(n) space : O(1)
    public int findDuplicate2(int[] nums) {
        int slow = nums[0];
        int fast = nums[nums[0]];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        // slow == fast now, need to find the index in the array
        fast = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}
