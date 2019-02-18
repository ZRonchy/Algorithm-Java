package submitted;

import leetcode.TreeTrie.TreeNode;

/**
 * https://leetcode.com/submissions/detail/208611790/
 * time : O(n);
 * space : O(n);
 */
public class SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        if (p.val != q.val) return false;

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
