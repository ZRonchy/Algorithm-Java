package submitted;

import leetcode.TreeTrie.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * https://leetcode.com/submissions/detail/187951798/
 * A very interesting way to iteratively traverse the tree.
 * Could be easily changed to do in order and post order
 */
public class BinaryTreePreorderTraversal {
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
}
