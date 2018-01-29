package crackinginterview.hard;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Numbers are randomly generated and passed to a method.
 * Write a program to find and maintain the median value as new values are generated.
 * Solution: One solution is to use two priority heaps: a max heap for the values below the median,
 * and a min heap for the values above the median. The median will be largest value of the max heap.
 * When a new value arrives it is placed in the below heap if the value is less than or equal to the median,
 * otherwise it is placed into the above heap. The heap sizes can be equal or the below heap has one extra.
 * This constraint can easily be restored by shifting an element from one heap to the other.
 * The median is available in constant time, so updates are O(lg n).
 */
public class FindMedianValue {
    private Comparator<Integer> maxHeapComparator, minHeapComparator;
    private PriorityQueue<Integer> maxHeap, minHeap;

    public void addNewNumber(int randomNumber) {
        if (maxHeap.size() == minHeap.size()) {
            if ((minHeap.peek() != null) &&
                    randomNumber > minHeap.peek()) {
                maxHeap.offer(minHeap.poll());
                minHeap.offer(randomNumber);
            } else {
                maxHeap.offer(randomNumber);
            }
        } else {
            if (randomNumber < maxHeap.peek()) {
                minHeap.offer(maxHeap.poll());
                maxHeap.offer(randomNumber);
            } else {
                minHeap.offer(randomNumber);
            }
        }
    }

    public double getMedian() {
        if (maxHeap.isEmpty()) return minHeap.peek();
        else if (minHeap.isEmpty()) return maxHeap.peek();
        if (maxHeap.size() == minHeap.size()) {
            return (minHeap.peek() + maxHeap.peek()) / 2;
        } else if (maxHeap.size() > minHeap.size()) {
            return maxHeap.peek();
        } else {
            return minHeap.peek();
        }
    }
}
