package leetcode.TreeTrie;

import java.util.Stack;

/**
 * Given an array of numbers, return true if given array can represent preorder traversal
 * of a Binary Search Tree, else return false. Expected time complexity is O(n).
 * Input:  pre[] = {2, 4, 3}
 * Output: true
 * <p>
 * Input:  pre[] = {2, 4, 1}
 * Output: false
 * <p>
 * Solution:
 * 1) Find the first greater value on right side of current node.
 * Let the index of this node be j. Return true if following
 * conditions hold. Else return false
 * (i)  All values after the above found greater value are
 * greater than current node.
 * (ii) Recursive calls for the subarrays pre[i+1..j-1] and
 * pre[j+1..n-1] also return true.
 */
public class CheckArrayRepresentPreOrder {
    boolean canRepresentBST(int pre[], int n) {
        // Create an empty stack
        Stack<Integer> s = new Stack<Integer>();

        // Initialize current root as minimum possible
        // value
        int root = Integer.MIN_VALUE;

        // Traverse given array
        for (int i = 0; i < n; i++) {
            // If we find a node who is on right side
            // and smaller than root, return false
            if (pre[i] < root) {
                return false;
            }

            // If pre[i] is in right subtree of stack top,
            // Keep removing items smaller than pre[i]
            // and make the last removed item as new
            // root.
            while (!s.empty() && s.peek() < pre[i]) {
                root = s.peek();
                s.pop();
            }
            System.out.println(root);

            // At this point either stack is empty or
            // pre[i] is smaller than root, push pre[i]
            s.push(pre[i]);
        }
        return true;
    }

    public static void main(String args[]) {
        CheckArrayRepresentPreOrder bst = new CheckArrayRepresentPreOrder();
        int[] pre1 = new int[]{40, 30, 35, 80, 100};
        int n = pre1.length;
        if (bst.canRepresentBST(pre1, n)) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
//        int[] pre2 = new int[]{40, 30, 35, 20, 80, 100};
//        int n1 = pre2.length;
//        if (bst.canRepresentBST(pre2, n)) {
//            System.out.println("true");
//        } else {
//            System.out.println("false");
//        }
    }
}
