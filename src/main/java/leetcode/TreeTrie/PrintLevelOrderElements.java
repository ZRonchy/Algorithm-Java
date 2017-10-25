package leetcode.TreeTrie;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class PrintLevelOrderElements {

    public static void main(String[] args) {
        int[] values = {9, 7, 10, 14, 8, 5, 2, 1};

        BinaryTreeNode root = new BinaryTreeNode(values[0]);
        for (int i=1; i<values.length-1; i++) {
            root.addNode(values[i]);
        }

        List<List<BinaryTreeNode>> results = printTreeByLevelOrder(root);
        for(List<BinaryTreeNode> result : results) {
            for (BinaryTreeNode e: result) {
                System.out.print(e.data + " ");
            }
            System.out.println("");
        }
    }


    static int getLevelUtil(BinaryTreeNode root, int data, int level) {
        if (root == null)
            return 0;

        if (root.data == data)
            return level;

        int downlevel = getLevelUtil(root.left, data, level + 1);
        if (downlevel != 0)
            return downlevel;

        downlevel = getLevelUtil(root.right, data, level + 1);
        return downlevel;
    }

    static int getLevel(BinaryTreeNode root, int data) {
        return getLevelUtil(root, data, 1);
    }

    static List<List<BinaryTreeNode>> printTreeByLevelOrder(BinaryTreeNode root) {
        Map<Integer, List<BinaryTreeNode>> map = new TreeMap<>();
        if (root == null) {
            return new ArrayList<>();
        }

        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()) {
            BinaryTreeNode node = queue.poll();
            int index = getLevel(root, node.data);
            List<BinaryTreeNode> list = map.getOrDefault(index, new ArrayList<>());
            list.add(node);
            map.put(index, list);

            if (node.left != null) {
                queue.add(node.left);
            }

            if (node.right != null) {
                queue.add(node.right);
            }
        }

        List<List<BinaryTreeNode>> results = new ArrayList<>(map.size());
        map.forEach((k, v) -> results.add(v));
        return results;
    }
}