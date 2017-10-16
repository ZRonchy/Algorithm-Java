package leetcode.TreeTrie;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        this.val = x;
    }

    @Override
    public String toString() {
        return val + "";
    }
}