package submitted;

public class ConvertBSTToDoublyLinkedList {

    /**
     * 二叉搜索树的中序遍历就是递增的排序，所以就运用中序遍历方法来做。
     * 中序遍历的步骤，只不过在递归的中间部分不是输出节点值，而是调整指针指向。
     * 10
     * /\
     * 5 12
     * /\
     * 4 7
     * 步骤记住就行，第一次执行，到4的时候，head和resulthead都指向这个
     * 指针调整的其中一步：4是head 5是pRootOfTree 然后调整head右指向5，5左指向4，然后5变成head就行了。
     */
    private class DoublyLinkedNode {
        int val;
        DoublyLinkedNode left = null;
        DoublyLinkedNode right = null;

        public DoublyLinkedNode(int val) {
            this.val = val;
        }

    }

    DoublyLinkedNode head = null;
    DoublyLinkedNode resultHead = null; //保存生成链表的头结点，便于程序返回

    public DoublyLinkedNode convert(DoublyLinkedNode pRootOfTree) {
        convertSub(pRootOfTree);
        return resultHead;
    }

    public void convertSub(DoublyLinkedNode pRootOfTree) {
        if (pRootOfTree == null)
            return;
        convertSub(pRootOfTree.left);
        if (head == null) {
            head = pRootOfTree;
            resultHead = pRootOfTree;
        } else {
            head.right = pRootOfTree;
            pRootOfTree.left = head;
            head = pRootOfTree;
        }
        convertSub(pRootOfTree.right);

    }
}

