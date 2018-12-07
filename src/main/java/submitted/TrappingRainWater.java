package submitted;

/**
 * https://leetcode.com/submissions/detail/193764076/
 * time : O(n)
 * space : O(1)
 */
public class TrappingRainWater {
    public int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int res = 0;
        int leftMax = 0;
        int rightMax = 0;
        while (left < right) {
            // We could only decide whether the smaller unit could hold more water
            // for example, if height[left] < height[right], we know for sure that
            // the left side could trap at least leftMax - height[left] size of water
            // as the height[right] will guarantee this
            if (height[left] < height[right]) {
                leftMax = Math.max(height[left], leftMax);
                res += leftMax - height[left];
                left++;
            } else {
                rightMax = Math.max(height[right], rightMax);
                res += rightMax - height[right];
                right--;
            }
        }
        return res;
    }
}
