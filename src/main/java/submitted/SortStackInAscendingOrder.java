package submitted;

import java.util.Stack;

/**
 * time O(N * N)
 */
public class SortStackInAscendingOrder {
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
