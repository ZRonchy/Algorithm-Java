package submitted;

/**
 * https://leetcode.com/submissions/detail/185349083/
 * slow pointer will always point to the first 9 from left fast will keep moving
 * and when find a non zero value, swap nums[fast] with nums[slow] and slow++, fast++
 */
public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }

        int slow = 0;
        int fast = 0;

        while (fast < nums.length) {
            if (nums[fast] == 0) {
                fast++;
            } else {
                swap(nums, slow, fast);
                slow++;
                fast++;
            }
        }
    }

    void swap(int[] nums, int i, int j) {
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }
}
