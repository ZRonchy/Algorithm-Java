package sword.array;

/**
 * 统计一个数字在有序数组中出现的次数
 */
public class NumberOfKInArray {
    public int getNumberOfK(int [] array , int k) {
        if (array == null || array.length == 0) {
            return 0;
        }

        int firstIndex = getFirstK(array, k);
        int lastIndex = getLastK(array, k);

        if (firstIndex == -1 || lastIndex == -1) {
            return 0;
        }

        return lastIndex - firstIndex + 1;
    }

    private int getLastK(int[] array, int k) {
        int left = 0;
        int right = array.length - 1;
        int index = -1;
        while (left <= right) {
            int middle = left + (right - left) / 2;
            if (array[middle] <= k) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
            if(array[middle] == k) {
                index = middle;
            }
        }
        return index;
    }

    private int getFirstK(int[] array, int k) {
        int left = 0;
        int right = array.length - 1;
        int index = -1;
        while (left <= right) {
            int middle = left + (right - left) / 2;
            if (array[middle] >= k) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
            if(array[middle] == k) {
                index = middle;
            }
        }
        return index;
    }
}
