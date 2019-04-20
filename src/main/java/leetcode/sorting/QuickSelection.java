package leetcode.sorting;

/**
 * Quick select is a selection algorithm to find the k-th smallest element
 * in an unordered list. It is related to the quick sort sorting algorithm.
 * Examples:
 * <p>
 * Input: arr[] = {7, 10, 4, 3, 20, 15}
 * k = 3
 * Output: 7
 * <p>
 * Input: arr[] = {7, 10, 4, 3, 20, 15}
 * k = 4
 * Output: 10
 * time: O(n) worst case O(n*n)
 */
public class QuickSelection {
    // Standard partition process of QuickSort. It considers the last element as pivot
    // and moves all smaller element to left of it and greater elements to right
    public static int partition(Integer[] arr, int l, int r) {
        int pivot = arr[r], partitionIndex = l;
        for (int j = l; j <= r - 1; j++) {
            if (arr[j] <= pivot) {
                //Swapping arr[partitionIndex] and arr[j]
                swap(arr, partitionIndex, j);
                partitionIndex++;
            }
        }

        //Swapping arr[partitionIndex] and arr[r]
        swap(arr, partitionIndex, r);

        return partitionIndex;
    }

    // This function returns k'th smallest element
    // in arr[l..r] using QuickSort based method.
    // ASSUMPTION: ALL ELEMENTS IN ARR[] ARE DISTINCT
    public static int kthSmallest(Integer[] arr, int l, int r, int k) {
        // If k is smaller than number of elements
        // in array
        if (k > 0 && k <= r - l + 1) {
            // Partition the array around last
            // element and get position of pivot
            // element in sorted array
            int pos = partition(arr, l, r);

            // If position is same as k
            if (pos - l == k - 1)
                return arr[pos];

            // If position is more, recur for
            // left subarray
            if (pos - l > k - 1)
                return kthSmallest(arr, l, pos - 1, k);

            // Else recur for right subarray
            return kthSmallest(arr, pos + 1, r, k - pos + l - 1);
        }

        // If k is more than number of elements
        // in array
        return Integer.MAX_VALUE;
    }

    private static void swap(Integer[] arr, int firstIndex, int secondIndex) {
        int temp = arr[firstIndex];
        arr[firstIndex] = arr[secondIndex];
        arr[secondIndex] = temp;
    }

    public static void main(String[] args) {
        Integer[] array = {7, 10, 4, 3, 20, 15};
        System.out.println(kthSmallest(array, 0, array.length - 1, 3));
        System.out.println(kthSmallest(array, 0, array.length - 1, 4));
    }
}
