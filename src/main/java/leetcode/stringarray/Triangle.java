package leetcode.stringarray;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a triangle, find the minimum path sum from top to bottom. Each step you may move
 * to adjacent numbers on the row below.
 * For example, given the following triangle
 * [
 * [2],
 * [3,4],
 * [6,5,7],
 * [4,1,8,3]
 * ]
 * The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
 * Note: Bonus point if you are able to do this using only O(n) extra space, where n is the total number
 * of rows in the triangle.
 * 方法复制了三角形最后一行，作为用来更新的一位数组。然后逐个遍历这个DP数组，对于每个数字，和它之后的元素
 * 比较选择较小的再加上上面一行相邻位置的元素做为新的元素，然后一层一层的向上扫描，整个过程和冒泡排序的原
 * 理差不多，最后最小的元素都冒到前面，第一个元素即为所求
 */
public class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        int row=triangle.size();    //行数
        if(row==0) return 0;

        int[] res=new int[row+1];       //倒着求，求最后一行到第一行最小和，这样就可以用o(n)空间了

        for(int i=row-1;i>=0;i--){
            List<Integer> list=triangle.get(i);
            for(int j=0;j<list.size();j++){
                res[j]=Math.min(res[j+1],res[j])+list.get(j); //最后一行的最小值就是当前数
            }
        }

        return res[0];
    }
}
