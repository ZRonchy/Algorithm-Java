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

    @Test
    public void testTreeMap() {
        // TreeMap will sort elements in ascending order by key
        TreeMap<Integer, String> treeMap = new TreeMap<>();
        treeMap.put(3, "3");
        treeMap.put(1, "1");
        treeMap.put(2, "2");

        treeMap.values().forEach(System.out::println); // 1, 2, 3
        System.out.println(treeMap.firstKey()); // 1
        System.out.println(treeMap.lastKey()); // 3
        System.out.println(treeMap.higherKey(2)); // 3
        System.out.println(treeMap.lowerKey(2)); // 1
    }


    @Test
    public void testTreeSet() {
        // TreeMap will sort elements in ascending order by key
        TreeSet<Integer> treeSet = new TreeSet<>();
        treeSet.add(3);
        treeSet.add(1);
        treeSet.add(2);

        treeSet.stream().forEach(System.out::println); // 1, 2, 3
        System.out.println(treeSet.first()); // 1
        System.out.println(treeSet.last()); // 3
        System.out.println(treeSet.higher(2)); // 3
        System.out.println(treeSet.lower(2)); // 1
    }

    @Test
    public void testStringAndCharacter() {
        // char to String
        char c = 'a';
        String s = Character.toString(c);

        // int to char, char to int
        int i = c - 'a';
        c = (char) (i + 'a');

        // char to int
        int j = Character.getNumericValue(c);

        // char array to String
        char[] ch = s.toCharArray();
        s = new String(ch);

        // char is digit or not
        boolean b = Character.isDigit(c);

    }

    @Test
    public void testLinkedList() {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.addFirst(3);
        linkedList.addFirst(2);
        linkedList.addFirst(1);
        System.out.println(linkedList.poll()); // 1
        System.out.println(linkedList.poll()); // 2
        System.out.println(linkedList.poll()); // 3

        linkedList.addLast(3);
        linkedList.addLast(2);
        linkedList.addLast(1);
        System.out.println(linkedList.poll()); // 3
        System.out.println(linkedList.poll()); // 2
        System.out.println(linkedList.poll()); // 1
    }

}
