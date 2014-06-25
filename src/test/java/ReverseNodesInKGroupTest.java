import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class ReverseNodesInKGroupTest {
    private ReverseNodeInKGroup solution;
    
    @Before
    public void init() {
        solution = new ReverseNodeInKGroup();
    }

    @Test
    public void test1() {
        ListNode root = Utils.readListNode("1, 2, 3");
        ListNode expect = Utils.readListNode("2, 1, 3");
        root = solution.reverseKGroup(root, 2);
        assertEquals(expect, root);
    }

    @Test
    public void test2() {
        ListNode root = Utils.readListNode("1, 2, 3, 4");
        ListNode expect = Utils.readListNode("2, 1, 4, 3");
        root = solution.reverseKGroup(root, 2);
        assertEquals(expect, root);
    }
}
