package sword.array;

import java.util.ArrayList;

import static crackinginterview.moderate.SwapTwoNumbers.swap;

/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，
 * 所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 */
public class ReorderArray {
    public void reorderArray(int[] array) {
        ArrayList<Integer> oddList = new ArrayList<Integer>();
        ArrayList<Integer> evenList = new ArrayList<Integer>();
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0)
                evenList.add(array[i]);
            else
                oddList.add(array[i]);
        }
        oddList.addAll(evenList);
        int temp = 0;
        for (int i = 0; i < oddList.size(); i++) {
            array[temp] = oddList.get(i);
            temp++;
        }
    }

    // Bubble Sort is stable
    public void reorderArray1(int[] array) {
        if (array.length <= 1) {
            return;
        }
        boolean isSwap;
        for (int i = 0; i < array.length; i++) {
            isSwap = false;
            for (int j = 1; j < array.length - i; j++) {
                if (array[j - 1] % 2 == 0 && array[j] % 2 == 1) { //前偶后奇交换
                    swap(array[j - 1], array[j]);
                    isSwap = true;
                }
            }
            if (!isSwap) {
                break;
            }
        }
    }
}
