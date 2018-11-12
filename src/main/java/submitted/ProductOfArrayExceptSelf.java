package submitted;

/**
 * https://leetcode.com/submissions/detail/189170644/
 * 1) Construct a temporary array left[] such that left[i]
 * contains product of all elements on left of arr[i] excluding arr[i].
 * 2) Construct another temporary array right[] such that right[i] contains
 * product of all elements on on right of arr[i] excluding arr[i].
 * 3) To get prod[], multiply left[] and right[].
 */
public class ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        // res[i] stores the product of all numbers on the left of nums[i]
        res[0] = 1;
        for (int i = 1; i < n; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }

        // right stores the product of all numbers on the right of nums[2]
        int right = 1;
        for (int i = n - 1; i >= 0; i--) {
            res[i] *= right;
            right *= nums[i];
        }
        return res;
    }
}
