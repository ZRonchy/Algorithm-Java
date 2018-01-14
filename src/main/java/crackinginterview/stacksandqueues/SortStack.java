package crackinginterview.stacksandqueues;

import java.util.Stack;

/**
 * Write a program to sort a stack in ascending order.
 * You should not make any assumptions about how the stack is implemented.
 * The following are the only functions that should be used to write this program:
 * push | pop | peek | isEmpty.
 */
public class SortStack {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(5);
        stack.push(3);
        stack.push(2);
        stack.push(4);

        Stack<Integer> newStack = sort(stack);

        while (!newStack.isEmpty()) {
            System.out.println(newStack.pop());
        }
    }

    public static Stack<Integer> sort(Stack<Integer> s) {
        Stack<Integer> r = new Stack<>();
        while (!s.isEmpty()) {
            int tmp = s.pop();
            while (!r.isEmpty() && r.peek() > tmp) {
                s.push(r.pop());
            }
            r.push(tmp);
        }
        return r;
    }
}
