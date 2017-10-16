package leetcode.linkedlist;

// Given a singly linked list, group all odd nodes together followed by the even nodes.
// Please note here we are talking about the node number and not the value in the nodes.
// The program should run in O(1) space complexity and O(nodes) time complexity.
// Given 1->2->3->4->5->NULL,
// return 1->3->5->2->4->NULL.
public class OddEvenLinkedList {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(4);
        l1.next.next.next.next = new ListNode(5);

        System.out.print(oddEvenList(l1));
    }

    public static ListNode oddEvenList(ListNode head) {
        if(head == null)
            return head;

        ListNode result = head;
        ListNode p1 = head;
        ListNode p2 = head.next;
        ListNode connectNode = head.next;

        while(p1 != null && p2 != null){
            ListNode t = p2.next;
            if(t == null)
                break;

            p1.next = p2.next;
            p1 = p1.next;

            p2.next = p1.next;
            p2 = p2.next;
        }

        p1.next = connectNode;

        return result;
    }
}