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
}
