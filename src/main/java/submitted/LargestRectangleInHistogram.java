package submitted;

import java.util.Stack;

/**
 * https://leetcode.com/submissions/detail/197641168/
 * time : O(n)
 * space : O(n)
 */
public class LargestRectangleInHistogram {
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) return 0;
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        // Push to stack if increasing and calculate if see a lower height
        for (int i = 0; i <= heights.length; i++) {
            int h = i == heights.length ? 0 : heights[i];
            while (!stack.isEmpty() && h < heights[stack.peek()]) {
                int height = heights[stack.pop()];
                int start = stack.isEmpty() ? -1 : stack.peek();
                int area = height * (i - start - 1);
                res = Math.max(res, area);
            }
            stack.push(i);
        }
        return res;
    }
}
