package leetcode.TreeTrie;

// Given a binary tree, determine if it is height-balanced.
// For this problem, a height-balanced binary tree is defined as
// a binary tree in which the depth of the two subtrees of every node
// never differ by more than 1.
public class BalancedBinaryTree {
    /*Solution 1*/
    public boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;

        if (getHeight(root) == -1)
            return false;

        return true;
    }

    public int getHeight(TreeNode root) {
        if (root == null)
            return 0;

        int left = getHeight(root.left);
        int right = getHeight(root.right);

        if (left == -1 || right == -1)
            return -1;

        if (Math.abs(left - right) > 1) {
            return -1;
        }

        return Math.max(left, right) + 1;

    }

    /**
     * Solution 2
     * the difference of min depth and max depth should not exceed 1,
     * since the difference of the min and the max depth is the maximum distance difference
     * possible in the tree.
    */
    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1+Math.max(maxDepth(root.left), maxDepth(root.right));
    }

    public static  int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1+Math.min(minDepth(root.left), minDepth(root.right));
    }

    public static boolean isBalanced1(TreeNode root) {
        return (maxDepth(root) - minDepth(root) <= 1);
    }

}