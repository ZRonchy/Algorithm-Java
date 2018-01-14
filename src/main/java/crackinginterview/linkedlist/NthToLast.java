package crackinginterview.linkedlist;

public class NthToLast {
    LinkedListNode nthToLast(LinkedListNode head, int n) {
        if (head == null || n < 1) {
            return null;
        }
        LinkedListNode p1 = head;
        LinkedListNode p2 = head;
        for (int j = 0; j < n - 1; ++j) { // skip n-1 steps ahead
            if (p2 == null) {
                return null; // not found since list size < n
            }
            p2 = p2.next;
        }
        while (p2.next != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;
    }
}
