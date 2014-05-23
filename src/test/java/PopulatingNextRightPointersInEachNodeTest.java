import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PopulatingNextRightPointersInEachNodeTest {
  private PopulatingNextRightPointersInEachNode solution;

  @Before
  public void init() {
    solution = new PopulatingNextRightPointersInEachNode();
  }

  @Test
  public void test1() {
    TreeLinkNode root = Utils.readTreeLinkNode("1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15");
    solution.connect(root);
    System.out.println(root);
  }
}
