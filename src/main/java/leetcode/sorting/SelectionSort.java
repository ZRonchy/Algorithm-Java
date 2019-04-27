package leetcode.sorting;

import java.util.Arrays;

// Worst case performance О(n2)
// Best case performance О(n2)
// Average case performance О(n2)
// Worst case space complexity О(n) total, O(1) auxiliary

/**
 * 思想：首先在未排序序列中找到最小（大）元素，存放到排序序列的起始位置，
 * 然后每次从剩余未排序元素中继续寻找最小（大）元素放到已排序序列的末尾。以此类推，直到所有元素均排序完毕
 * 时间复杂度：最坏:O(n2) 最好: O(n2) 平均: O(n2)
 * 空间复杂度：O(1)
 * 稳定性：不稳定 例如数组 2 2 1 3 第一次选择的时候把第一个2与1交换使得两个2的相对次序发生了改变。
 */
public class SelectionSort {
    public static void main(String[] args) {
        int[] array = {1, 3, 6, 4, 5, 2};
        selectionSort(array);
        System.out.print(Arrays.toString(array));

    }

    // Everytime find the smallest number and put at the start of the array
    private static void selectionSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int index = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[index]) {
                    index = j;
                }
            }
            int smallerNumber = array[index];
            array[index] = array[i];
            array[i] = smallerNumber;
        }
    }

}