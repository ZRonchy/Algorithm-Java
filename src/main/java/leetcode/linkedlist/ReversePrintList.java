package leetcode.linkedlist;

public class ReversePrintList {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        reversePrintList(node1);
    }

    public static void reversePrintList(ListNode head) {
        if(head == null)
            return;

        reversePrintList(head.next);
        System.out.println(head.val);
    }
}
