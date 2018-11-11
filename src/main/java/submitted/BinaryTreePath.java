package submitted;

import leetcode.TreeTrie.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/submissions/detail/188889446/
 */
public class BinaryTreePath {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        helper(result, "", root);
        return result;
    }

    void helper(List<String> result, String path, TreeNode root) {
        if (root.left == null && root.right == null) {
            result.add(path + root.val);
        }

        String rootTemp = path + root.val;

        if (root.left != null) {
            String leftTemp = rootTemp + "->";
            helper(result, leftTemp, root.left);
        }

        if (root.right != null) {
            String rightTemp = rootTemp + "->";
            helper(result, rightTemp, root.right);
        }
    }
}
