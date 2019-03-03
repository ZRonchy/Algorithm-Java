package submitted;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static java.util.Arrays.asList;

public class NumberOfConnectedComponents {

    static int numberOfConnectedComponents(List<DoublyLinkedNode> nodes, DoublyLinkedNode[] refArr) {
        if (nodes.size() == 0) {
            return 0;
        }
        Set<DoublyLinkedNode> refSet = new HashSet<>();
        refSet.add(refArr[0]);
        int numberOfComponents = 1;

        for (int i = 1; i < refArr.length; i++) {
            refSet.add(refArr[i]);
            if (refArr[i].prev == null) { // head in the linkedlist
                if (!refSet.contains(refArr[i].next)) {
                    numberOfComponents++;
                }
            } else if (refArr[i].next == null) { // tail in the linkedlist
                if (!refSet.contains(refArr[i].prev)) {
                    numberOfComponents++;
                }
            } else if (refSet.contains(refArr[i].prev) && refSet.contains(refArr[i].next)) {
                numberOfComponents--;
            } else if (!refSet.contains(refArr[i].prev) && !refSet.contains(refArr[i].next)) {
                numberOfComponents++;
            }


        }
        return numberOfComponents;
    }

    public static void main(String[] args) {
        DoublyLinkedNode n1 = new DoublyLinkedNode(5);
        DoublyLinkedNode n2 = new DoublyLinkedNode(2);
        DoublyLinkedNode n3 = new DoublyLinkedNode(10);
        DoublyLinkedNode n4 = new DoublyLinkedNode(1);
        DoublyLinkedNode n5 = new DoublyLinkedNode(3);
        n1.next = n2;
        n2.prev = n1;
        n2.next = n3;
        n3.prev = n2;
        n3.next = n4;
        n4.prev = n3;
        n4.next = n5;
        n5.prev = n4;
        List<DoublyLinkedNode> nodes = asList(n1, n2, n3, n4, n5);
        DoublyLinkedNode[] refArr = {n1, n3, n5, n4};
        System.out.println(numberOfConnectedComponents(nodes, refArr));
    }
}

class DoublyLinkedNode {
    DoublyLinkedNode prev;
    DoublyLinkedNode next;
    int val;

    DoublyLinkedNode(int val) {
        this.val = val;
    }
}