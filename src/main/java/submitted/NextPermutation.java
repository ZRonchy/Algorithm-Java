package submitted;

/**
 * https://leetcode.com/submissions/detail/185327002/
 * 1 2 7 4 3 1
 * a. from the end of array, find the first index i that is smaller than its right, e.g. nums[1] = 2
 * b. from the end of array to i, find the first index j that is larger than nums[i] e.g. nums[4] = 3
 * c. swap nums[i] and nums[j] e.g. 1 3 7 4 2 1
 * d. reverse the following numbers after index i e.g. 1 3 1 2 4 7
 * Worst case time O(n)
 * Space O(1)
 */
public class NextPermutation {
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int firstSmall = -1;
        for (int i= nums.length-2; i>=0;i--) {
            if (nums[i] < nums[i+1]) {
                firstSmall = i;
                break;
            }
        }

        if (firstSmall == -1) {
            // already the largest number possible, reverse it
            reverse(nums, 0, nums.length-1);
            return;
        }

        int firstLarge = -1;
        for (int i=nums.length-1; i>firstSmall; i--) {
            if (nums[i] > nums[firstSmall]) {
                firstLarge = i;
                break;
            }
        }

        swap(nums, firstSmall, firstLarge);
        reverse(nums, firstSmall+1, nums.length-1);
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void reverse(int[] nums, int s, int e) {
        while (s < e) {
            swap(nums, s++, e--);
        }
    }
}
