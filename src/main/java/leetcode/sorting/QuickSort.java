package leetcode.sorting;

import java.util.Arrays;

/**
 * 思想：该算法是分治算法，首先选择一个基准元素,根据基准元素将待排序列分成两部分,
 * 一部分比基准元素小,一部分大于等于基准元素,此时基准元素在其排好序后的正确位置,然后
 * 再用同样的方法递归地排序划分的两部分。基准元素的选择对快速排序的性能影响很大，所有
 * 一般会想打乱排序数组选择第一个元素或则随机地从后面选择一个元素替换第一个元素作为基准元素。
 * 时间复杂度：最坏:O(n2) 最好: O(nlogn) 平均: O(nlogn)
 * 空间复杂度：O(nlogn)用于方法栈
 * 稳定性：不稳定 快排会将大于等于基准元素的关键词放在基准元素右边，加入数组 1 2 2 3 4 5
 * 选择第二个2 作为基准元素，那么排序后 第一个2跑到了后面，相对位置发生变化。
 */
public class QuickSort {
    public static void sort(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
    }

    public static void quickSort(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }
        int pivotIndex = partition(nums, start, end);
        quickSort(nums, start, pivotIndex - 1);
        quickSort(nums, pivotIndex + 1, end);
    }

    public static int partition(int[] nums, int start, int end) {
        int mid = start + (end - start) / 2;
        int pivot = nums[mid];
        while (start < end) {
            while (nums[start] < pivot) {
                start++;
            }
            while (nums[end] > pivot) {
                end--;
            }
            // swap
            swap(nums, start, end);
        }
        return start;
    }


    public static void swap(int[] array, int i, int j) {
        int t = array[i];
        array[i] = array[j];
        array[j] = t;
    }

    public static void main(String[] args) {
        int[] arr = {3, 2, 5, 6, 1, 4};
        QuickSort.sort(arr);
        System.out.print(Arrays.toString(arr));
    }
}
