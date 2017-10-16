package leetcode.TreeTrie;

import java.util.LinkedList;

public class InvertBinaryTree {
    // Recursive
    public TreeNode invertTree(TreeNode root) {
        if (root != null) {
            helper(root);
        }

        return root;
    }

    public void helper(TreeNode p) {
        TreeNode temp = p.left;
        p.left = p.right;
        p.right = temp;

        if(p.left!=null)
            helper(p.left);

        if(p.right!=null)
            helper(p.right);
    }

    // Iterative
    public TreeNode invertTree_Iterative(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<>();

        if(root!=null){
            queue.add(root);
        }

        while(!queue.isEmpty()){
            TreeNode p = queue.poll();
            if(p.left!=null)
                queue.add(p.left);
            if(p.right!=null)
                queue.add(p.right);

            TreeNode temp = p.left;
            p.left = p.right;
            p.right = temp;
        }

        return root;
    }

}