package leetcode.TreeTrie;

// All values on the left sub tree must be less than root, and all values
// on the right sub tree must be greater than root. So we just check the boundaries for each node.
public class ValidBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        if(root==null)
            return true;

        return helper(root, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);
    }

    public boolean helper(TreeNode root, double low, double high){

        if(root.val<=low || root.val>=high)
            return false;

        if(root.left!=null && !helper(root.left, low, root.val)){
            return false;
        }

        if(root.right!=null && !helper(root.right, root.val, high)){
            return false;
        }

        return true;
    }
}