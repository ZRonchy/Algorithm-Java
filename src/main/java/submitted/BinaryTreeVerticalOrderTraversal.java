package submitted;

import leetcode.TreeTrie.TreeNode;

import java.util.*;

/**
 * https://leetcode.com/submissions/detail/186672160/
 */
public class BinaryTreeVerticalOrderTraversal {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        Map<Integer, List<Integer>> result = new TreeMap<>();

        if (root == null) {
            return new ArrayList<>();
        }

        bfs(result, root);
        return new ArrayList<>(result.values());
    }

    private void bfs(Map<Integer, List<Integer>> map, TreeNode root) {
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(root, 0));
        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            if (map.get(pair.col) == null) {
                List<Integer> list = new ArrayList<>();
                list.add(pair.node.val);
                map.put(pair.col, list);
            } else {
                map.get(pair.col).add(pair.node.val);
            }

            if(pair.node.left != null) {
                queue.offer(new Pair(pair.node.left, pair.col-1));
            }

            if (pair.node.right != null) {
                queue.offer(new Pair(pair.node.right, pair.col+1));
            }
        }
    }
}


class Pair {
    TreeNode node;
    int col;
    Pair(TreeNode node, int col) {
        this.node = node;
        this.col = col;
    }
}