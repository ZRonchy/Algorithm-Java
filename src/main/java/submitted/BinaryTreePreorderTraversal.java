package submitted;

import leetcode.TreeTrie.TreeNode;

import java.util.*;

/**
 * https://leetcode.com/submissions/detail/213767891/
 * A very interesting way to iteratively traverse the tree.
 * Could be easily changed to do in order and post order.
 * Deque here could be changed to stack
 */
public class BinaryTreePreorderTraversal {
    // Deque could be changed to stack.
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Deque<Guide> path = new ArrayDeque<>();
        path.addFirst(new Guide(0, root));
        while (!path.isEmpty()) {
            Guide current = path.removeFirst();
            if (current.node == null) continue;
            if (current.ope == 1) {
                result.add(current.node.val);
            } else {
                path.addFirst(new Guide(0, current.node.right));
                path.addFirst(new Guide(0, current.node.left));
                path.addFirst(new Guide(1, current.node));
            }
        }
        return result;
    }

    private class Guide {
        int ope; // 0, visit; 1, print
        TreeNode node;

        public Guide(int ope, TreeNode node) {
            this.ope = ope;
            this.node = node;
        }
    }

    // Iterative
    public static List<Integer> preorderTraversal_iterative(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            if (cur.right != null) stack.push(cur.right);
            if (cur.left != null) stack.push(cur.left);
            res.add(cur.val);
        }
        return res;
    }

    // Recursive
    public static List<Integer> preorderTraversal_rec(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        helper(res, root);
        return res;
    }

    public static void helper(List<Integer> res, TreeNode root) {
        if (root == null) return;
        res.add(root.val);
        helper(res, root.left);
        helper(res, root.right);
    }
}
