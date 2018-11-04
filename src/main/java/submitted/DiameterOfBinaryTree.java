package submitted;

import leetcode.TreeTrie.TreeNode;

/**
 * https://leetcode.com/submissions/detail/187457474/
 * Each path could just have one root (turning point that could have both left and right child nodes)
 * Recursion on each node and record the maximum path via that node
 * time O(n)
 * space O(h) : h is the height of the tree. Recursion need to push frames to stack so space O(h)
 */
public class DiameterOfBinaryTree {
    int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        return max;
    }

    private int maxDepth(TreeNode root) {
        if (root == null) return 0;

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        max = Math.max(max, left + right);

        return Math.max(left, right) + 1;
    }
}
