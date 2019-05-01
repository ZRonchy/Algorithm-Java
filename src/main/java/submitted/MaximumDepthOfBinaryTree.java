package submitted;

import leetcode.TreeTrie.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/submissions/detail/187458183/
 */
public class MaximumDepthOfBinaryTree {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftPath = maxDepth(root.left);
        int rightPath = maxDepth(root.right);

        return Math.max(leftPath, rightPath) + 1;
    }

    public int maxDepth1(TreeNode root) {
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

                size--;
            }

        }
        return depth;
    }
}
