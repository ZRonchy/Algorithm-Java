package datastructure.sort;

/* *
 * Worst case performance O(n^2)
 * Best case performance O(n)
 * Average case performance O(n^2)
 * Worst case space complexity O(1) auxiliary
 * */

import org.junit.Assert;
import org.junit.Test;

public class BubbleSort {

    private void bubbleSort(int[] arr) {
        boolean swapped = true;
        int j = 0;
        int tmp;
        while (swapped) {
            swapped = false;
            j++;
            for (int i = 0; i < arr.length - j; i++) {
                if (arr[i] > arr[i + 1]) {
                    tmp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = tmp;
                    swapped = true;
                }
            }
        }
    }

    @Test
    public void testBubbleSort() {
        int[] array = {9,8,0,5,6,1,4,2,3,7};
        int[] expectedArray = {0,1,2,3,4,5,6,7,8,9};
        bubbleSort(array);
        Assert.assertArrayEquals("Sort method is wrong", expectedArray, array);
    }
}