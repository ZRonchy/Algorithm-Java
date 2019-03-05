package submitted;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/submissions/detail/191452564/
 */
public class MergeKSortedList {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

//        PriorityQueue<ListNode> heap = new PriorityQueue<>((a,b) -> a.val-b.val);
        PriorityQueue<ListNode> heap = new PriorityQueue<>(Comparator.comparingInt(a -> a.val));
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;

        for (ListNode list : lists) {
            if (list != null) {
                heap.offer(list);
            }
        }
        while (!heap.isEmpty()) {
            cur.next = heap.poll();
            cur = cur.next;
            if (cur.next != null) {
                heap.add(cur.next);
            }
        }
        return dummy.next;
    }

    public ListNode mergeKLists1(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        return sort(lists, 0, lists.length - 1);
    }

    public ListNode sort(ListNode[] lists, int lo, int hi) {
        if (lo >= hi) return lists[lo];
        int mid = (hi - lo) / 2 + lo;
        ListNode l1 = sort(lists, lo, mid);
        ListNode l2 = sort(lists, mid + 1, hi);
        return merge(l1, l2);
    }

    public ListNode merge(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.val < l2.val) {
            l1.next = merge(l1.next, l2);
            return l1;
        }
        l2.next = merge(l1, l2.next);
        return l2;
    }
}
