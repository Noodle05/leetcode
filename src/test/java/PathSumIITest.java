import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import junitx.framework.ListAssert;

import org.junit.Before;
import org.junit.Test;

public class PathSumIITest {
    private PathSumII solution;

    @Before
    public void init() {
        solution = new PathSumII();
    }

    @Test
    public void test1() {
        TreeNode root = Utils.readTreeNode("5,4,8,11,#,13,4,7,2,#,#,5,1");
        List<List<Integer>> expected = new ArrayList<>(2);
        expected.add(Arrays.asList(5, 4, 11, 2));
        expected.add(Arrays.asList(5, 8, 4, 5));
        List<List<Integer>> actual = solution.pathSum(root, 22);
        ListAssert.assertEquals(expected, actual);
    }
}
