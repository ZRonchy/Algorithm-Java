package submitted;

import leetcode.TreeTrie.TreeNode;

public class FindInorderSuccessor {

    // Find InorderSuccessor in Binary Search Tree
    TreeNode inOrderSuccessor(TreeNode root, TreeNode searchNode) {
        // if has right node, successor is the leftmost node of its right child
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


    /**
     *  树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
     * 主要分三种：
     * 1.如果有右孩子，后继节点就是右节点最左边的
     * 2.如果没有右孩子，判断是否是父节点的左孩子，是的话，返回，不是继续网上找
     * 3.找不到就是null
     */
    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        if (pNode == null)
            return null;
        // 如果有右子树，则找右子树的最左节点
        if (pNode.right != null) {
            pNode = pNode.right;
            // 如果此时pNode没有左子树，那么它就是下一个结点 ，就是最左边的了
            //如果有左子树，那就在左子树找最左边的
            while (pNode.left != null)
                pNode = pNode.left;
            return pNode;

        }
        //// 非跟结点，并且没有右子树
        while (pNode.next != null) {
            // 找到一个结点是该其父亲的左孩子  ,找到就是返回父节点作为后记
            if (pNode.next.left == pNode)
                return pNode.next;
            //找不到这个左孩子的，就继续往上，next其实是parent
            pNode = pNode.next;
        }
        return null;
    }

    class TreeLinkNode {
        int val;
        TreeLinkNode left = null;
        TreeLinkNode right = null;
        TreeLinkNode next = null;
        TreeLinkNode(int val) {
            this.val = val;
        }
    }

}
