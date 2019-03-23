package submitted;

/**
 * https://leetcode.com/submissions/detail/197803814/
 */
public class FindDuplicateNumber {
    // time : O(nlogn) space : O(1)
    public int findDuplicate(int[] nums) {
        int min = 0;
        int max = nums.length - 1;
        while (min <= max) {
            int mid = (max - min) / 2 + min;
            int count = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] <= mid) {
                    count++;
                }
            }
            if (count > mid) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        // Since the duplicate alaways exists, eventually this algorithm
        // will find the duplicate when min <= max not true any more
        return min;
    }

    // time : O(n) space : O(1)
    public int findDuplicate2(int[] nums) {
        int slow = nums[0];
        int fast = nums[nums[0]];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        // slow == fast now, need to find the index in the array
        fast = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }

    /**
     *
     * 题目里写了数组里数字的范围保证在0 ~ n-1 之间，所以可以利用现有数组设置标志，当一个数字被访问过后，
     * 可以设置对应位上的数 + n，之后再遇到相同的数时，会发现对应位上的数已经大于等于n了，那么直接返回这个数即可
     */
    public int findDuplicate3( int numbers[]) {
        for ( int i= 0 ; i< numbers.length; i++) {
            int index = numbers[i];
            if (index >= numbers.length) {
                index -= numbers.length;
            }
            if (numbers[index] >= numbers.length) {
                return index;
            }
            numbers[index] = numbers[index] + numbers.length;
        }

        return -1 ;
    }
}
