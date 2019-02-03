package submitted;

import java.util.LinkedList;
import java.util.Queue;

public class ConnectNodesAtSameLevelBT {
    static class Node {
        int data;
        Node left, right, nextRight;

        Node(int item) {
            data = item;
            left = right = nextRight = null;
        }
    }


    public static void main(String[] args) {
        Node rootNode = null;

        rootNode = addNode(rootNode, 10, true);
        rootNode = addNode(rootNode, 5, true);
        rootNode = addNode(rootNode, 2, true);

        rootNode = addNode(rootNode, 30, true);
        rootNode = addNode(rootNode, 40, true);

        linkNodesAtSameLevelWithExtraSpace(rootNode);
        System.out.println(rootNode);
    }

    private static void linkNodesAtSameLevelWithExtraSpace(Node rootNode) {
        if (rootNode == null) {
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(rootNode); // Adding Level 1 in Queue
        queue.add(null);

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            if (node != null) {
                node.nextRight = queue.peek(); // setting nextRight to head of Queue.

                if (node.left != null) // adding entries in Queue for Next Level
                    queue.add(node.left);

                if (node.right != null) // adding entries in Queue for Next Level
                    queue.add(node.right);

            } else {
                // checking if queue head is null, if it is null then this is end of all levels
                // and if queue head is not null then this is end of level and adding null to
                // indicate end of level.
                if (queue.peek() != null)
                    queue.add(null);

            }
        }
    }

    private static Node addNode(Node rootNode, int i, boolean isRootNode) {
        if (rootNode == null) {
            return new Node(i);
        } else {
            if (i > rootNode.data) {
                if (isRootNode) {
                    Node nodeToAdd = addNode(rootNode.right, i, isRootNode);
                    rootNode.right = nodeToAdd;
                } else {
                    Node nodeToAdd = addNode(rootNode.left, i, isRootNode);
                    rootNode.left = nodeToAdd;
                }

            } else {
                if (isRootNode) {
                    Node nodeToAdd = addNode(rootNode.left, i, isRootNode);
                    rootNode.left = nodeToAdd;
                } else {
                    Node nodeToAdd = addNode(rootNode.right, i, isRootNode);
                    rootNode.right = nodeToAdd;
                }
            }
        }
        return rootNode;
    }
}
