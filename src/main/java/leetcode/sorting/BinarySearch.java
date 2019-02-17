package leetcode.sorting;

// return index of the search key, if not found, return -1
public class BinarySearch {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6};
        System.out.print(binarySearch(array, 3));

    }

    public static int binarySearch(int[] array, int key) {
        int first = 0;
        int last = array.length - 1;

        while (first <=  last) {
            int middle = (first + last) / 2; // int middle = first + (last-first)/2;

            if (array[middle] > key) {
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
    public static int binarySearch1(int[] array, int key) {
        int first = 0;
        int last = array.length - 1;

        while (first <  last) {
            int middle = (first + last) / 2; // int middle = first + (last-first)/2;

            if (array[middle] > key) {
                last = middle ;
            } else if (array[middle] < key) {
                first = middle + 1;
            } else {
                return middle;
            }
        }

        // first is guaranteed to be smaller or equal to last
        return -1;
    }

}