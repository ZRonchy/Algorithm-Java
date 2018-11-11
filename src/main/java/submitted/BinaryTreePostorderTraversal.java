package submitted;

import leetcode.TreeTrie.TreeNode;

import java.util.*;

/**
 * https://leetcode.com/submissions/detail/188931729/
 * First do a reverse post-order traversal (not the same as pre-order traversal),
 * then reverse the result using Deque.
 */
public class BinaryTreePostorderTraversal {
    // Iterative
    public static List<Integer> postorderTraversal_Iterative(TreeNode root) {
        LinkedList<Integer> res = new LinkedList<>();
        if (root == null) return res;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            res.addFirst(cur.val);
            if (cur.left != null) stack.push(cur.left);
            if (cur.right != null) stack.push(cur.right);
        }
        return res;
    }

    // Recursive
    public static List<Integer> postorderTraversal_rec(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        helper(res, root);
        return res;
    }
    public static void helper(List<Integer> res, TreeNode root) {
        if (root == null) return;
        helper(res, root.left);
        helper(res, root.right);
        res.add(root.val);
    }
}
