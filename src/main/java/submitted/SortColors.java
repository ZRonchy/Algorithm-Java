package submitted;

/**
 * https://leetcode.com/submissions/detail/194226110/
 * time : O(n)
 * space : O(1)
 */
public class SortColors {
    public void sortColors(int[] nums) {
        if (nums == null || nums.length == 0) return;
        int left = 0; // keep the position of 0
        int right = nums.length - 1; // keep the position of 2
        int index = 0; // normal pointer to move ahead
        while (index <= right) {
            if (nums[index] == 0) {
                swap(nums, index++, left++); // Found 0, left move ahead
            } else if (nums[index] == 1) {
                index++; // Found 1, just pointer index move ahead
            } else {
                // Found 2, move 2 to the right, right--
                // Do not move index as we may still need to swap nums[index] with previous 0/1
                swap(nums, index, right--);
            }
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
