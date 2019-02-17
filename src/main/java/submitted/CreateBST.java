package submitted;

public class CreateBST {
}

class BSTNode {
    int val;
    BSTNode left;
    BSTNode right;

    public BSTNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }

    BSTNode createBST(int[] nums) {
        BSTNode root = null;
        for (int i = 0; i < nums.length; i++) {
            root = insert(root, nums[i]);
        }
        return root;
    }

    BSTNode insert(BSTNode root, int val) {
        if (root == null) {
            return new BSTNode(val);
        }

        if (val <= root.val) {
            root.left = insert(root.left, val);
        } else {
            root.right = insert(root.right, val);
        }

        return root;
    }

    void inorder(BSTNode root) {
        if (root == null) {
            return;
        }

        inorder(root.left);
        System.out.println(root.val);
        inorder(root.right);
    }
}