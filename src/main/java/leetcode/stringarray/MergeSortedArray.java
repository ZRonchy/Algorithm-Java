package leetcode.stringarray;
// Given two sorted integer arrays A and B, merge B into A as one sorted array.
// Note:
// You may assume that A has enough space to hold additional elements from B.
// The number of elements initialized in A and B are m and n respectively.

import java.util.Arrays;

public class MergeSortedArray {
    public static void main(String[] args) {
        int[] odd = {1, 3, 5, 7, 9};
        int[] B = {2, 4, 6, 8, 10};
        int[] A = Arrays.copyOf(odd, odd.length+B.length);
        merge(A, odd.length, B, B.length);
        System.out.print(Arrays.toString(A));
    }

    private static void merge(int A[], int m, int B[], int n) {
        while(m > 0 && n > 0){
            if(A[m-1] > B[n-1]){
                A[m+n-1] = A[m-1];
                m--;
            }else{
                A[m+n-1] = B[n-1];
                n--;
            }
        }

        while(n > 0){
            A[m+n-1] = B[n-1];
            n--;
        }
    }

}
