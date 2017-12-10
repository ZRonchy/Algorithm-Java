package crackinginterview.treeandgraph;

import leetcode.TreeTrie.TreeNode;

/**
 * Write an algorithm to find the ‘next’ node (e.g., in-order successor) of a given node in a binary search tree where each node has a link to its parent.
     1. If X has a right child, then the successor must be on the right side of X (because of the order in which we visit nodes). Specifically, the left-most child must be the first node visited in that subtree.
     2. Else, we go to X’s parent (call it P).
     2.a. If X was a left child (P.left = X), then P is the successor of X
     2.b. If X was a right child (P.right = X), then we have fully visited P, so we call successor(P).
 * */
public class FindNextNode {
    public static LinkTreeNode inoderSucc(LinkTreeNode e) {
        if (e != null) {
            LinkTreeNode p;
            if (e.parent == null || e.right != null) {
                p = leftMostChild(e.right);
            } else {
                while ((p = e.parent) != null) {
                    if (p.left  == e) {
                        break;
                    }
                    e = p;
                }
            }
            return p;
        }
        return null;
    }

    public static LinkTreeNode leftMostChild(LinkTreeNode e) {
        if (e == null) {
            return null;
        }

        while (e.left != null) {
            e = e.left;
        }
        return e;
    }
}



class LinkTreeNode {
    public int val;
    public LinkTreeNode left;
    public LinkTreeNode right;
    public LinkTreeNode parent;

    public LinkTreeNode(int x) {
        this.val = x;
    }

    @Override
    public String toString() {
        return val + "";
    }
}


