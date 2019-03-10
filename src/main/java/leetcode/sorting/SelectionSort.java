package leetcode.sorting;

import java.util.Arrays;

// Worst case performance О(n2)
// Best case performance О(n2)
// Average case performance О(n2)
// Worst case space complexity О(n) total, O(1) auxiliary
public class SelectionSort {
    public static void main(String[] args) {
        int[] array = {1, 3, 6, 4, 5, 2};
        selectionSort(array);
        System.out.print(Arrays.toString(array));

    }

    // Everytime find the smallest number and put at the start of the array
    private static void selectionSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++){
            int index = i;
            for (int j = i + 1; j < array.length; j++){
                if (array[j] < array[index]){
                    index = j;
                }
            }
            int smallerNumber = array[index];
            array[index] = array[i];
            array[i] = smallerNumber;
        }
    }

}