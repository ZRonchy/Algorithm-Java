package unclassfied;

import org.junit.Test;

import java.util.*;

public class DataStructure {
    @Test
    public void testQueue() {
        Queue<String> queue = new LinkedList<>();
        queue.offer("a");
        queue.offer("b");
        System.out.println(queue.peek()); // a
        System.out.println(queue.poll()); // a
    }

    @Test
    public void testStack() {
        Stack<String> stack = new Stack<>();
        stack.push("a");
        stack.push("b");
        System.out.println(stack.peek()); // b
        System.out.println(stack.pop());  // b
    }

    @Test
    public void testDeque() {
        Deque<String> deque = new LinkedList<>();
        String[] array = {"1", "2", "3", "4"};

        // used as a stack
        for (String ele: array) {
            deque.push(ele);
        }
        System.out.println(deque.peekFirst()); // 4
        System.out.println(deque.peekLast());  // 1
        System.out.println(deque.pop());  // 4
        System.out.println(deque.removeFirst());  // 3
        System.out.println(deque.removeLast());  // 1

        deque.clear();

        // used as a queue
        for (String ele: array) {
            deque.offer(ele);
        }
        System.out.println(deque.peekFirst()); // 1
        System.out.println(deque.peekLast());  // 4
        System.out.println(deque.poll());  // 1
        System.out.println(deque.removeFirst());  // 2
        System.out.println(deque.removeLast());  // 4
    }

    /**
     * Get min/max element O(1)
     * Add new element O(logn)
     * Remove min/max element O(logn)
     */
    @Test
    public void testPriorityQueue() {
        Integer[] array = {3, 1, 4, 2};
        // By default it is a min heap
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (Integer ele: array) {
            minHeap.offer(ele);
        }

        System.out.println(minHeap.poll());  // 1

        // Create a max heap
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        // PriorityQueue<Integer> maxHeap = new PriorityQueue<>((x, y) -> y - x);

        for (Integer ele: array) {
            maxHeap.offer(ele);
        }

        System.out.println(maxHeap.poll());  // 4
    }
}
