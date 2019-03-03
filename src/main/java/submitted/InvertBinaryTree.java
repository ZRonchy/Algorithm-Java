package submitted;

import leetcode.TreeTrie.TreeNode;

import java.util.LinkedList;

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

    public TreeNode invertTree_iterative(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<>();

        if (root != null) {
            queue.add(root);
        }

        while (!queue.isEmpty()) {
            TreeNode p = queue.poll();
            if (p.left != null)
                queue.add(p.left);
            if (p.right != null)
                queue.add(p.right);

            TreeNode temp = p.left;
            p.left = p.right;
            p.right = temp;
        }

        return root;
    }
}
