import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ConvertSortedListToBinarySearchTreeTest {
    private ConvertSortedListToBinarySearchTree solution;

    @Before
    public void init() {
        solution = new ConvertSortedListToBinarySearchTree();
    }

    @Test
    public void test1() {
        ListNode node = Utils.readListNode("3, 5, 8");
        TreeNode expected = Utils.readTreeNode("5, 3, 8");
        TreeNode actual = solution.sortedListToBST(node);
        Assert.assertEquals(expected, actual);
    }
}
