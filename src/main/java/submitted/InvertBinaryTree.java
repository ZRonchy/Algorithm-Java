package submitted;

import leetcode.TreeTrie.TreeNode;

/**
 * https://leetcode.com/submissions/detail/191509650/
 */
public class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        helper(root);
        return root;
    }

    void helper(TreeNode root) {
        if (root == null) {
            return;
        }

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        helper(root.left);
        helper(root.right);
    }
}
