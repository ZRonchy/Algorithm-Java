package leetcode.TreeTrie;

/**
 * https://www.geeksforgeeks.org/reverse-alternate-levels-binary-tree/
 * Given a Perfect Binary Tree, reverse the alternate level nodes of the binary tree.
 */
public class ReverseAlternateLevelsOfPerfectBS {
    public static void main(String args[]) {
        BTBinaryTree tree = new BTBinaryTree();
        tree.root = new BSNode('a');
        tree.root.left = new BSNode('b');
        tree.root.right = new BSNode('c');
        tree.root.left.left = new BSNode('d');
        tree.root.left.right = new BSNode('e');
        tree.root.right.left = new BSNode('f');
        tree.root.right.right = new BSNode('g');
        tree.root.left.left.left = new BSNode('h');
        tree.root.left.left.right = new BSNode('i');
        tree.root.left.right.left = new BSNode('j');
        tree.root.left.right.right = new BSNode('k');
        tree.root.right.left.left = new BSNode('l');
        tree.root.right.left.right = new BSNode('m');
        tree.root.right.right.left = new BSNode('n');
        tree.root.right.right.right = new BSNode('o');
        System.out.println("Inorder Traversal of given tree");
        tree.printInorder();

        tree.reverseAlternate();
        System.out.println("");
        System.out.println("");
        System.out.println("Inorder Traversal of modified tree");
        tree.printInorder();
    }
}

class BSNode {
    char data;
    BSNode left, right;

    BSNode(char item) {
        data = item;
        left = right = null;
    }
}

// class to access index value by reference
class Index {
    int index;
}

class BTBinaryTree {
    BSNode root;
    Index indexObj = new Index();

    // function to store alternate levels in a tree
    void storeAlternate(BSNode node, char arr[], Index index, int l) {
        // base case
        if (node == null) {
            return;
        }
        // store elements of left subtree
        storeAlternate(node.left, arr, index, l + 1);

        // store this node only if level is odd
        if (l % 2 != 0) {
            arr[index.index] = node.data;
            index.index++;
        }

        storeAlternate(node.right, arr, index, l + 1);
    }

    // Function to modify Binary Tree (All odd level nodes are
    // updated by taking elements from array in inorder fashion)
    void modifyTree(BSNode node, char arr[], Index index, int l) {

        // Base case
        if (node == null) {
            return;
        }

        // Update nodes in left subtree
        modifyTree(node.left, arr, index, l + 1);

        // Update this node only if this is an odd level node
        if (l % 2 != 0) {
            node.data = arr[index.index];
            (index.index)++;
        }

        // Update nodes in right subtree
        modifyTree(node.right, arr, index, l + 1);
    }

    // A utility function to reverse an array from index
    // 0 to n-1
    void reverse(char arr[], int n) {
        int l = 0, r = n - 1;
        while (l < r) {
            char temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            l++;
            r--;
        }
    }

    void reverseAlternate() {
        reverseAlternate(root);
    }

    // The main function to reverse alternate nodes of a binary tree
    void reverseAlternate(BSNode node) {

        // Create an auxiliary array to store nodes of alternate levels
        char[] arr = new char[100];

        // First store nodes of alternate levels
        storeAlternate(node, arr, indexObj, 0);

        //indexObj.index = 0;

        // Reverse the array
        reverse(arr, indexObj.index);

        // Update tree by taking elements from array
        indexObj.index = 0;
        modifyTree(node, arr, indexObj, 0);
    }

    void printInorder() {
        printInorder(root);
    }

    // A utility function to print indorder traversal of a
    // binary tree
    void printInorder(BSNode node) {
        if (node == null) {
            return;
        }
        printInorder(node.left);
        System.out.print(node.data + " ");
        printInorder(node.right);
    }
}
