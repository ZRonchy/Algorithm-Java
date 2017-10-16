package leetcode.stringarray;//Find the kth largest element in an unsorted array.
// Note that it is the kth largest element in the sorted order,
// not the kth distinct element. For example, given [3,2,1,5,6,4] and k = 2, return 5.
// Note: You may assume k is always valid, 1 ≤ k ≤ array's length.

import java.util.Arrays;
import java.util.PriorityQueue;

import org.junit.Assert;

public class KthLargestElement {
    public static void main(String[] args) {
        HeapSorting heapSorting = new HeapSorting();
        Assert.assertEquals(5, heapSorting.findKthLargest(new int[]{1, 2, 3, 4, 5, 6}, 2));
    }

}

//Solution 1
class Sorting {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length-k];
    }
}

//Solution 2
class QuickSort {
    public int findKthLargest(int[] nums, int k) {
        if (k < 1 || nums == null) {
            return 0;
        }

        return getKth(nums.length - k +1, nums, 0, nums.length - 1);
    }

    public int getKth(int k, int[] nums, int start, int end) {

        int pivot = nums[end];

        int left = start;
        int right = end;

        while (true) {

            while (nums[left] < pivot && left < right) {
                left++;
            }

            while (nums[right] >= pivot && right > left) {
                right--;
            }

            if (left == right) {
                break;
            }

            swap(nums, left, right);
        }

        swap(nums, left, end);

        if (k == left + 1) {
            return pivot;
        } else if (k < left + 1) {
            return getKth(k, nums, start, left - 1);
        } else {
            return getKth(k, nums, left + 1, end);
        }
    }

    public void swap(int[] nums, int n1, int n2) {
        int tmp = nums[n1];
        nums[n1] = nums[n2];
        nums[n2] = tmp;
    }
}

//Solution 3
class HeapSorting {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<>(k);
        for(int i: nums){
            q.offer(i);

            if(q.size()>k){
                q.poll();
            }
        }

//        for (Integer i : q) {
//          System.out.println(i);
//        }

        return q.peek();
    }
}