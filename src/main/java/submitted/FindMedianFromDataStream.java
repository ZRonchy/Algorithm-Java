package submitted;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/submissions/detail/200225270/
 * One max heap to keep the smaller half of the data
 * One min heap to keep the larger half of the data
 * Balance: 0 <= |smaller| - |larger| <= 1
 * Roots of the heaps are median candidates
 * So Add is O(logn), compute median is O(1), total = log1+log2+...+logn=O(nlogn)
 */
public class FindMedianFromDataStream {
    // max queue is always larger or equal to min queue
    PriorityQueue<Integer> min = new PriorityQueue(); // holds larger half
    PriorityQueue<Integer> max = new PriorityQueue(Collections.reverseOrder()); // holds smaller half
    // Adds a number into the data structure.
    public void addNum(int num) {
        max.offer(num);
        min.offer(max.poll());
        if (max.size() < min.size()){
            max.offer(min.poll());
        }
    }

    // Returns the median of current data stream
    public double findMedian() {
        if (max.size() == min.size()) return (max.peek() + min.peek()) /  2.0;
        else return max.peek();
    }
}
