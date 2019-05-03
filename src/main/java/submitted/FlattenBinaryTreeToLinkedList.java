package submitted;

import leetcode.TreeTrie.TreeNode;

import java.util.Stack;

/**
 * https://leetcode.com/submissions/detail/226391456/
 */
public class FlattenBinaryTreeToLinkedList {
    // set up a "global" variable to represent the previous node in the result linked list
    private TreeNode prev;

    public void flatten(TreeNode root) {
        if (root == null) return;
        prev = null;
        preorder(root);
    }

    private void preorder(TreeNode curr) {
        if (curr == null) return;

        // set the previous node's right child to point to the current node
        if (prev != null) {
            prev.right = curr;
            prev.left = null;
        }

        // update previous node to be the current node
        prev = curr;
        // store the right node in advance NOTE: don't forget this step
        TreeNode right = curr.right;
        preorder(curr.left);
        preorder(right);
    }

    // iterative
    public void flatten_iterative(TreeNode root) {
        if (root == null) {
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode prev = null;
        stack.push(root);

        while (!stack.empty()) {
            TreeNode curr = stack.pop();
            // set the previous node's right child and left child
            if (prev != null) {
                prev.right = curr;
                prev.left = null;
            }

            // update previous node
            prev = curr;
            if (curr.right != null) {
                stack.push(curr.right);
            }
            if (curr.left != null) {
                stack.push(curr.left);
            }
        }
    }

}
