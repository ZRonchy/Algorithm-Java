package submitted;

import leetcode.TreeTrie.TreeNode;

/**
 * https://leetcode.com/submissions/detail/187458183/
 */
public class MaximumDepthOfBinaryTree {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftPath = maxDepth(root.left);
        int rightPath = maxDepth(root.right);

        return Math.max(leftPath, rightPath) + 1;
    }
}
