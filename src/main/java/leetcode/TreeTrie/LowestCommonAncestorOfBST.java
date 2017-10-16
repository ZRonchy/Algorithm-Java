package leetcode.TreeTrie;

// Given a binary search tree (BST),
// find the lowest common ancestor (LCA) of two given nodes in the BST.
public class LowestCommonAncestorOfBST {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode m = root;

        if(m.val > p.val && m.val < q.val){
            return m;
        }else if(m.val>p.val && m.val > q.val){
            return lowestCommonAncestor(root.left, p, q);
        }else if(m.val<p.val && m.val < q.val){
            return lowestCommonAncestor(root.right, p, q);
        }

        return root;
    }

    // Non-recursive
    TreeNode lowestCommonAncestor1(TreeNode bst, int v1, int v2) {
        if (bst == null) return null;
        int small = Math.min(v1, v2);
        int great = Math.max(v1, v2);

        TreeNode n = bst;
        while (n != null && (n.val > great || n.val < small)) {
            if (n.val > great) {
                n = n.left;
            } else {
                n = n.right;
            }
        }
        return n;
    }
}