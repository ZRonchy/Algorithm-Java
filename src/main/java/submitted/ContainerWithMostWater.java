package submitted;

/**
 * https://leetcode.com/submissions/detail/193209542/
 * time : O(n)
 * space : O(1)
 */
public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int res = 0;
        int l = 0, r = height.length - 1;
        while (l < r) {
            // Always find the min value of height[l] and height[r], others could be ignored
            res = Math.max(res, Math.min(height[l], height[r]) * (r - l));
            if (height[l] < height[r]) {
                l++;
            } else {
                r--;
            }
        }
        return res;
    }
}
