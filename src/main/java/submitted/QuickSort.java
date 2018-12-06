import java.util.Arrays;

public class QuickSort {
    public static void sort(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
    }

    public static void quickSort(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }
        int pivotIndex = partition(nums, start, end);
        quickSort(nums, start, pivotIndex - 1);
        quickSort(nums, pivotIndex + 1, end);
    }

    public static int partition(int[] nums, int start, int end) {
        int mid = start + (end - start) / 2;
        int pivot = nums[mid];
        while (start < end) {
            while (nums[start] < pivot) {
                start++;
            }
            while (nums[end] > pivot) {
                end--;
            }
            // swap
            swap(nums, start, end);
        }
        return start;
    }


    public static void swap(int[] array, int i, int j) {
        int t = array[i];
        array[i] = array[j];
        array[j] = t;
    }

    public static void main(String[] args) {
        int[] arr = {3, 2, 5, 6, 1, 4};
        QuickSort.sort(arr);
        System.out.print(Arrays.toString(arr));
    }
}
