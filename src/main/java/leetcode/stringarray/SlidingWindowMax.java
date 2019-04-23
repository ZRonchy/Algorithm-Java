package leetcode.stringarray;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

/*
 Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right.
 You can only see the k numbers in the window. Each time the sliding window moves right by one position.
 For example,
 Given nums = [1,3,-1,-3,5,3,6,7], and k = 3.
 Window position                Max
 ---------------               -----
 [1  3  -1] -3  5  3  6  7      3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7
 Therefore, return the max sliding window as [3,3,5,5,6,7].
 Note:
    + create a MaxHeap size of k, add k elements in each out for loop
    + in each step, extract the max and clear the queue for next iteration.
 */
public class SlidingWindowMax {

    private static int[] maxSlidingWindow(int[] a, int k) {
        if(a == null || a.length == 0) return new int[] {};
        PriorityQueue<Integer> pq = new PriorityQueue<>(k, (o1, o2) -> o2 - o1);
        int[] result = new int[a.length - k + 1];
        int count = 0;
        for (int i = 0; i < a.length - k + 1; i++) {
            for (int j = i; j < i + k; j++) {
                pq.offer(a[j]);
            }
            result[count] = pq.poll();
            count = count + 1;
            pq.clear();
        }
        return result;

    }

    /**
     * We create a Dequeue, Qi of capacity k, that stores only useful elements of current
     * window of k elements. An element is useful if it is in current window and is greater
     * than all other elements on left side of it in current window. We process all array
     * elements one by one and maintain Qi to contain useful elements of current window and
     * these useful elements are maintained in sorted order. The element at front of the Qi
     * is the largest and element at rear of Qi is the smallest of current window.
     * @param nums
     * @param k
     * @return
     */
    public static int[] maxSlidingWindow1(int[] nums, int k) {
        if(nums==null||nums.length==0)
            return new int[0];

        int[] result = new int[nums.length-k+1];

        LinkedList<Integer> deque = new LinkedList<>();
        for(int i=0; i<nums.length; i++){
            // Remove ele out of the window
            // Whatever the ordering used, the head of the queue is that element which
            // would be removed by a call to remove() or poll(). In a FIFO queue, all new elements are
            // inserted at the tail of the queue.
            if(!deque.isEmpty() && deque.peekFirst() == i-k) {
                deque.poll();
            }

            // remove new eles that is smaller than current ele
            while(!deque.isEmpty() && nums[deque.peekLast()] < nums[i]){
                deque.removeLast();
            }

            deque.offer(i);

            if(i+1>=k) {
                result[i+1-k]=nums[deque.peek()];
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] a = { 1, 3, -1, -3, 5, 3, 6, 7 };
        int k = 3;
        System.out.println(Arrays.toString(maxSlidingWindow(a, k)));
        System.out.println(Arrays.toString(maxSlidingWindow1(a, k)));
    }
}
