package leetcode.linkedlist;

/**
 * 删除链表中重复的节点，重复节点不保留
 * 例如：1 -> 2 -> 3 -> 3 -> 4
 * 删除后是 1 -> 2 -> 4
 */
public class RemoveDuplicateNodes {

    public ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null) {
            return null;
        }
        // 新建一个节点，防止头结点被删除
        ListNode firstNode = new ListNode(-1);
        firstNode.next = pHead;
        ListNode cur = pHead;
        // 指向前一个节点
        ListNode preNode = firstNode;
        while (cur != null && cur.next != null) {//注意条件的顺序，否则不对 因为如果p为null，p.next肯定异常
            if (cur.val == cur.next.val) {
                int val = cur.val;
                // 向后重复查找
                while (cur != null && cur.val == val) {
                    cur = cur.next;
                }
                // 上个非重复值指向下一个非重复值：即删除重复值
                preNode.next = cur;
            } else {
                // 如果当前节点和下一个节点值不等，则向后移动一位
                preNode = cur;
                cur = cur.next;
            }
        }
        return firstNode.next;
    }

}
