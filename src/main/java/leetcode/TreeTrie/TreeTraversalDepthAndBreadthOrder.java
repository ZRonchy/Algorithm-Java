package leetcode.TreeTrie;

import java.util.LinkedList;
import java.util.Stack;

public class TreeTraversalDepthAndBreadthOrder {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
//        levelOrderPrint(root);
//        depthOrderPrint(root);
        depthOrderPrintNoStack(root);
    }

    public static void levelOrderPrint(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.push(root);
        while(!queue.isEmpty()) {
            TreeNode node = queue.pop();
            System.out.println(node.val);

            if (node.left != null) {
                queue.add(node.left);
            }

            if (node.right != null) {
                queue.add(node.right);
            }
        }
    }


    public static void depthOrderPrint(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            System.out.println(node.val);

            if(node.right != null) {
                stack.push(node.right);
            }

            if(node.left != null) {
                stack.push(node.left);
            }
        }

    }

    public static void depthOrderPrintNoStack(TreeNode root) {
        depthOrderPrintNoStackHelper(root);
    }

    public static void depthOrderPrintNoStackHelper(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.println(node.val);

        depthOrderPrintNoStackHelper(node.left);
        depthOrderPrintNoStackHelper(node.right);
    }

}