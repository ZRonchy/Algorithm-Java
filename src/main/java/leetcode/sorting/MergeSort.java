package leetcode.sorting;

import java.util.Arrays;
// time O(nlogn) space O(n)

/**
 * 思想：归并排序采用了分治算法，首先递归将原始数组划分为若干子数组，
 * 对每个子数组进行排序。然后将排好序的子数组递归合并成一个有序的数组。
 * 时间复杂度：最坏:O(nlog2n) 最好: O(nlog2n) 平均: O(nlog2n)
 * 空间复杂度：O(n)
 * 稳定性：稳定
 */
public class MergeSort {
    public static void mergeSort(int[] a, int n) {
        if (n < 2) {
            return;
        }
        int mid = n / 2;
        int[] l = new int[mid];
        int[] r = new int[n - mid];

        for (int i = 0; i < mid; i++) {
            l[i] = a[i];
        }
        for (int i = mid; i < n; i++) {
            r[i - mid] = a[i];
        }
        mergeSort(l, mid);
        mergeSort(r, n - mid);

        merge(a, l, r, mid, n - mid);
    }

    public static void merge(int[] a, int[] l, int[] r, int left, int right) {
        int i = 0, j = 0, k = 0;
        while (i < left && j < right) {
            if (l[i] <= r[j]) {
                a[k++] = l[i++];
            } else {
                a[k++] = r[j++];
            }
        }
        while (i < left) {
            a[k++] = l[i++];
        }
        while (j < right) {
            a[k++] = r[j++];
        }
    }

    public static void main(String[] args) {
        int[] arr = {5, 1, 6, 2, 3, 4};
        MergeSort.mergeSort(arr, arr.length);
        System.out.print(Arrays.toString(arr));
    }

}
