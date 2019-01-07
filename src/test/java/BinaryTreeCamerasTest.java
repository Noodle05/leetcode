import org.junit.Assert;
import org.junit.Test;

public class BinaryTreeCamerasTest {
    private final BinaryTreeCameras solution = new BinaryTreeCameras();

    @Test
    public void test1() {
        TreeNode root = Utils.readTreeNode("1,2,3,#,4,5,6,7,#,8,#,9,10,#,#,#,#,#,#,#,11");
        int actual = solution.minCameraCover(root);
        Assert.assertEquals(5, actual);
    }
}
