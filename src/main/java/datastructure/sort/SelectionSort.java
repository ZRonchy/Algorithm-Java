package datastructure.sort;

/* *
 * Worst case performance О(n2)
 * Best case performance О(n2)
 * Average case performance О(n2)
 * Worst case space complexity О(n) total, O(1) auxiliary
 * */

import org.junit.Assert;
import org.junit.Test;

public class SelectionSort {

    private void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int index = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[index]) {
                    index = j;
                }
            }
            int smallerNumber = arr[index];
            arr[index] = arr[i];
            arr[i] = smallerNumber;
        }
    }

    @Test
    public void testSelectionSort() {
        int[] array = {9,8,0,5,6,1,4,2,3,7};
        int[] expectedArray = {0,1,2,3,4,5,6,7,8,9};
        selectionSort(array);
        Assert.assertArrayEquals("Sort method is wrong", expectedArray, array);
    }
}