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
    public static void main(String[] args) {
        int[] x = {9, 2, 4, 7, 3, 7, 10};
        System.out.println(Arrays.toString(x));

        int low = 0;
        int high = x.length - 1;

        quickSort(x, low, high);
        System.out.println(Arrays.toString(x));
    }

    public static void quickSort(int[] arr, int low, int high) {
        if (arr == null || arr.length == 0)
            return;

        if (low >= high)
            return;

        // pick the pivot
        int middle = low + (high - low) / 2;
        int pivot = arr[middle];

        // make left < pivot and right > pivot
        int i = low, j = high;
        while (i <= j) {
            while (arr[i] < pivot) {
                i++;
            }

            while (arr[j] > pivot) {
                j--;
            }

            if (i <= j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }

        // recursively sort two sub parts
        if (low < j)
            quickSort(arr, low, j);

        if (high > i)
            quickSort(arr, i, high);
    }
}
