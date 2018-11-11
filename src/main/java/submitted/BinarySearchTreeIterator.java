package submitted;

import leetcode.TreeTrie.TreeNode;

import java.util.Stack;

/**
 * https://leetcode.com/submissions/detail/188916803/
 * In order traversal will give an sorted result of a binary search tree.
 * time O(n)
 */
public class BinarySearchTreeIterator {
    private TreeNode cur;
    private Stack<TreeNode> stack;

    public BinarySearchTreeIterator(TreeNode root) {
        cur = root;
        stack = new Stack<>();
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty() || cur != null;
    }


    /** @return the next smallest number */
    public int next() {
        // in order traversal
        while (cur != null) {
            stack.push(cur);
            cur = cur.left;
        }

        cur = stack.pop();
        int val = cur.val;
        cur = cur.right;
        return val;
    }
}
