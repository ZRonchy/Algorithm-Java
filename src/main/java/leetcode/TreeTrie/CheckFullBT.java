package leetcode.TreeTrie;

/**
 * A full binary tree is defined as a binary tree in which all nodes have either zero
 * or two child nodes. Conversely, there is no node in a full binary tree, which has one child node.
 */
public class CheckFullBT {
    /*  Tree node structure */
    class Node {
        int data;
        Node left, right;

        Node(int item) {
            data = item;
            left = right = null;
        }
    }

    class BinaryTree {
        Node root;

        /* this function checks if a binary tree is full or not */
        boolean isFullTree(Node node) {
            // if empty tree
            if (node == null)
                return true;

            // if leaf node
            if (node.left == null && node.right == null) {
                return true;
            }

            // if both left and right subtrees are not null
            // the are full
            if ((node.left != null) && (node.right != null)) {
                return (isFullTree(node.left) && isFullTree(node.right));
            }

            // if none work
            return false;
        }

    }
}