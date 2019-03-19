package submitted;

public class IsArrayPostorderTraversal {
    /**
     * 1.后序遍历的最后一个值为root，在前面的数组中找到第一个大于root值的位置。
     * 2.这个位置的前面是root的左子树，右边是右子树。然后左右子树分别进行这个递归操作。
     * 3.其中，如果右边子树中有比root值小的直接返回false
     */
    public boolean VerifySquenceOfBST(int [] sequence) {
        if (sequence == null || sequence.length == 0)
            return false;
        return IsBST(sequence, 0, sequence.length -1);

    }

    public boolean IsBST(int [] sequence, int start, int end) {
        if(start >= end) //注意这个条件的添加, 如果对应要处理的数据只有一个或者已经没
            //有数据要处理（start>end）就返回true
            return true;
        int index = start;
        for (; index < end; index++) {//寻找大于root的第一个节点，然后再分左右两部分
            if(sequence[index] > sequence[end])
                break;
        }
        for (int i = index; i < end; i++) {//若右子树有小于根节点的值，直接返回false
            if (sequence[i] < sequence[end]) {
                return false;
            }
        }
        return IsBST(sequence, start, index-1) && IsBST(sequence, index, end-1);
    }

}
