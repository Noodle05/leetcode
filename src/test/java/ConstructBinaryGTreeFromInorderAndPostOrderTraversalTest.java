import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ConstructBinaryGTreeFromInorderAndPostOrderTraversalTest {
    private ConstructBinaryGTreeFromInorderAndPostOrderTraversal solution;

    @Before
    public void init() {
        solution = new ConstructBinaryGTreeFromInorderAndPostOrderTraversal();
    }

    @Test
    public void test1() {
        int[] inorder = new int[] { 1, 2, 3 };
        int[] postorder = new int[] { 3, 2, 1 };
        TreeNode root = solution.buildTree(inorder, postorder);
        TreeNode expect = Utils.readTreeNode("1,#,2,#,3");
        Assert.assertEquals(expect, root);
    }
    
    @Test
    public void test2() {
        int[] inorder = new int[] { 1, 2, 3, 4, 5 };
        int[] postorder = new int[] { 3, 4, 5, 2, 1 };
        TreeNode root = solution.buildTree(inorder, postorder);
        TreeNode expect = Utils.readTreeNode("1, #, 2, #, 5, 4, #, 3");
        Assert.assertEquals(expect, root);
    }
}
