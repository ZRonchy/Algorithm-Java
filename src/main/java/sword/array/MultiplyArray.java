package sword.array;

/**
 * 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],
 * 其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法。
 */
public class MultiplyArray {
    // 新建一个新数组B， 对A数组i项左侧自上往下累乘，
    // 对A数组i项右侧自下往上累乘 时间复杂度O(n)
    public int[] multiply(int[] A) {
        // 将B拆分为A[0] *...* A[i-1]和A[n-1]*...*A[i+1] 两部分
        if (A == null || A.length == 0) {
            return A;
        }
        int length = A.length;
        int[] B = new int[length];
        B[0] = 1;
        // 先计算左下三角形，此时B[0]只有一个元素，舍为1，
        // B[0]不包括A[0]
        for (int i = 1; i < length; i++) {
            B[i] = B[i - 1] * A[i - 1];
        }
        int tmp = 1;
        //计算右上三角形
        for (int i = length - 1; i >= 0; i--) {
            //最终的B[i]是之前乘好的再乘以右边的
            B[i] *= tmp;
            tmp *= A[i];
        }

        return B;
    }

}
