package submitted;

import leetcode.TreeTrie.TreeNode;

/**
 * https://leetcode.com/submissions/detail/197838089/
 */
public class ConstructBTFromPostorderInorder {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (postorder == null || inorder == null || postorder.length == 0 || inorder.length == 0) {
            return null;
        }
        return helper(postorder.length - 1, 0, inorder.length - 1, postorder, inorder);
    }

    /**
     *
     * @param postStart   start index of postorder array
     * @param inStart     start index of inorder array
     * @param inEnd       end index of inorder array
     * @param postorder   postorder array
     * @param inorder     inorder array
     * @return            root node of the tree
     */
    private TreeNode helper(int postStart, int inStart, int inEnd, int[] postorder, int[] inorder) {
        if (postStart < 0 || inStart > inEnd) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[postStart]);
        int inIndex = 0; // index of root in inorder array
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == root.val) {
                inIndex = i;
            }
        }

        // we could get the total number of right nodes after the root node in inorderarray
        // which is inEnd - inIndex, then in postorder array, the root node is at index postStart,
        // the direct left node before its right nodes are at index postStart - (inEnd - inIndex) - 1
        root.right = helper(postStart - 1, inIndex + 1, inEnd, postorder, inorder);
        root.left = helper(postStart - (inEnd - inIndex) - 1, inStart, inIndex - 1, postorder, inorder);
        return root;
    }
}
