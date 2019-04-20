package sword.array;

import java.util.ArrayList;

/**
 * 找出所有和为S的连续正数序列
 */
public class FindContinousSequence {

    /*
     *初始化small=1，big=2;
     *small到big序列和小于sum，big++;大于sum，small++;
     *当small增加到(1+sum)/2是停止
     */
    public ArrayList<ArrayList<Integer> > FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        if(sum < 3) //不重复，最少有两个数字
            return res;
        int small = 1;
        int big = 2;
        //因为是两个数，假设small是这个
        //，big假设也是这个，和为sum+1，所以到此就可以停了，后面肯定更大
        while(small !=(sum+1)/2) {
            int cursum = SumOfList(small, big);
            if(cursum == sum) {
                for (int i = small; i <= big; i++) {
                    list.add(i);
                }
                res.add(new ArrayList<>(list));
                list.clear();//清理掉
                big++;//找到一组，继续big++，找下一组满足要求的。
            }
            else if (cursum > sum) {
                small++;
            }
            else {
                big++;
            }
        }
        return res;
    }
    //计算list内的数据的和
    public int SumOfList(int small, int big) {
        int sum = 0;
        for (int i = small; i <= big; i++) {
            sum +=i;
        }
        return sum;
    }
}
