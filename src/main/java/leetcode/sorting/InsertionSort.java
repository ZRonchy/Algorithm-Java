package leetcode.sorting;

import java.util.Arrays;

// Worst case performance О(n2) comparisons, swaps
// Best case performance O(n) comparisons, O(1) swaps
// Average case performance О(n2) comparisons, swaps
// Worst case space complexity О(n) total, O(1) auxiliary

/**
 * 思想：每次将一个待排序的数据按照其关键字的大小插入到前面已经排序好的数据中的适当位置，直到全部数据排序完成。
 * 时间复杂度：O(n2) O(n) O(n2) （最坏 最好 平均）
 * 空间复杂度：O(1)
 * 稳定性： 稳定 每次都是在前面已排好序的序列中找到适当的位置，只有小的数字会往前插入，所以原来相同的两个数字
 * 在排序后相对位置不变。
 */
public class InsertionSort {
    public static void main(String[] args) {
        int[] array = {1, 3, 6, 4, 5, 2};
        insertionSort(array);
        System.out.print(Arrays.toString(array));

    }

    private static void insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            if (array[i - 1] > array[i]) {
                int temp = array[i]; //insert array[i] into the front/start [0, i-1]
                int j = i;
                while (j > 0 && array[j - 1] > temp) {
                    array[j] = array[j - 1]; // move the previous array towards right
                    j--;
                }
                array[j] = temp;
            }
        }
    }

}