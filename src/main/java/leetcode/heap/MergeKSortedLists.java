package leetcode.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

// Merge k sorted linked lists and return it as one sorted list
public class MergeKSortedLists {
    // Time: log(k) * n.
    // k is number of list and n is number of total elements.
    public static void main(String[] args) {
        ListNode[] listNodes = new ListNode[]{
                new ListNode(0),
                new ListNode(5),
                new ListNode(3),
                new ListNode(1),
                new ListNode(2),
                new ListNode(4)};

        System.out.print(mergeKLists(listNodes));
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        if(lists==null||lists.length==0)
            return null;

        PriorityQueue<ListNode> queue = new PriorityQueue<>(new Comparator<ListNode>() {
            public int compare(ListNode l1, ListNode l2) {
                return l1.val - l2.val;
            }
        });

        ListNode head = new ListNode(0);
        ListNode p = head;

        for(ListNode list: lists){
            if(list!=null)
                queue.offer(list);
        }

        while(!queue.isEmpty()){
            ListNode n = queue.poll();
            p.next = n;
            p=p.next;

            if(n.next!=null)
                queue.offer(n.next);
        }

        return head.next;

    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        String result = ""+val;
        while (next != null) {
            result = result+next.val;
            next = next.next;
        }
        return result;
    }
}