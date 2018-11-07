package submitted;

import java.util.PriorityQueue;

/**
 * https://leetcode.com/submissions/detail/187952500/
 * Quick Select.
 */
public class FindKthLargest {
    // time : O(n) space : O(1)
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int left = 0;
        int right = nums.length - 1;
        while(true) {
            int pos = partition(nums, left, right);
            if (pos + 1 == k) {
                return nums[pos];
            } else if (pos + 1 > k) {
                right = pos - 1;
            } else {
                left = pos + 1;
            }
        }
    }

    private int partition(int[] nums, int left, int right) {
        int pivot = nums[left];
        int l = left + 1;
        int r = right;
        while(l <= r) {
            if (nums[l] < pivot && nums[r] > pivot) {
                swap(nums, l, r); // put larger number in left and smaller in right
                l++;
                r--;
            }
            if (nums[l] >= pivot) {
                l++;
            }

            if (nums[r] <= pivot) {
                r--;
            }
        }
        swap(nums, left, r); // put pivot to the middle while all left numbers are larger and all right numbers are smaller
        return r;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    /**
     * time : O(nlogk)
     * space : O(n)
     */
    public int findKthLargest2(int[] nums, int k) {
        if (nums == null || nums.length == 0) return 0;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int num : nums) {
            minHeap.offer(num);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        return minHeap.poll();
    }
}
