package submitted;

import leetcode.TreeTrie.TreeNode;

/**
 * https://leetcode.com/submissions/detail/190320063/
 */
public class LowestCommonAncestorOfBinaryTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }

        // return when find either p or q on a left or right branch
        if (root == p || root == q) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p , q);

        // if found p and q on different branches
        if (left != null && right != null) {
            return root;
        }

        // if not found p or q
        if (left == null && right == null) {
            return null;
        }

        // if found p or q on one side
        return left == null ? right : left;
    }
}
