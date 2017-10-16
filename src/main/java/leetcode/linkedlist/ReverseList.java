package leetcode.linkedlist;

//

public class ReverseList {

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

        //reverseList(node1);
        System.out.println(node1);
//        System.out.println(node2.next);
//        System.out.println(node3.next);
//        System.out.println(node4.next);
//        System.out.println(node5.next);

    }

    public static ListNode reverseList(ListNode head) {
        if(head==null||head.next==null)
            return head;

        ListNode p1 = head;
        ListNode p2 = p1.next;

        head.next = null;
        while(p1!=null&& p2!=null){
            ListNode t = p2.next;
            p2.next = p1;
            p1 = p2;
            p2 = t;
        }

        return p1;
    }
}
