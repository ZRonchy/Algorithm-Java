package submitted;

import leetcode.TreeTrie.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/submissions/detail/208603637/
 */
public class MinimumDepthOfBinaryTree {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        //If node has one child, the returned value is the non-null child
        if (root.left == null || root.right == null) {
            return Math.max(minDepth(root.left), minDepth(root.right)) + 1;
        }
        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }

    public int minDepth1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int depth = 0;
        while (!queue.isEmpty()) {
            depth = depth + 1;
            int size = queue.size();
            while (size > 0) {
                root = queue.poll();
                if (root.left != null) {
                    queue.add(root.left);
                }
                if (root.right != null) {
                    queue.add(root.right);
                }
                if (root.left == null && root.right == null) {
                    queue.clear();
                    break;
                }
                size--;
            }

        }
        return depth;
    }
}
