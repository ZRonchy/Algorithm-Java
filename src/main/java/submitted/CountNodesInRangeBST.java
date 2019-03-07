package submitted;

import leetcode.TreeTrie.TreeNode;

// Returns count of nodes in BST in range [low, high]
public class CountNodesInRangeBST {
    int getCount(TreeNode node, int low, int high) {
        // Base Case
        if (node == null) {
            return 0;
        }

        if (node.val >= low && node.val <= high) {
            return 1 + this.getCount(node.left, low, high) +
                    this.getCount(node.right, low, high);
        } else if (node.val < low) {
            return this.getCount(node.right, low, high);
        } else {
            return this.getCount(node.left, low, high);
        }
    }
}
