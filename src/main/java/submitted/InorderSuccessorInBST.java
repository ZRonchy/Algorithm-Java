package submitted;

import leetcode.TreeTrie.TreeNode;

/**
 * https://leetcode.com/submissions/detail/201267876/
 */
public class InorderSuccessorInBST {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode res = null;
        while (root != null) {
            if (root.val <= p.val) {
                root = root.right;
            } else {
                res = root;
                root = root.left;
            }
        }
        return res;
    }
}
