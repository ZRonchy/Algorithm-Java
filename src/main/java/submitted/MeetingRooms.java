package submitted;

import java.util.Arrays;
import java.util.Comparator;

/**
 * https://leetcode.com/submissions/detail/184359566/
 * https://leetcode.com/submissions/detail/184360938/
 * If a person can attend all meetings, there must not be any overlaps between any meetings.
 * After sorting the intervals, we can compare the current end and next start.
 */
public class MeetingRooms {
    public boolean canAttendMeetings(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) {
            return true;
        }

        int[] start = new int[intervals.length];
        int[] end = new int[intervals.length];

        for (int i=0; i<intervals.length;i++) {
            start[i] = intervals[i].start;
            end[i] = intervals[i].end;
        }

        Arrays.sort(start);
        Arrays.sort(end);

        for (int i=1; i<start.length;i++) {
            if (start[i] < end[i-1]) {
                return false; // next start before last end
            }
        }

        return true;
    }

    public boolean canAttendMeetings_one_sort(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) {
            return true;
        }

        Arrays.sort(intervals, Comparator.comparingInt(a -> a.start));

        for(int i=0; i<intervals.length-1; i++){
            if(intervals[i].end>intervals[i+1].start){
                return false;
            }
        }

        return true;
    }
}

class Interval {
    int start;
    int end;

    Interval() {
        start = 0;
        end = 0;
    }

    Interval(int s, int e) {
        start = s;
        end = e;
    }
}
