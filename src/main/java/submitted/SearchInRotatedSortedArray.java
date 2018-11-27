package submitted;

/**
 * https://leetcode.com/submissions/detail/191902090/
 * time : O(logn)
 * space : O(1)
 */
public class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        int start = 0;
        int end = nums.length - 1;
        while (start + 1 < end) {
            int mid = (end - start) / 2 + start;
            if (nums[mid] == target) return mid;
            if (nums[start] < nums[mid]) { // the first half is definitely increasing, use binary sarch
                if (nums[start] <= target && target <= nums[mid]) { // if target is in first half
                    end = mid;
                } else {
                    start = mid; // search for target in the second half
                }
            } else { // the second half is definitely increasing, use binary sarch
                if (nums[mid] <= target && target <= nums[end]) {
                    start = mid;
                } else {
                    end = mid;
                }
            }
        }
        if (nums[start] == target) return start;
        if (nums[end] == target) return end;
        return -1;
    }
}
