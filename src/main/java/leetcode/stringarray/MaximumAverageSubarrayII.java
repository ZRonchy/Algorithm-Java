package leetcode.stringarray;

/**
 * http://bookshadow.com/weblog/2017/07/16/leetcode-maximum-average-subarray-ii/
 * Given an array consisting of n integers, find the contiguous subarray whose length is greater than
 * or equal to k that has the maximum average value. And you need to output the maximum average value.
 Example 1:
 Input: [1,12,-5,-6,50,3], k = 4
 Output: 12.75
 Explanation:
 when length is 5, maximum average value is 10.8,
 when length is 6, maximum average value is 9.16667.
 Thus return 12.75.

 Note:
 1 <= k <= n <= 10,000.
 Elements of the given array will be in range [-10,000, 10,000].
 The answer with the calculation error less than 10-5 will be accepted.

 Observation:
 A subarray of given length has maximum average if it has maximum sum.
 So we can avoid floating point arithmetic by just comparing sum.
 */
public class MaximumAverageSubarrayII {

    public double findMaxAverageBinarySearch(int[] nums, int k) {
        int n = nums.length;
        double l = Integer.MAX_VALUE, r = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            l = Math.min(l, (double) nums[i]);
            r = Math.max(r, (double) nums[i]);
        }

        double[] sumNums = new double[n + 1];
        sumNums[0] = 0;
        while (r - l > 1e-5) {
            double mid = (l + r) / 2;
            for (int i = 0; i < n; i++) {
                sumNums[i + 1] = sumNums[i] + nums[i] - mid;
            }
            double preMin = 0;
            double sumMax = Integer.MIN_VALUE;
            for (int i = k; i <= n; i++) {
                sumMax = Math.max(sumMax, sumNums[i] - preMin);
                preMin = Math.min(preMin, sumNums[i - k + 1]);
            }
            if (sumMax >= 0) {
                l = mid;
            } else {
                r = mid;
            }
        }
        return l;
    }
}