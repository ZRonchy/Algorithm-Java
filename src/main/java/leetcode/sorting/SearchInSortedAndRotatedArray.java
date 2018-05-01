package leetcode.sorting;

/**
 * An element in a sorted array can be found in O(log n) time
 * via binary search. But suppose we rotate an ascending order
 * sorted array at some pivot unknown to you beforehand. So for
 * instance, 1 2 3 4 5 might become 3 4 5 1 2. Devise a way to
 * find an element in the rotated array in O(log n) time.
 * <p>
 * Solution assumes that all elements in array are distinct.
 */
public class SearchInSortedAndRotatedArray {
    // Returns index of key in arr[l..r]
    // if key is present, otherwise returns -1
    static int search(int arr[], int l, int r, int key) {
        if (l > r) {
            return -1;
        }

        int mid = (l + r) / 2;
        if (arr[mid] == key) {
            return mid;
        }

        /* If arr[l...mid] is sorted */
        if (arr[l] <= arr[mid]) {
            /* As this subarray is sorted, we
               can quickly check if key lies in
               half or other half */
            if (key >= arr[l] && key <= arr[mid]) {
                return search(arr, l, mid - 1, key);
            }

            return search(arr, mid + 1, r, key);
        }

        /* If arr[l..mid] is not sorted,
           then arr[mid... r] must be sorted*/
        if (key >= arr[mid] && key <= arr[r]) {
            return search(arr, mid + 1, r, key);
        }

        return search(arr, l, mid - 1, key);
    }

    //main function
    public static void main(String args[]) {
        int arr[] = {4, 5, 6, 7, 8, 9, 1, 2, 3};
        int n = arr.length;
        int key = 6;
        int i = search(arr, 0, n - 1, key);
        if (i != -1) {
            System.out.println("Index: " + i);
        } else {
            System.out.println("Key not found");
        }
    }
}