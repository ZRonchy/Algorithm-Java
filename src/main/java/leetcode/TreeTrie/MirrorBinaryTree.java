package leetcode.TreeTrie;


class MirrorBinaryTree {
    Node root;

    void mirror() {
        root = mirror(root);
    }

    Node mirror(Node node) {
        if (node == null)
            return node;

        /* do the subtrees */
        Node left = mirror(node.left);
        Node right = mirror(node.right);

        /* swap the left and right pointers */
        node.left = right;
        node.right = left;

        return node;
    }

    void mirrorTree(Node btree) {
        if(btree == null) {
            return;
        }
        mirrorTree(btree.left);
        mirrorTree(btree.right);
        Node tmp = btree.left;
        btree.left = btree.right;
        btree.right = tmp;
    }

}
