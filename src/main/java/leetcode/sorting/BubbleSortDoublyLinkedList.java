package leetcode.sorting;

public class BubbleSortDoublyLinkedList {
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

    void bubbleSort(Node head) {
        boolean swapped;
        Node ptr1;
        Node lptr = null;

        /* Checking for empty list */
        if (head == null)
            return;

        do {
            swapped = false;
            ptr1 = head;

            while (ptr1.next != lptr) {
                if (ptr1.data > ptr1.next.data) {
                    swap(ptr1, ptr1.next);
                    swapped = true;
                }
                ptr1 = ptr1.next;
            }
            lptr = ptr1;
        }
        while (swapped);
    }

    private void swap(Node node1, Node node2) {
        int temp = node1.data;
        node1.data = node2.data;
        node2.data = temp;
    }

    public void bubbleSortDoublyLinkedList(Node node) {
        bubbleSort(node);
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

        // if head is null, head = new_Node
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
        BubbleSortDoublyLinkedList list = new BubbleSortDoublyLinkedList();

        list.push(5);
        list.push(20);
        list.push(4);
        list.push(3);
        list.push(30);

        System.out.println("Linked List before sorting");
        list.printList(list.head);
        System.out.println("Linked List after sorting");
        list.bubbleSortDoublyLinkedList(list.head);
        list.printList(list.head);
    }
}
