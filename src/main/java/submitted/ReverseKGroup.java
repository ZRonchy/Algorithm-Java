package submitted;

/**
 * https://leetcode.com/submissions/detail/227211739/
 * time O(n)
 * space O(n)
 */
public class ReverseKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null) {
            return null;
        }

        // find the first k group and isolate it from the rest
        ListNode tempHead = head, trailer = null;
        int count = 0;
        while(head != null && count < k){
            trailer = head;
            head = head.next;
            count++;
        }
        if(head == null && count < k) {
            return tempHead;
        }
        trailer.next = null; // de-tail

        // do a normal reverse of list
        ListNode ret = reverseList(tempHead);

        // tempHead becomes the tale to which we can append the rest
        tempHead.next = reverseKGroup(head, k);

        return ret;
    }


    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }

        ListNode pre = null;

        while (head != null) {
            ListNode temp = head.next;
            head.next = pre;
            pre = head;
            head = temp;
        }

        return pre;
    }

}
