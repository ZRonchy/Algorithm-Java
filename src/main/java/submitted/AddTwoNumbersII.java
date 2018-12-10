package submitted;

import java.util.Stack;

/**
 * https://leetcode.com/submissions/detail/194260487/
 * time : O(n)
 * space : O(n)
 */
public class AddTwoNumbersII {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();

        while (l1 != null) {
            s1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            s2.push(l2.val);
            l2 = l2.next;
        }

        ListNode cur = new ListNode(0);
        int sum = 0;
        while (!s1.isEmpty() || !s2.isEmpty()) {
            if (!s1.isEmpty()) sum += s1.pop();
            if (!s2.isEmpty()) sum += s2.pop();
            cur.val = sum % 10; // 8+5=13, 13%10=3
            ListNode head = new ListNode(sum / 10); // the leading carry is 0 or 1
            head.next = cur;
            cur = head;
            sum /= 10; // 13/10=1, sum is the carry now
        }
        return cur.val == 0 ? cur.next : cur; // if leading carry is 0, return the next node
    }
}
