package leetcode.sorting;

// return index of the search key, if not found, return -1
public class BinarySearch {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6};
        System.out.print(binarySearch(array, 3));

    }

    //左闭右闭区间
    public static int binarySearch(int[] array, int key) {
        int first = 0;
        int last = array.length - 1;

        while (first <= last) { // break when first > last
            int middle = (first + last) / 2; // int middle = first + (last-first)/2;

            if (array[middle] > key) { // target is in [left, right]
                last = middle -1 ;
            } else if (array[middle] < key) {
                first = middle + 1;
            } else {
                return middle;
            }
        }

        // first might ended larger than last, has to check which is smaller and return
        return -1;
    }

    //左闭右开区间
    public static int binarySearch1(int[] array, int key) {
        int first = 0;
        int last = array.length - 1;

        while (first < last) { // break when first >= last [)
            int middle = (first + last) / 2; // int middle = first + (last-first)/2;

            if (array[middle] > key) { // target is in [left, right)
                last = middle ; //
            } else if (array[middle] < key) {
                first = middle + 1;
            } else {
                return middle;
            }
        }

        // first is guaranteed to be smaller or equal to last
        return -1;
    }

    public static int binarySearch2(int[] array, int key) {
        int first = 0;
        int last = array.length - 1;

        while (first + 1 < last) { // break when first + 1 = last
            int middle = (first + last) / 2;

            if (array[middle] > key) {
                last = middle ;
            } else if (array[middle] < key) {
                first = middle;
            } else {
                return middle;
            }
        }

        // first + 1 = right, so either first or right could be target value
        return -1;
    }
}