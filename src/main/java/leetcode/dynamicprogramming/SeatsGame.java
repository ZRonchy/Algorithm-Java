package leetcode.dynamicprogramming;

/**
 * n个人n个座位，求不能坐在自己座位上种数
 *
 * 如果一共有i个人，则第i个人的位置对于其他i-1个人都是合法的，则这i-1个人都可能坐在i的位置上。
 * 1. 如果第i个人坐在坐他位置的人的位置上，则将这两个人与其他的i-2个人分开了，有f[i-2]种；
 * 2. 如果第i个人不坐在坐他位置的人的位置上，则剩下i-1个人不能坐自己的位置，则有f[i-1]种。

 * 所以递推式为：f[i]=(i-1)*(f[i-1]+f[i-2]);
 */
public class SeatsGame {

    public int seatsGame(int[] seats) {
        int[] f = new int[seats.length + 1];
        int i;
        f[1] = 0;
        f[2] = 1;
        for(i = 3; i <= seats.length; ++i) {
            f[i] = (i - 1) * (f[i - 1] + f[i -2]);
        }
        return f[seats.length];
    }
}
