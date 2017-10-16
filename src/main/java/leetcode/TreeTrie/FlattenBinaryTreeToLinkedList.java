package leetcode.TreeTrie;

import java.util.Stack;

// Go down through the left, when right is not null, push right to stack.
public class FlattenBinaryTreeToLinkedList {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        flatten(root);
        System.out.println(root.right.left);
    }

    // Recursive
    public static void flatten(TreeNode root) {
        if (root == null) return;

        TreeNode left = root.left;
        TreeNode right = root.right;

        root.left = null;

        flatten(left);
        flatten(right);

        root.right = left;
        TreeNode cur = root;
        while (cur.right != null) cur = cur.right;
        cur.right = right;
    }


    // Iterative
    public void flatten1(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;

        while(p != null || !stack.empty()) {

            if(p.right != null) {
                stack.push(p.right);
            }

            if(p.left != null) {
                p.right = p.left;
                p.left = null;
            }else if(!stack.empty()) {
                TreeNode temp = stack.pop();
                p.right=temp;
            }

            p = p.right;
        }
    }
}