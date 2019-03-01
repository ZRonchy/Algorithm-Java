package submitted;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/submissions/detail/211392981/
 * time: O(n * logn)
 * space: O(n)
 */
public class TheSkylineProblem {
    public List<int[]> getSkyline(int[][] buildings) {
        PriorityQueue<Integer>  heap = new PriorityQueue<>(Collections.reverseOrder());
        int n = buildings.length;
        // {x, h, id}
        ArrayList<int[]> es = new ArrayList<int[]>();

        for (int i = 0; i < n; ++i) {
            es.add(new int[]{buildings[i][0], buildings[i][2], i}); // entering the building
            es.add(new int[]{buildings[i][1], -buildings[i][2], i}); // leaving the building
        }

        // event e[0] x coordinate are the same, then process higher one firstly e[1]
        // same x entering event, process the highest first
        // same x leaving event, process the lowest first
        es.sort((e1, e2) -> e1[0] == e2[0] ? e2[1] - e1[1] : e1[0] - e2[0]);

        List<int[]> ans = new ArrayList<int[]>();

        for (int[] e : es) {
            int x = e[0];
            int h = e[1];
            int id = e[2];

            boolean entering = h > 0;
            h = Math.abs(h);

            if (entering) {
                // if entering, use the highest building
                if (heap.isEmpty() || h > heap.peek()) {
                    ans.add(new int[]{x, h});
                }
                heap.add(h);
            } else {
                // if leaving, use the second highest building
                // to remove an arbitrary object. Finding this object takes O(N) time,
                // and removing it takes O(logN) time
                heap.remove(h);
                if (heap.isEmpty()) {
                    ans.add(new int[]{x, 0});
                } else if (h > heap.peek()) {
                    ans.add(new int[]{x, heap.peek()});
                }
            }
        }

        return ans;
    }
}