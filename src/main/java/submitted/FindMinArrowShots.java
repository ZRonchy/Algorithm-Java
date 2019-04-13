package submitted;

import java.util.Arrays;

/**
 * https://leetcode.com/submissions/detail/222002856/
 * For most interval related issues, use greedy solution and sort the end point
 * of the intervals. As for this problem, sort the arrays according to the end point,
 * if the next interval's start point is smaller than the previous end point, then it
 * could definitely be shot with one arrow.
 */
public class FindMinArrowShots {
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) {
            return 0;
        }
        Arrays.sort(points, (a, b) -> a[1] - b[1]);
        int arrowPos = points[0][1];
        int arrowCnt = 1;
        for (int i = 1; i < points.length; i++) {
            if (arrowPos >= points[i][0]) {
                continue;
            }
            arrowCnt++;
            arrowPos = points[i][1];
        }
        return arrowCnt;
    }
}
