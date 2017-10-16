package datastructure.sort;

/* *
 * Worst case performance О(n2) comparisons, swaps
 * Best case performance O(n) comparisons, O(1) swaps
 * Average case performance О(n2) comparisons, swaps
 * Worst case space complexity О(n) total, O(1) auxiliary
 * */

import org.junit.Assert;
import org.junit.Test;

public class InsertionSort {

    private void insertionSort(int array[]) {
        int n = array.length;
        for (int j = 1; j < n; j++) {
            int key = array[j];
            int i = j-1;
            while ( (i > -1) && ( array [i] > key ) ) {
                array [i+1] = array [i];
                i--;
            }
            array[i+1] = key;
        }
    }

    @Test
    public void testInsertionSort() {
        int[] array = {9,8,0,5,6,1,4,2,3,7};
        int[] expectedArray = {0,1,2,3,4,5,6,7,8,9};
        insertionSort(array);
        Assert.assertArrayEquals("Sort method is wrong", expectedArray, array);
    }
}