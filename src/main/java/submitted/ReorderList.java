package submitted;

/**
 * https://leetcode.com/submissions/detail/188159302/
 * time : O(n)
 * space : O(1)
 */
public class ReorderList {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;
        ListNode preMiddle = findPreMiddle(head);
        ListNode l2 = findMiddle(head);
        preMiddle.next = null;
        l2 = reverse(l2);
        ListNode l1 = head;
        merge(l1, l2);
    }
    // 1->2->3->4,  3 is the middle. 1->2->3->4->5, 3 is the middle
    private ListNode findMiddle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        if (fast != null) { // list has odd nodes

        }
        return slow;
    }

    // 1->2->3->4,  3 is the middle. 1->2->3->4->5, 3 is the middle
    private ListNode findPreMiddle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        ListNode preMiddle = head;
        while (fast != null && fast.next != null) {
            preMiddle = slow;
            fast = fast.next.next;
            slow = slow.next;
        }
        return preMiddle;
    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
        }
        return prev;
    }

    private void merge(ListNode l1, ListNode l2) {
        while (l1 != null && l2 != null) {
            ListNode n1 = l1.next;
            ListNode n2 = l2.next;
            l1.next = l2;
            if (n1 == null) break;
            l2.next = n1;
            l1 = n1;
            l2 = n2;
        }
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
