package leetcode.TreeTrie;

/**
 * Given root of binary search tree and K as input, find K-th smallest/largest element in BST.
 * For example, in the following BST, if k = 3, then output should be 10, and if k = 5,
 * then output should be 14.
 * Solution:
 * Inorder traversal of BST retrieves elements of tree in the sorted order. The inorder
 * traversal uses stack to store to be explored nodes of tree (threaded tree avoids stack
 * and recursion for traversal, see this post). The idea is to keep track of popped elements
 * which participate in the order statics. Hypothetical algorithm is provided below,
 * Time complexity: O(n) where n is total nodes in tree..
 */
public class FindKthElemInBST {
    private Node rootNode;
    private static int counter;

    public static void main(String[] args) {
        new FindKthElemInBST();
    }

    public FindKthElemInBST() {
        addNode(rootNode, 40);
        addNode(rootNode, 20);
        addNode(rootNode, 60);
        addNode(rootNode, 10);
        addNode(rootNode, 30);
        addNode(rootNode, 50);
        addNode(rootNode, 70);

        printTreeInOrder(rootNode);
        System.out.println();

        Node kthLargestNode = findKthLargestItem(rootNode, 5);
        if(kthLargestNode!=null){
            System.out.println("Kth Largest Node is :"+kthLargestNode.getData());
        }else{
            System.out.println("Kth Largest Node not found");
        }
    }

    private Node findKthSmallestItem(Node rootNode, int k) {
        if(rootNode==null){
            return null;
        }

        Node node = findKthSmallestItem(rootNode.getLeft(), k);

        //If counter is not equal to K, then only increment the counter.
        //Once counter is equal to K, it means we have found the desired smallest element and no need to increment further,
        //Take the back up of the current node as it might be the Kth smallest element we are looking for.
        if(counter != k){
            counter++;
            node = rootNode;
        }

        //This is the place where actual check is going to happen between counter and K,
        //If counter matched K, it means we found the node and no need to find further so simply return the found node.
        if(counter == k){
            return node;
        }else{
            return findKthSmallestItem(rootNode.getRight(), k);
        }
    }

    private Node findKthLargestItem(Node rootNode, int k) {
        if(rootNode==null){
            return null;
        }

        //Instead of Left to Right, we will traverse in Right to Left fashion because largest element
        //are present of Right side of Root Node.
        Node node = findKthLargestItem(rootNode.getRight(), k);

        //If counter is not equal to K, then only increment the counter.
        //Once counter is equal to K, it means we have found the desired largest element and no need to increment further,
        //Take the back up of the current node as it might be the Kth largest element we are looking for.
        if(counter != k){
            counter++;
            node = rootNode;
        }

        //This is the place where actual check is going to happen between counter and K,
        //If counter matched K, it means we found the node and no need to find further so simply return the found node.
        if(counter == k){
            return node;
        }else{
            return findKthLargestItem(rootNode.getLeft(), k);
        }
    }

    private void printTreeInOrder(Node rootNode){
        if(rootNode==null)
            return;
        printTreeInOrder(rootNode.getLeft());
        System.out.print(rootNode.getData() + " ");
        printTreeInOrder(rootNode.getRight());
    }

    private void addNode(Node rootNode, int data){
        if(rootNode==null){
            Node temp1 = new Node(data);
            this.rootNode=temp1;
        }else{
            addNodeInProperPlace(rootNode, data);
        }
    }

    private void addNodeInProperPlace(Node rootNode, int data){
        if(data>rootNode.getData()){
            if(rootNode.getRight()!=null){
                addNode(rootNode.getRight(), data);
            }else{
                Node temp1 = new Node(data);
                rootNode.setRight(temp1);
            }
        }else if(data<rootNode.getData()){
            if(rootNode.getLeft()!=null){
                addNode(rootNode.getLeft(), data);
            }else{
                Node temp1 = new Node(data);
                rootNode.setLeft(temp1);
            }
        }
    }

    class Node{

        private Node left;
        private Node right;
        private int data;

        public Node(int data){
            this.data=data;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }
    }

}

