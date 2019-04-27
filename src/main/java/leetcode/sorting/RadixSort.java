package leetcode.sorting;

import java.util.ArrayList;
import java.util.List;

/**
 * 思想：基数排序是通过“分配”和“收集”过程来实现排序，首先根据数字的个位的数将数字放入0-9号桶中，
 * 然后将所有桶中所盛数据按照桶号由小到大，桶中由顶至底依次重新收集串起来，得到新的元素序列。
 * 然后递归对十位、百位这些高位采用同样的方式分配收集，直到没各位都完成分配收集得到一个有序的元素序列。
 * 时间复杂度：最坏:O(d(r+n)) 最好:O(d(r+n)) 平均: O(d(r+n))
 * 空间复杂度：O(dr+n) n个记录，d个关键码，关键码的取值范围为r
 * 稳定性：稳定 基数排序基于分别排序，分别收集，所以其是稳定的排序算法。
 * https://www.cnblogs.com/skywang12345/p/3603669.html
 */
public class RadixSort {
    public void radixSort(int[] input) {
        final int RADIX = 10;
        List<Integer>[] bucket = new ArrayList[RADIX];
        for (int i = 0; i < bucket.length; i++) {
            bucket[i] = new ArrayList<Integer>();
        }

        boolean maxLength = false;
        int tmp = -1, placement = 1;
        while (!maxLength) {
            maxLength = true;
            for (Integer i : input) {
                tmp = i / placement;
                bucket[tmp % RADIX].add(i);
                // if there is one int qualified set maxLength false, otherwise reached the longest number
                if (maxLength && tmp > 0) {
                    maxLength = false;
                }
            }
            int a = 0;
            for (int b = 0; b < RADIX; b++) {
                for (Integer i : bucket[b]) {
                    input[a++] = i;
                }
                bucket[b].clear();
            }
            placement *= RADIX;
        }
    }
}
