package submitted;

import java.util.Stack;

/**
 * https://leetcode.com/submissions/detail/204000106/
 */
public class MaxStack {
    Stack<Integer> stack;
    Stack<Integer> maxStack;
    /** initialize your data structure here. */
    public MaxStack() {
        stack = new Stack<>();
        maxStack = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if (!maxStack.isEmpty()) {
            int element = maxStack.peek();
            if (x >= element) {
                maxStack.push(x);
            }
        } else {
            maxStack.push(x);
        }

    }

    public int pop() {
        int x = stack.pop();
        if (!maxStack.isEmpty() && x == maxStack.peek()) {
            maxStack.pop();
        }
        return x;
    }

    public int top() {
        return stack.peek();
    }

    public int peekMax() {
        return maxStack.peek();
    }

    public int popMax() {
        int max = maxStack.pop();
        Stack<Integer> buffer = new Stack<>();
        while (stack.peek() != max) {
            buffer.push(stack.pop());
        }
        if (stack.peek() == max) {
            stack.pop();
        }

        while (!buffer.isEmpty()) {
            push(buffer.pop());
        }

        return max;
    }
}
