package leetcode.sorting;

public class QuickSortDoublyLinkedList {
    Node head;

    static class Node {
        private int data;
        private Node next;
        private Node prev;

        Node(int d) {
            data = d;
            next = null;
            prev = null;
        }
    }

    Node lastNode(Node node) {
        while (node.next != null) {
            node = node.next;
        }
        return node;
    }


    /* Considers last element as pivot, places the pivot element at its
       correct position in sorted array, and places all smaller (smaller than
       pivot) to left of pivot and all greater elements to right of pivot */
    Node partition(Node l, Node h) {
        // set pivot as h element
        int x = h.data;

        // similar to i = l-1 for array implementation
        Node i = l.prev;

        // Similar to "for (int j = l; j <= h- 1; j++)"
        for (Node j = l; j != h; j = j.next) {
            if (j.data <= x) {
                // Similar to i++ for array
                i = (i == null) ? l : i.next;
                int temp = i.data;
                i.data = j.data;
                j.data = temp;
            }
        }
        i = (i == null) ? l : i.next;
        int temp = i.data;
        i.data = h.data;
        h.data = temp;
        return i;
    }

    void quickSort(Node l, Node h) {
        if (h != null && l != h && l != h.next) {
            Node temp = partition(l, h);
            quickSort(l, temp.prev);
            quickSort(temp.next, h);
        }
    }

    public void quickSortDoublyLinkedList(Node node) {
        Node head = lastNode(node);
        quickSort(node, head);
    }

    public void printList(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }

    /* Function to insert a node at the beginning of the Doubly Linked List */
    void push(int newData) {
        Node newNode = new Node(newData);
        if (head == null) {
            head = newNode;
            return;
        }

        newNode.next = head;
        head.prev = newNode;
        newNode.prev = null;
        head = newNode;
    }

    public static void main(String[] args) {
        QuickSortDoublyLinkedList list = new QuickSortDoublyLinkedList();

        list.push(5);
        list.push(20);
        list.push(4);
        list.push(3);
        list.push(30);

        System.out.println("Linked List before sorting");
        list.printList(list.head);
        System.out.println("Linked List after sorting");
        list.quickSortDoublyLinkedList(list.head);
        list.printList(list.head);
    }
}
