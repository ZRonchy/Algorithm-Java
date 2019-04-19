package sword;

/**
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
 * 输入一个数组,求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。 即输出P%1000000007
 * 题目保证输入的数组中没有的相同的数字
 */
public class InversePairs {
    static int count = 0;

    public static int inversePairs(int [] array) {
        if(array == null || array.length ==0)
            return 0;
        mergeSort(array, 0, array.length -1);
        return count;

    }
    public static void mergeSort(int[] array, int start, int end) {
        if(start < end) {
            int mid = (start + end)/2;
            mergeSort(array, start, mid);
            mergeSort(array, mid + 1, end);
            merge(array, start, mid, mid+ 1, end);
        }
    }
    public static void merge(int[] array, int start1, int end1, int start2, int end2) {
        int i = end1;
        int j = end2;
        int k = end2 - start1 ;
        int [] temp = new int[end2-start1+1];
        while(i >= start1 && j >=start2) {
            if(array[i] > array[j]) {
                //假设此时两个归并的是17 19 22 || 16 18 21
                //那么22大于21，所以可以看出对应22
                //有三个，22 16 22 18 22 21
                temp[k--] = array[i--];
                count = count + j - start2 +1;
                count %= 1000000007;
            }
            else
                temp[k--] = array[j--];
        }
        while(i >= start1)
            temp[k--] = array[i--];
        while(j >= start2)
            temp[k--] = array[j--];

        int m = start1;
        for(int element:temp)
            array[m++] = element;

    }


    public static void main(String[] args) {
        int[] data = {1, 2, 3, 4, 7, 6, 5};
        System.out.println(inversePairs(data)); // 3
        int[] data2 = {6, 5, 4, 3, 2, 1};
        System.out.println(inversePairs(data2)); //  15
        int[] data3 = {1, 2, 3, 4, 5, 6};
        System.out.println(inversePairs(data3)); // 0
        int[] data4 = {1};
        System.out.println(inversePairs(data4)); // 0
        int[] data5 = {1, 2};
        System.out.println(inversePairs(data5)); // 0
        int[] data6 = {2, 1};
        System.out.println(inversePairs(data6)); // 1
        int[] data7 = {1, 2, 1, 2, 1};
        System.out.println(inversePairs(data7)); // 3
    }
}
