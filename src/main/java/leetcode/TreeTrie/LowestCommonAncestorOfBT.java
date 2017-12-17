package leetcode.TreeTrie;

// Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
public class LowestCommonAncestorOfBT {
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null)
            return null;

        if(root==p || root==q)
            return root;

        TreeNode l = lowestCommonAncestor1(root.left, p, q);
        TreeNode r = lowestCommonAncestor1(root.right, p, q);

        if(l!=null && r!=null){
            return root;
        } else if(l==null && r==null){
            return null;
        } else {
            return l==null ? r : l;
        }
    }

    /**
     * if p and q are both on the left of the node, branch left to look for the common ancestor.
     * When p and q are no longer on the same side, you must have found the first common ancestor.
     * */
    public TreeNode commonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (covers(root.left, p) && covers(root.left, q)) {
            return commonAncestor(root.left, p, q);
        }
        if (covers(root.right, p) && covers(root.right, q)) {
            return commonAncestor(root.right, p, q);
        }
        return root;
    }

    private boolean covers(TreeNode root, TreeNode p) { /* is p a child of root? */
        if (root == null) return false;
        if (root == p) return true;
            return covers(root.left, p) || covers(root.right, p);
     }

}