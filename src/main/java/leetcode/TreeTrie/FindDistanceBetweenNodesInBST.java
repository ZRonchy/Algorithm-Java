package leetcode.TreeTrie;

public class FindDistanceBetweenNodesInBST {
    public static int bstDistance(int[] values, int n, int node1, int node2) {
        if (n == 0 || n == 1) {
            return -1;
        }

        BinaryTreeNode root = new BinaryTreeNode(values[0]);

        for (int i=1; i<n; i++) {
            root.addNode(values[i]);
        }

        if (!findKey(node1, root) || !findKey(node2, root)) {
            return -1;
        }

        int x = pathlength(root, node1) - 1;
        int y = pathlength(root, node2) - 1;
        int lcaData = findLCA(root, node1, node2).data;
        int lcaDistance = pathlength(root, lcaData) - 1;
        return (x + y) - 2 * lcaDistance;
    }

    public static void main(String[] args) {
        int[] values = {9, 7, 10, 14, 8, 5, 2, 1};
        System.out.println(bstDistance(values, 8,8, 10));
    }

    public static boolean findKey(int k, BinaryTreeNode node) {
        if (node == null) {
            return false;
        } else if (node.data == k) {
            return true;
        } else if (node.data < k) {
            return findKey(k, node.right);
        } else {
            return findKey(k, node.left);
        }
    }

    public static int pathlength(BinaryTreeNode root, int n1) {
        if (root != null) {
            int x = 0;
            if ((root.data == n1) || (x = pathlength(root.left, n1)) > 0
                    || (x = pathlength(root.right, n1)) > 0) {
                return x + 1;
            }
            return 0;
        }
        return 0;
    }

    public static BinaryTreeNode findLCA(BinaryTreeNode root, int n1, int n2) {
        if (root != null) {
            if (root.data == n1 || root.data == n2) {
                return root;
            }
            BinaryTreeNode left = findLCA(root.left, n1, n2);
            BinaryTreeNode right = findLCA(root.right, n1, n2);

            if (left != null && right != null) {
                return root;
            }
            if (left != null) {
                return left;
            }
            if (right != null) {
                return right;
            }
        }
        return null;
    }
}

class BinaryTreeNode {

    public int data;
    public BinaryTreeNode left;
    public BinaryTreeNode right;

    public BinaryTreeNode(int num) {
        this.data = num;
        this.left = null;
        this.right = null;
    }

    public void addNode(int num) {
        if (num < this.data) {
            if (this.left != null) {
                this.left.addNode(num);
            } else {
                this.left = new BinaryTreeNode(num);
            }

        } else {
            if (this.right != null) {
                this.right.addNode(num);
            } else {
                this.right = new BinaryTreeNode(num);
            }

        }
    }
}