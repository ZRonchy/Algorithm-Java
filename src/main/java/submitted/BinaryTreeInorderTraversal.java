package submitted;

import leetcode.TreeTrie.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode.com/submissions/detail/188915635/
 * Push all left sie nodes to stack, pop form stack and if the node has right nodes,
 * push all left nodes of it to the stack
 */
public class BinaryTreeInorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        while (root != null) {
            stack.push(root);
            root = root.left;
        }

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            result.add(node.val);
            if (node.right != null) {
                TreeNode temp = node.right;
                while (temp != null) {
                    stack.push(temp);
                    temp = temp.left;
                }
            }
        }

        return result;
    }

    // Recursive
    public static List<Integer> inorderTraversal_rec(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        helper(res, root);
        return res;
    }

    public static void helper(List<Integer> res, TreeNode root) {
        if (root == null) return;
        helper(res, root.left);
        res.add(root.val);
        helper(res, root.right);
    }

}
