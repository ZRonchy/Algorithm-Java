package leetcode.stringarray;

/**
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * You are given a target value to search. If found in the array return its index,
 * otherwise return -1. You may assume no duplicate exists in the array.
 如果target比A[mid]值要小
 如果A[mid]右边有序（A[mid]<A[high])
 那么target肯定不在右边（target比右边的都得小），在左边找
 如果A[mid]左边有序
 那么比较target和A[low]，如果target比A[low]还要小，证明target不在这一区，去右边找；反之，左边找。
 如果target比A[mid]值要大
 如果A[mid]左边有序（A[mid]>A[low]）
 那么target肯定不在左边（target比左边的都得大），在右边找
 如果A[mid]右边有序
 那么比较target和A[high]，如果target比A[high]还要大，证明target不在这一区，去左边找；反之，右边找。
 */
public class SearchInSortedArray {
    public int search_recursive(int[] nums, int target) {
        return binarySearch(nums, 0, nums.length - 1, target);
    }

    public int binarySearch(int[] nums, int left, int right, int target) {
        if (left > right)
            return -1;

        int mid = left + (right - left) / 2;

        if (target == nums[mid])
            return mid;

        if (nums[left] <= nums[mid]) {
            if (nums[left] <= target && target < nums[mid]) {
                return binarySearch(nums, left, mid - 1, target);
            } else {
                return binarySearch(nums, mid + 1, right, target);
            }
        } else {
            if (nums[mid] < target && target <= nums[right]) {
                return binarySearch(nums, mid + 1, right, target);
            } else {
                return binarySearch(nums, left, mid - 1, target);
            }
        }
    }
}
