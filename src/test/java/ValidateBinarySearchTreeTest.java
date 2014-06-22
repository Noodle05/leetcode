import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ValidateBinarySearchTreeTest {
  private ValidateBinarySearchTree solution;

  @Before
  public void init() {
    solution = new ValidateBinarySearchTree();
  }

  @Test
  public void test() {
    TreeNode root = Utils.readTreeNode("1, 1");
    assertFalse(solution.isValidBST(root));
  }
}
