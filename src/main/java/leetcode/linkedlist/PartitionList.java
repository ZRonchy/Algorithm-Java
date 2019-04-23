package leetcode.linkedlist;

// Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
// You should preserve the original relative order of the nodes in each of the two partitions.
// For example, given 1->4->3->2->5->2 and x = 3, return 1->2->2->4->3->5.
// Solution:
// Initialize first and last nodes of below three linked lists as NULL.
//        Linked list of values smaller than x.
//        Linked list of values equal to or greater than x.
// Now iterate through the original linked list. If a node’s value is less than x then append it at the end of smaller list. If
// the value is equal to or greater then x then put it at the end of greater list.
// Now concatenate the two lists.
public class PartitionList {
    public ListNode partition(ListNode head, int x) {
        if(head == null) return null;

        ListNode fakeHead1 = new ListNode(0);
        ListNode fakeHead2 = new ListNode(0);
        fakeHead1.next = head;

        ListNode p = head;
        ListNode prev = fakeHead1;
        ListNode p2 = fakeHead2;

        while(p != null){
            if(p.val < x){
                p = p.next;
                prev = prev.next;
            }else{
                p2.next = p;
                prev.next = p.next;

                p = prev.next;
                p2 = p2.next;
            }
        }

        // close the list
        p2.next = null;

        prev.next = fakeHead2.next;

        return fakeHead1.next;
    }
}