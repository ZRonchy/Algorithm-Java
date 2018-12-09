package leetcode.sorting;

import java.util.Arrays;

//  Worst case performance O(n^2)
//  Best case performance O(n)
//  Average case performance O(n^2)
//  Worst case space complexity O(1) auxiliary
public class BubbleSort {
    public static void main(String[] args) {
        int[] array = {1, 3, 6, 4, 5, 2};
        bubbleSort_improve(array);
        System.out.print(Arrays.toString(array));

    }

    private static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            // every run we will put the largest number at the end,
            // no need to compare it in the next run
            for (int j = 1; j < arr.length - i; j++) {
                if (arr[j - 1] > arr[j]) {
                    //swap elements
                    int temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    private static void bubbleSort_improve(int array[]) {
        boolean swapped;
        for (int i = 0; i < array.length; i++) {
            swapped = false;
            for (int j = 1; j < array.length - i; j++) {
                if (array[j-1] > array[j]) {
                    // swap arr[j-1] and arr[j]
                    int temp = array[j-1];
                    array[j-1] = array[j];
                    array[j] = temp;
                    swapped = true;
                }
            }

            // If no two elements were swapped by inner loop, then break
            if (!swapped) {
                break;
            }
        }
    }

}