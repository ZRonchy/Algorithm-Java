package leetcode.sorting;

/**
 * 思想：堆排序是利用堆的性质进行的一种选择排序，先将排序元素构建一个最大堆,
 * 每次堆中取出最大的元素并调整堆。将该取出的最大元素放到已排好序的序列前面。
 * 这种方法相对选择排序，时间复杂度更低，效率更高。
 * 时间复杂度：最坏:O(nlog2n) 最好: O(nlog2n) 平均: O(nlog2n)
 * 空间复杂度：O(1)
 * 稳定性：不稳定 例如 5 10 15 10。 如果堆顶5先输出，则第三层的10(最后一个10)的跑到堆顶，
 * 然后堆稳定，继续输出堆顶，则刚才那个10跑到前面了，所以两个10排序前后的次序发生改变。
 * https://www.cnblogs.com/jetpie/p/3971382.html
 */
public class HeapSort {
    public void sort(int arr[]) {
        int n = arr.length;

        // 1. Build heap (rearrange array)
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);

        // One by one extract an element from heap
        for (int i = n - 1; i >= 0; i--) {
            // 2. Move swap root with the last node
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // 3. call max heapify on the reduced heap
            heapify(arr, i, 0);
        }
    }

    // To heapify a subtree rooted with node i which is
    // an index in arr[]. n is size of heap
    void heapify(int arr[], int n, int i) {
        int largest = i;  // Initialize largest as root
        int l = 2 * i + 1;  // left = 2*i + 1
        int r = 2 * i + 2;  // right = 2*i + 2

        // If left child is larger than root
        if (l < n && arr[l] > arr[largest])
            largest = l;

        // If right child is larger than largest so far
        if (r < n && arr[r] > arr[largest])
            largest = r;

        // If largest is not root
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            // Recursively heapify the affected sub-tree
            heapify(arr, n, largest);
        }
    }

    static void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    public static void main(String args[]) {
        int arr[] = {12, 11, 13, 5, 6, 7};
        int n = arr.length;

        HeapSort ob = new HeapSort();
        ob.sort(arr);

        System.out.println("Sorted array is");
        printArray(arr);
    }

}
