package submitted;

/**
 * https://leetcode.com/submissions/detail/194782125/
 */
public class MergeTwoSortedList {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (p1 != null && p2 != null) {
            if (p1.val <= p2.val) {
                cur.next = p1;
                p1 = p1.next;
            } else {
                cur.next = p2;
                p2 = p2.next;
            }
            cur = cur.next;
        }

        if (p1 != null) {
            cur.next = p1;
        } else {
            cur.next = p2;
        }

        return dummy.next;

    }


    public ListNode mergeTwoLists_rec(ListNode l1, ListNode l2) {
        if (l2 == null) return l1;
        if (l1 == null) return l2;
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists_rec(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists_rec(l1, l2.next);
            return l2;
        }
    }
}
