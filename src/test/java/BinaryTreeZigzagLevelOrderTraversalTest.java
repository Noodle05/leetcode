import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import junitx.framework.ListAssert;

import org.junit.Before;
import org.junit.Test;

public class BinaryTreeZigzagLevelOrderTraversalTest {
    private BinaryTreeZigzagLevelOrderTraversal solution;

    @Before
    public void init() {
        solution = new BinaryTreeZigzagLevelOrderTraversal();
    }

    @Test
    public void test1() {
        TreeNode root = Utils.readTreeNode("1,2,3,4,#,#,5");
        List<List<Integer>> expected = new ArrayList<>();
        expected.add(Arrays.asList(1));
        expected.add(Arrays.asList(3, 2));
        expected.add(Arrays.asList(4, 5));
        List<List<Integer>> actual = solution.zigzagLevelOrder(root);
        ListAssert.assertEquals(expected, actual);
    }
}
