package submitted;
/**
 * https://leetcode.com/submissions/detail/196958208/
 * 厄拉多塞筛法，求一组质数，时间复杂度仅有O(nloglogn)
 * 1   2  3  4  5  6  7  8  9 10
 * 11 12 13 14 15 16 17 18 18 20
 */
public class CountPrimes {
    public int countPrimes(int n) {
        boolean[] notPrime = new boolean[n];
        int res = 0;
        for (int i = 2; i < n; i++) {
            // Found a prime number
            if (!notPrime[i]) {
                res++;
                for (int j = 2; i * j < n; j++) {
                    notPrime[i * j] = true;
                }
            }
        }
        return res;
    }
}
