package submitted;

public class ReverseDoublyLinkedList {
    DoublyLinkedNode reverse(DoublyLinkedNode head) {
        DoublyLinkedNode prev = null;
        DoublyLinkedNode current = head;

        /* swap next and prev for all nodes of doubly linked list */
        while (current != null) {
            prev = current.prev;
            current.prev = current.next;
            current.next = prev;
            current = current.prev;
        }


        if (prev != null) {
            return prev.prev;
        } else {
            // Empty list or only one node
            return head;
        }
    }
}
