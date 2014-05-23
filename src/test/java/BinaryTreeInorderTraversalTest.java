import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

public class BinaryTreeInorderTraversalTest {
  private BinaryTreeInorderTraversal solution;

  @Before
  public void init() {
    solution = new BinaryTreeInorderTraversal();
  }

  @Test
  public void test1() {
    TreeNode root = Utils.readTreeNode("1, #, 2, 3");
    ArrayList<Integer> result = solution.inorderTraversal(root);
    ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(1, 3, 2));
    assertEquals(expected, result);
  }
}
