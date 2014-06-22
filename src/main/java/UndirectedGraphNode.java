import java.util.ArrayList;

/**
 * @author Wei Gao
 *
 */
public class UndirectedGraphNode {
  int label;
  ArrayList<UndirectedGraphNode> neighbors;

  UndirectedGraphNode(int x) {
    label = x;
    neighbors = new ArrayList<>();
  }
}
