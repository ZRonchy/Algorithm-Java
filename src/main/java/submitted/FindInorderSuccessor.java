package submitted;

import leetcode.TreeTrie.TreeNode;

public class FindInorderSuccessor {

    // Find InorderSuccessor in Binary Search Tree
    TreeNode inOrderSuccessor(TreeNode root, TreeNode searchNode) {
        // step 1 of the above algorithm
        if (searchNode.right != null) {
            TreeNode current = searchNode.right;

            /* loop down to find the leftmost leaf */
            while (current.left != null) {
                current = current.left;
            }
            return current;
        }

        TreeNode succ = null;

        // Start from root and search for successor down the tree
        while (root != null) {
            if (searchNode.val < root.val) {
                succ = root;
                root = root.left;
            } else if (searchNode.val > root.val)
                root = root.right;
            else { //Found the searchNode, then return current succ
                break;
            }
        }

        return succ;
    }



    // Find InorderSuccessor in Binary Tree
    TreeNode root;
    // to change previous node
    class PreviousNode {
        TreeNode pNode;

        PreviousNode() {
            pNode = null;
        }
    }

    // function to find inorder successor of
    // a node
    private void inOrderSuccessorOfBinaryTree(TreeNode root,
                                              PreviousNode pre, int searchNode) {
        // Case1: If right child is not NULL
        if (root.right != null)
            inOrderSuccessorOfBinaryTree(root.right, pre, searchNode);

        // Case2: If root data is equal to search node
        if (root.val == searchNode) {
            System.out.println("inorder successor of " + searchNode + " is: "
                    + (pre.pNode != null ? pre.pNode.val : "null"));
        }
        pre.pNode = root;

        if (root.left != null) {
            inOrderSuccessorOfBinaryTree(root.left, pre, searchNode);
        }
    }
}
