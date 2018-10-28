package submitted;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * https://leetcode.com/submissions/detail/185747603/
 * Sort the Intervals
 */
public class MergeIntervals {
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> result = new ArrayList<>();

        if (intervals == null || intervals.size() == 0)
            return result;

        Collections.sort(intervals, (i1, i2) -> {
            if (i1.start != i2.start)
                return i1.start - i2.start;
            else
                return i1.end - i2.end;
        });

        Interval pre = intervals.get(0);
        for (int i = 0; i < intervals.size(); i++) {
            Interval curr = intervals.get(i);
            if (curr.start > pre.end) {
                result.add(pre);
                pre = curr;
            } else {
                Interval merged = new Interval(pre.start, Math.max(pre.end, curr.end));
                pre = merged;
            }
        }
        result.add(pre);

        return result;
    }
}