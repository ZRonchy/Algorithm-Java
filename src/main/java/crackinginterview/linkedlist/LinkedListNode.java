package crackinginterview.linkedlist;

public class LinkedListNode {
    int data;
    LinkedListNode next;

    LinkedListNode(int data) {
        this.data = data;
    }

    @Override
    public String toString() {
        String result = "" + data;
        while (next != null) {
            result = result + next.data;
            next = next.next;
        }
        return result;
    }
}