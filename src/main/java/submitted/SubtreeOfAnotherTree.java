package submitted;

import leetcode.TreeTrie.TreeNode;

import java.util.Stack;

/**
 * https://leetcode.com/submissions/detail/211621446/
 */
public class SubtreeOfAnotherTree {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null) {
            return false;
        }

        if (isSameTreeNode(s, t)) {
            return true;
        }

        return isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    boolean isSameTreeNode(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        }

        if (s == null || t == null) {
            return false;
        }

        if (s.val != t.val) {
            return false;
        }

        return isSameTreeNode(s.left, t.left) &&
                isSameTreeNode(s.right, t.right);
    }

    public boolean isSubtree_preorder(TreeNode s, TreeNode t) {
        String spreorder = generatepreorderString(s);
        String tpreorder = generatepreorderString(t);

        return spreorder.contains(tpreorder) ;
    }
    public String generatepreorderString(TreeNode s){
        StringBuilder sb = new StringBuilder();
        Stack<TreeNode> stacktree = new Stack();
        stacktree.push(s);
        while(!stacktree.isEmpty()){
            TreeNode popelem = stacktree.pop();
            if(popelem==null)
                sb.append(",#"); // Appending # inorder to handle same values but not subtree cases
            else
                sb.append(","+popelem.val);
            if(popelem!=null){
                stacktree.push(popelem.right);
                stacktree.push(popelem.left);
            }
        }
        return sb.toString();
    }
}
