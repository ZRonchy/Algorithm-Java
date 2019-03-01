package submitted;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/submissions/detail/211143604/
 */
public class QueueReconstructionByHeight {
    /**
     * Pick out tallest group of people and sort them in a subarray (S). Since there's no other groups of people taller than them, therefore each guy's index will be just as same as his k value.
     For 2nd tallest group (and the rest), insert each one of them into (S) by k value. So on and so forth.
     E.g.
     input: [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
     subarray after step 1: [[7,0], [7,1]]
     subarray after step 2: [[7,0], [6,1], [7,1]]
     */

    class PairComp implements Comparator<int[]> {
        public int compare(int[] p1, int[] p2){
            int compH = Integer.compare(p2[0], p1[0]);
            return compH == 0 ? Integer.compare(p1[1], p2[1]): compH;
        }
    }
    public int[][] reconstructQueue(int[][] people) {
        LinkedList<int[]> list = new LinkedList<>();
        PriorityQueue<int[]> queue = new PriorityQueue<int[]>(1, new PairComp() );
        for (int[] ppl: people){
            queue.offer(ppl);
        }
        while (!queue.isEmpty() ) {
            int[] pair = queue.poll();
            list.add(pair[1], pair);
        }
        int[][] ret = new int[people.length][];
        for (int i=0; i<list.size(); i++){
            ret[i] = list.get(i);
        }
        return ret;
    }
}
