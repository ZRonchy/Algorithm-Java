package submitted;

import leetcode.TreeTrie.TreeNode;

public  class BinaryTreeTemplate {

}

abstract class OneRootTemplate { // One Tree
    Object solve(TreeNode root) {
        if (root == null) {
            return null; // return 0 or null or ...
        }

        if (f(root)) {
            return new Object(); // if root satisfy constraint
        }

        Object l = solve(root.left);
        Object r = solve(root.right);
        return g(root, l, r); // compare root and its children
    }

    abstract boolean f(TreeNode root);
    abstract Object g(TreeNode root, Object l, Object r);
}

abstract class TwoRootsTemplate {
    Object solve(TreeNode p, TreeNode q) {
        if (p == null || q == null) {
            return null; // return 0 or null or ...
        }

        if (f(p, q)) {
            return new Object(); // if roots satisfy constraints
        }

        Object c1 = solve(p.left, q.left); // could be p.left, q.right ot any combination
        Object c2 = solve(p.right, q.right); // could be p.left, q.right ot any combination
        return g(p, q, c1, c2); // compare roots and their children
    }

    abstract boolean f(TreeNode p, TreeNode q);
    abstract Object g(TreeNode p, TreeNode q, Object l, Object r);
}