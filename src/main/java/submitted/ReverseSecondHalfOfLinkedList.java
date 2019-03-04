package submitted;

public class ReverseSecondHalfOfLinkedList {
    public ListNode reverseList(ListNode head) {
        if(head == null) return null;
        //因为中间也需要变，所以要添加dummy
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = dummy;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        //找到中间的位置了slow 右侧开始反转
        ListNode pre = null;
        ListNode cur = slow.next;

        while(cur != null){
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        slow.next = pre; // pre is the new head of second half
        return head;
    }
}
