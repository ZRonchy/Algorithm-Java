package leetcode.stringarray;

/**
 *
 */
public class TrippletSubsequenceIncreasing {
    public static boolean increasingTriplet(int[] nums) {
        int x = Integer.MAX_VALUE;
        int y = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            int z = nums[i];

            if (x >= z) {
                x = z;// update x to be a smaller value
            } else if (y >= z) {
                y = z; // update y to be a smaller value
            } else {
                return true;
            }
            System.out.println(x + ", " + y + ", "+z);
        }

        return false;
    }

    public static void main(String[] args) {

//        System.out.println(increasingTriplet(new int[]{1, 2, 3, 4, 5}));
//        System.out.println(increasingTriplet(new int[]{5, 4, 3, 2, 1}));
//        System.out.println(increasingTriplet(new int[]{5, 6, 7, 8, 10}));
        System.out.println(increasingTriplet(new int[]{3, 4, 2, 1, 9}));

    }
}