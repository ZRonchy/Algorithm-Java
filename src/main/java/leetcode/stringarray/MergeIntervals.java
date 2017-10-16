package leetcode.stringarray;
// Given a collection of intervals, merge all overlapping intervals
//  For example,
//  Given [1,3],[2,6],[8,10],[15,18],
//  return [1,6],[8,10],[15,18].

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MergeIntervals {
    public static void main(String[] args) {
        ArrayList intervalList = new ArrayList(){{
            add(new Interval(1,3));
            add(new Interval(2,6));
            add(new Interval(8,10));
            add(new Interval(15,18));
        }};

        List<Interval> mergedList = merge(intervalList);
        for(Interval interval: mergedList) {
            System.out.println(interval);
        }
    }


    public static List<Interval> merge(List<Interval> intervals) {
        List<Interval> result = new ArrayList<>();

        if(intervals==null||intervals.size()==0)
            return result;

        Collections.sort(intervals, (i1, i2) -> {
            if(i1.start!=i2.start)
                return i1.start-i2.start;
            else
                return i1.end-i2.end;
        });

        Interval pre = intervals.get(0);
        for(int i=0; i<intervals.size(); i++){
            Interval curr = intervals.get(i);
            if(curr.start>pre.end){
                result.add(pre);
                pre = curr;
            }else{
                Interval merged = new Interval(pre.start, Math.max(pre.end, curr.end));
                pre = merged;
            }
        }
        result.add(pre);

        return result;
    }
}

class Interval {
    int start, end;
    Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public String toString() {
        return "["+start+", "+end+"]";
    }
}
