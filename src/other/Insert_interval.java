package other;

import util.Interval;

import java.util.ArrayList;
import java.util.Arrays;

public class Insert_interval {

    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        if (intervals == null || newInterval == null){
            return intervals;
        }
        ArrayList<Interval> res = new ArrayList<>();
        int insertIndex = 0;
        for (Interval interval:intervals){
            if (interval.end < newInterval.start){
                res.add(interval);
                insertIndex++;
            }else if (interval.start > newInterval.end){
                res.add(interval);
            }else {
                newInterval.start = Math.min(interval.start,newInterval.start);
                newInterval.end = Math.max(interval.end,newInterval.end);
            }
        }
        res.add(insertIndex,newInterval);
        return res;
    }

}
