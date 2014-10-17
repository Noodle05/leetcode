import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * <p>
 * Given a collection of intervals, merge all overlapping intervals.
 * </p>
 * 
 * <p>
 * For example,<br />
 * Given <font color="red">[1,3],[2,6],[8,10],[15,18]</font>,<br />
 * return <font color="red">[1,6],[8,10],[15,18]</font>.
 * </p>
 * 
 * @see <a href="https://oj.leetcode.com/problems/merge-intervals/">Leetcode
 *      Merge Intervals Problem</a>
 * @author Wei Gao
 */
public class MergeIntervals {
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> result = new ArrayList<>();
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });
        Interval last = null;
        for (Interval interval : intervals) {
            if (last == null) {
                last = new Interval(interval.start, interval.end);
            } else {
                if (interval.start <= last.end) {
                    if (interval.end > last.end) {
                        last.end = interval.end;
                    }
                } else {
                    result.add(last);
                    last = new Interval(interval.start, interval.end);
                }
            }
        }
        if (last != null) {
            result.add(last);
        }
        return result;
    }
}
