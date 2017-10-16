package leetcode.sorting;

import java.util.Arrays;

//  Worst case performance O(n^2)
//  Best case performance O(n)
//  Average case performance O(n^2)
//  Worst case space complexity O(1) auxiliary
public class BubbleSort {
    public static void main(String[] args) {
        int[] array = {1, 3, 6, 4, 5, 2};
        bubbleSort(array);
        System.out.print(Arrays.toString(array));

    }

    private static void bubbleSort(int[] array) {
        for (int i=0; i<array.length; i++) {
            for (int j=i+1; j<array.length; j++) {
                if (array[i] > array[j]) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }

    }

}