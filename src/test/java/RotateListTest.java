import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RotateListTest {
    private RotateList solution;

    @Before
    public void init() {
        solution = new RotateList();
    }

    @Test
    public void test1() {
        ListNode expected = Utils.readListNode("2, 1");
        ListNode data = Utils.readListNode("1, 2");
        ListNode actual = solution.rotateRight(data, 1);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void test2() {
        ListNode expected = Utils.readListNode("2, 1");
        ListNode data = Utils.readListNode("1, 2");
        ListNode actual = solution.rotateRight(data, 3);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void test3() {
        ListNode expected = Utils.readListNode("1");
        ListNode data = Utils.readListNode("1");
        ListNode actual = solution.rotateRight(data, 1);
        Assert.assertEquals(expected, actual);
    }
}
