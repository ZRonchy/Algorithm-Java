package submitted;

import leetcode.TreeTrie.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/submissions/detail/186442545/
 */
public class SerializeDeserializeTree {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "null";
        }
        String result = root.val + ",";
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left != null) {
                queue.offer(node.left);
                result = result + node.left.val+ ",";
            } else {
                result = result + "null,";
            }
            if (node.right != null) {
                result = result + node.right.val+ ",";
                queue.offer(node.right);
            } else {
                result = result + "null,";
            }
        }
        return result.substring(0, result.length() - 1);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if ("null".equals(data)) {
            return null;
        }

        String[] nodes = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int i = 1;
        while (!queue.isEmpty()) {
            Queue<TreeNode> nextQueue = new LinkedList<>();
            while (!queue.isEmpty()) {
                TreeNode temp = queue.poll();
                if (nodes[i].equals("null")) temp.left = null;
                else {
                    temp.left = new TreeNode(Integer.valueOf(nodes[i]));
                    nextQueue.offer(temp.left);
                }
                i++;
                if (nodes[i].equals("null")) temp.right = null;
                else {
                    temp.right = new TreeNode(Integer.valueOf(nodes[i]));
                    nextQueue.offer(temp.right);
                }
                i++;
            }
            queue = nextQueue;
        }
        return root;
    }
}
