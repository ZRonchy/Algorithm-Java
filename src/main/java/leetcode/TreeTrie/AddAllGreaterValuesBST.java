package leetcode.TreeTrie;

/**
 * Given a Binary Search Tree (BST), modify it so that all greater values
 * in the given BST are added to every node. For example, consider the following BST.
 * https://www.geeksforgeeks.org/add-greater-values-every-node-given-bst/
 */
public class AddAllGreaterValuesBST {
    class Sum {
        int sum = 0;
    }

    void modifyBST(Node node) {
        Sum S = new Sum();
        this.modifyBSTUtil(node, S);
    }

    // Reverse in-order traversal
    void modifyBSTUtil(Node node, Sum S) {
        // Base Case
        if (node == null)
            return;

        // Recur for right subtree
        this.modifyBSTUtil(node.right, S);

        // Now *sum has sum of nodes in right subtree, add
        // root->data to sum and update root->data
        S.sum = S.sum + node.data;
        node.data = S.sum;

        // Recur for left subtree
        this.modifyBSTUtil(node.left, S);
    }

}
