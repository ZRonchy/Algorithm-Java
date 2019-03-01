package submitted;

import leetcode.TreeTrie.TreeNode;

/**
 * https://leetcode.com/submissions/detail/211398202/
 */
public class ConvertBSTToGreaterTree {
    public TreeNode convertBST(TreeNode root) {
        int[] rightSum = new int[1];
        dfsHelper(root, rightSum);
        return root;
    }
    public void dfsHelper(TreeNode root, int[] rightSum) {
        if (root == null) return;
        dfsHelper(root.right, rightSum);
        root.val += rightSum[0];
        rightSum[0] = root.val;
        dfsHelper(root.left, rightSum);
    }
}
