package leetcode.sorting;

/**
 * Given an array A[] consisting 0s, 1s and 2s, write a function that sorts A[].
 * The functions should put all 0s first, then all 1s and all 2s in last. (Could be in any order)
 Examples:
 Input :  {0, 1, 2, 0, 1, 2}
 Output : {0, 0, 1, 1, 2, 2}

 Input :  {0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1}
 Output : {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2}
 https://www.geeksforgeeks.org/sort-an-array-of-0s-1s-and-2s/
 */
public class SegregateNumbers {
    static void segregateNumbers(int a[]) {
        int lo = 0;
        int hi = a.length - 1;
        int mid = 0, temp = 0;
        while (mid <= hi) {
            switch (a[mid]) {
                case 0:
                    temp = a[lo];
                    a[lo] = a[mid];
                    a[mid] = temp;
                    lo++;
                    mid++;
                    break;

                case 1:
                    mid++;
                    break;
                case 2:
                    temp = a[mid];
                    a[mid] = a[hi];
                    a[hi] = temp;
                    hi--;
                    break;

            }
        }
    }
}
