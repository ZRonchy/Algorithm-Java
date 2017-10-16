package TreeTrieHeap;

// Recursive Java program for level order traversal of Binary Tree

/* Class containing left and right child of current
node and key value*/
class Node {
    int data;
    Node left, right;
    public Node(int item)
    {
        data = item;
        left = right = null;
    }
}

class BinaryTree {
    // Root of the Binary Tree
    Node root;

    public BinaryTree() {
        root = null;
    }

    /* function to print level order traversal of tree*/
    void printLevelOrder() {
        int h = height(root);
        System.out.println("---"+h);
        int i;
        for (i=1; i<=h; i++) {
            printGivenLevel(root, i);
        }
    }

    /* Compute the "height" of a tree -- the number of
    nodes along the longest path from the root node
    down to the farthest leaf node.*/
    int height(Node node) {

        if (node == null) {
            return 0;
        } else {
            System.out.println("!-"+node.data);
			/* compute height of each subtree */
            int lheight = height(node.left);
            System.out.println("computed left of "+node.data+", height "+lheight);
            int rheight = height(node.right);
            System.out.println("computed right of "+node.data+", height "+rheight);

			/* use the larger one */
            if (lheight > rheight)
                return(lheight+1);
            else return(rheight+1);
        }
    }

    /* Print nodes at the given level */
    void printGivenLevel (Node root, int level) {
        if (root == null)
            return;
        if (level == 1)
            System.out.print(root.data + " ");
        else if (level > 1) {
            printGivenLevel(root.left, level-1);
            printGivenLevel(root.right, level-1);
        }
    }

    int minimumDepth(Node root) {
        if (root == null) {
            return 0;
        }

        // Base case : Leaf Node. This accounts for height = 1.
        if (root.left == null && root.right == null) {
            return 1;
        }

        if (root.left == null) {
            return minimumDepth(root.right) + 1;
        }

        if (root.right == null) {
            return minimumDepth(root.left) + 1;
        }

        return Math.min(minimumDepth(root.left), minimumDepth(root.right)) + 1;
    }

    int minimumDepth() {
        return minimumDepth(root);
    }

    /* Driver program to test above functions */
    public static void main(String args[]) {
        BinaryTree tree = new BinaryTree();
        tree.root= new Node(1);
        tree.root.left= new Node(2);
        tree.root.right= new Node(3);
        tree.root.left.left= new Node(4);
        tree.root.left.right= new Node(5);

        System.out.println("Level order traversal of binary tree is ");
        tree.printLevelOrder();
    }
}
