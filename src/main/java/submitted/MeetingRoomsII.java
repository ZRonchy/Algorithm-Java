package submitted;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/submissions/detail/184365583/
 */
public class MeetingRoomsII {
    public int minMeetingRooms(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }

        int[] start = new int[intervals.length];
        int[] end = new int[intervals.length];
        int result = 0;
        for (int i=0; i<intervals.length;i++) {
            start[i] = intervals[i].start;
            end[i] = intervals[i].end;
        }

        Arrays.sort(start);
        Arrays.sort(end);
        int endPoint = 0; //end time of the meeting room
        for (int i=0; i<start.length;i++) {
            if (start[i] < end[endPoint]) {
                result++; // Need to use one more meeting room
            } else {
                endPoint++; // One meeting has ended before this start[i], reuse that room
            }
        }

        return result;
    }

    public int minMeetingRooms_PriorityQueue(Interval[] intervals) {
        if(intervals==null||intervals.length==0)
            return 0;

        Arrays.sort(intervals, (i1, i2) -> i1.start-i2.start);

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        int count=1;
        queue.offer(intervals[0].end);

        for(int i=1; i<intervals.length; i++){
            if(intervals[i].start<queue.peek()){
                count++;
            }else{
                queue.poll();
            }

            queue.offer(intervals[i].end);
        }

        return count;
    }
}
