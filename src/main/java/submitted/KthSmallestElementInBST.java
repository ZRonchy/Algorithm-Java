package submitted;

import leetcode.TreeTrie.TreeNode;

import java.util.Stack;

/**
 * https://leetcode.com/submissions/detail/194810281/
 */
public class KthSmallestElementInBST {
    public int kthSmallest(TreeNode root, int k) {
        if (root == null) {
            return 0;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;
        while (p != null) {
            stack.push(p);
            p = p.left;
        }
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (--k == 0) {
                return node.val;
            }
            TreeNode q = node.right;
            while (q != null) {
                stack.push(q);
                q = q.left;
            }
        }

        return 0;
    }
}
