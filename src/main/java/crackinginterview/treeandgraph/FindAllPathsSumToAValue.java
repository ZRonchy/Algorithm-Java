package crackinginterview.treeandgraph;


import crackinginterview.TreeNode;

import java.util.ArrayList;

import static jdk.nashorn.internal.objects.Global.print;

/**
 * You are given a binary tree in which each node contains a value.
 * Design an algorithm to print all paths which sum up to that value.
 * Note that it can be any path in the tree - it does not have to start at the root.
 * */
public class FindAllPathsSumToAValue {
    void findSum(TreeNode head, int sum, ArrayList<Integer> buffer, int level) {
        if (head == null) {
            return;
        }
        int tmp = sum;
        buffer.add(head.val);
        for (int i = level; i > -1; i--) {
            tmp -= buffer.get(i);
            if (tmp == 0) {
                print(buffer, i, level);
            }
        }
        ArrayList<Integer> c1 = (ArrayList<Integer>) buffer.clone();
        ArrayList<Integer> c2 = (ArrayList<Integer>) buffer.clone();
        findSum(head.left, sum, c1, level + 1);
        findSum(head.right, sum, c2, level + 1);
    }

    void print (ArrayList<Integer> buffer, int level, int i2) {
        for (int i = level; i <= i2; i++) {
            System.out.print(buffer.get(i) + "");
        }
        System.out.println();
    }
}
