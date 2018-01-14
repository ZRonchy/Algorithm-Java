package crackinginterview.linkedlist;

import java.util.HashMap;
import java.util.Map;

/**
 * Write code to remove duplicates from an unsorted linked list.
 * FOLLOW UP
 * How would you solve this problem if a temporary buffer is not allowed?
 */
public class RemoveDuplicates {
    public static void deleteDupsWithBuffer(LinkedListNode n) {
        Map<Integer, Boolean> map = new HashMap<>();
        LinkedListNode previous = null;
        while (n != null) {
            if (map.containsKey(n.data)) {
                previous.next = n.next;
            } else {
                map.put(n.data, true);
                previous = n;
            }
            n = n.next;
        }
    }

    public static void deleteDups2(LinkedListNode head) {
        if (head == null) return;
        LinkedListNode previous = head;
        LinkedListNode current = previous.next;
        while (current != null) {
            LinkedListNode runner = head;
            while (runner != current) { // Check for earlier dups
                if (runner.data == current.data) {
                    LinkedListNode tmp = current.next; // remove current
                    previous.next = tmp;
                    current = tmp; // update current to next node
                    break; // all other dups have already been removed
                }
                runner = runner.next;
            }
            if (runner == current) { // current not updated - update now
                previous = current;
                current = current.next;
            }
        }
    }
}
