package submitted;

import leetcode.TreeTrie.TreeNode;

/**
 * https://leetcode.com/submissions/detail/190576987/
 */
public class LowestCommonAncestorOfBinarySearchTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) {
            return null;
        }

        int large = p.val > q.val ? p.val: q.val;
        int small = p.val < q.val ? p.val: q.val;

        if(root.val==small || root.val==large) {
            return root;
        }

        if (root.val >= small && root.val <= large) {
            return root;
        } else if (root.val < small) {
            return lowestCommonAncestor(root.right, p, q);
        } else if (root.val > large) {
            return lowestCommonAncestor(root.left, p, q);
        }

        return null;
    }
}
