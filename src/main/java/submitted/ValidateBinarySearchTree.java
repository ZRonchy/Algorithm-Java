package submitted;

import leetcode.TreeTrie.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/submissions/detail/190336022/
 * In order traversal could sort the binary search tree
 */
public class ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }

        List<Integer> list = new ArrayList<>();

        inOrderTraversal(root, list);

        int pre = list.get(0);
        for (int i=1; i<list.size();i++) {
            int cur = list.get(i);
            if (cur <= pre) {
                return false;
            }
            pre = cur;
        }
        return true;
    }

    void inOrderTraversal(TreeNode root, List<Integer> list) {

        if (root.left != null) {
            inOrderTraversal(root.left, list);
        }

        list.add(root.val);

        if (root.right != null) {
            inOrderTraversal(root.right, list);
        }
    }

    // recursion
    public static boolean isValidBST_rec(TreeNode root) {
        if (root == null) return true;
        return helper(root, null, null);
    }

    public static boolean helper(TreeNode root, Integer min, Integer max) {

        if (root == null) return true;
        if (min != null && root.val <= min) return false;
        if (max != null && root.val >= max) return false;

        return helper(root.left, min, root.val) && helper(root.right, root.val, max);
    }
}
