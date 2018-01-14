package crackinginterview.stacksandqueues;

import java.util.Stack;

/**
 * Implement a MyQueue class which implements a queue using two stacks
 * Solution:
 * s1 will thus be ordered with the newest elements on the top, while s2 will have the oldest elements
 * on the top. We push the new elements onto s1, and peek and pop from s2.
 * When s2 is empty, we’ll transfer all the elements from s1 onto s2, in reverse order.
 */
public class ImplementQueueWithStacks {
}

class MyQueue<T> {
    Stack<T> s1, s2;

    public MyQueue() {
        s1 = new Stack<T>();
        s2 = new Stack<T>();
    }

    public int size() {
        return s1.size() + s2.size();
    }

    public void add(T value) {
        s1.push(value);
    }

    public T peek() {
        if (!s2.empty()) return s2.peek();
        while (!s1.empty()) s2.push(s1.pop());
        return s2.peek();
    }

    public T remove() {
        if (!s2.empty()) return s2.pop();
        while (!s1.empty()) s2.push(s1.pop());
        return s2.pop();
    }
}