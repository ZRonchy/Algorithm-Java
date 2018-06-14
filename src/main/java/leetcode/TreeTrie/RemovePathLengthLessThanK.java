package leetcode.TreeTrie;

/**
 * Given a Binary Tree and a number k, remove all nodes that lie only
 * on root to leaf path(s) of length smaller than k. If a node X lies
 * on multiple root-to-leaf paths and if any of the paths has path length >= k,
 * then X is not deleted from Binary Tree. In other words a node is deleted if
 * all paths going through it have lengths smaller than k.
 */
public class RemovePathLengthLessThanK {
    public static void main(String args[]) {
        BinaryTree tree = new BinaryTree();
        int k = 4;
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.left.left.left = new Node(7);
        tree.root.right.right = new Node(6);
        tree.root.right.right.left = new Node(8);
        System.out.println("The inorder traversal of original tree is : ");
        tree.printInorder(tree.root);
        Node res = tree.removeShortPathNodes(tree.root, k);
        System.out.println("");
        System.out.println("The inorder traversal of modified tree is : ");
        tree.printInorder(res);
    }
}

class BinaryTree {
    Node root;

    // Utility method that actually removes the nodes which are not
    // on the pathLen >= k. This method can change the root as well.
    Node removeShortPathNodesUtil(Node node, int level, int k) {
        //Base condition
        if (node == null) {
            return null;
        }

        // Traverse the tree in postorder fashion so that if a leaf
        // node path length is shorter than k, then that node and
        // all of its descendants till the node which are not
        // on some other path are removed.
        node.left = removeShortPathNodesUtil(node.left, level + 1, k);
        node.right = removeShortPathNodesUtil(node.right, level + 1, k);

        // If root is a leaf node and it's level is less than k then
        // remove this node.
        // This goes up and check for the ancestor nodes also for the
        // same condition till it finds a node which is a part of other
        // path(s) too.
        if (node.left == null && node.right == null && level < k)
            return null;

        // Return root;
        return node;
    }

    // Method which calls the utitlity method to remove the short path
    // nodes.
    Node removeShortPathNodes(Node node, int k) {
        int pathLen = 0;
        return removeShortPathNodesUtil(node, 1, k);
    }

    //Method to print the tree in inorder fashion.
    void printInorder(Node node) {
        if (node != null) {
            printInorder(node.left);
            System.out.print(node.data + " ");
            printInorder(node.right);
        }
    }
}

class Node {
    int data;
    Node left, right;

    public Node(int item) {
        data = item;
        left = right = null;
    }
}
