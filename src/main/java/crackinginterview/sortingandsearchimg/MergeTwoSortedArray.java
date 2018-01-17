package crackinginterview.sortingandsearchimg;

/**
 * You are given two sorted arrays, A and B, and A
 * has a large enough buffer at the end to hold B.
 * Write a method to merge B into A in sorted order.
 */
public class MergeTwoSortedArray {
    public void merge(int[] a, int[] b) {
        int k = a.length + b.length - 1;
        int i = a.length - 1;
        int j = b.length - 1;

        // Start comparing from the last element and merge a and b
        while (i >= 0 && j >= 0) {
            if (a[i] > b[j]) {
                a[k--] = a[i--];
            } else {
                a[k--] = b[j--];
            }
        }
        while (i >= 0) { //Suppose A is longer
            a[k--] = b[j--];
        }
    }
}
