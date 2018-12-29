package submitted;

import leetcode.TreeTrie.TreeNode;

/**
 * https://leetcode.com/submissions/detail/197829158/
 */
public class ConstructBTFromPreorderInorder {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length == 0 || inorder.length == 0) {
            return null;
        }
        return helper(0, 0, inorder.length - 1, preorder, inorder);
    }

    /**
     * First element of preorder is the root, the next node in the array is its direct left node.
     * If we find one root node in inorder array, the next node after it is its direct right node.
     * @param preStart start index of preorder array
     * @param inStart  start index of inorder array
     * @param inEnd    end index of inorder array
     * @param preorder preorder array
     * @param inorder  inorder array
     * @return root node of the tree
     */
    public TreeNode helper(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder) {
        if (preStart > preorder.length - 1 || inStart > inEnd) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preStart]);
        int inIndex = 0; // index of root in inorder array
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == root.val) {
                inIndex = i;
            }
        }
        root.left = helper(preStart + 1, inStart, inIndex - 1, preorder, inorder);
        // we could get the total number of left nodes after the root node in inorderarray
        // which is inIndex - inStart, then in preorder array, the root node is at index preStart,
        // the direct right node after its left nodes are at index preStart + inIndex - inStart + 1
        root.right = helper(preStart + inIndex - inStart + 1, inIndex + 1, inEnd, preorder, inorder);
        return root;
    }


}
