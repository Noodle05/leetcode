import java.util.Arrays;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MergeKSortedListsTest {
    private MergeKSortedLists solution;

    @Before
    public void init() {
        solution = new MergeKSortedLists();
    }

    @Test
    public void test1() {
        ListNode expected = Utils.readListNode("1,1,1,2,2,2");
        ListNode list1 = Utils.readListNode("1,2,2");
        ListNode list2 = Utils.readListNode("1,1,2");
        ListNode actual = solution.mergeKLists(Arrays.asList(list1, list2));
        Assert.assertEquals(expected, actual);
    }
}
