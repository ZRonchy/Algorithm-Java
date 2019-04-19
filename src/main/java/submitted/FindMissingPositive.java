package submitted;

/**
 * https://leetcode.com/submissions/detail/210369917/
 * time : O(n)
 * space : O(1)
 */
public class FindMissingPositive {
    public static void main(String[] args) {

    }
    public int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 1;
        }
        for (int i = 0; i < nums.length; i++) {
            // everytime we put one number at the correct position, so O(n) in total
            while (nums[i] > 0 && nums[i] <= nums.length && nums[nums[i] - 1] != nums[i]) {
                // nums[i] - 1 is where nums[i] should be put, if the number at index nums[i]-1 is not nums[i],
                // swap nums[i] to the correct position nums[i]-1, bucket sort idea
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return nums.length + 1;
    }
}
