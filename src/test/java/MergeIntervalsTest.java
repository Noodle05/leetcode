import java.util.ArrayList;
import java.util.List;

import junitx.framework.ListAssert;

import org.junit.Before;
import org.junit.Test;

public class MergeIntervalsTest {
    private MergeIntervals solution;

    @Before
    public void init() {
        solution = new MergeIntervals();
    }

    @Test
    public void test1() {
        List<Interval> expected = new ArrayList<>();
        expected.add(new Interval(1, 4));
        expected.add(new Interval(5, 6));
        List<Interval> data = new ArrayList<>();
        data.add(new Interval(1, 4));
        data.add(new Interval(5, 6));
        List<Interval> actual = solution.merge(data);
        ListAssert.assertEquals(expected, actual);
    }
}
