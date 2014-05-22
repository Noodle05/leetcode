/**
 * 
 */


import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

/**
 * <p>
 * Clone an undirected graph. Each node in the graph contains a <font
 * color="red">label</font> and a list of its <font
 * color="red">neighbors</font>.
 * </p>
 * 
 * <p>
 * <b>OJ's undirected graph serialization:</b><br />
 * <p>
 * Nodes are labeled uniquely.
 * </p>
 * <p>
 * We use <font color="red">#</font> as a separator for each node, and <font
 * color="red">,</font> as a separator for node label and each neighbor of the
 * node.
 * </p>
 * <p>
 * As an example, consider the serialized graph <font color="red">{</font>0<font
 * color="red">,1,2#</font>1,<font color="blue">2#</font>2<font
 * color="green">,2</font>}.
 * </p>
 * The graph has a total of three nodes, and therefore contains three parts as
 * separated by <font color="red">#</font>. </p>
 * <p>
 * <ul>
 * <li>First node is labeled as 0. Connect node 0 to both nodes <font
 * color="red">1</font> and <font color="red">2</font>.</li>
 * <li>Second node is labeled as 1. Connect node 1 to node <font
 * color="blue">2</font>.</li>
 * <li>Third node is labeled as 2. Connect node 2 to node <font
 * color="green">2</font> (itself), thus forming a self-cycle.</li>
 * </ul>
 * Visually, the graph looks like the following:
 * 
 * <pre>
 *        1
 *       / \
 *      /   \
 *     0 --- 2
 *          / \
 *          \_/
 * </pre>
 * 
 * </p>
 * 
 * @see <a href="https://oj.leetcode.com/problems/clone-graph/">Leetcode Clone
 *      Graph Problem</a>
 * @author Wei Gao
 */
public class CloneGraph {
  public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
    UndirectedGraphNode clone = null;
    if (node != null) {
      Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();

      Queue<UndirectedGraphNode> queue = new ArrayDeque<>();
      clone = new UndirectedGraphNode(node.label);
      map.put(node, clone);
      queue.add(node);
      while (!queue.isEmpty()) {
        UndirectedGraphNode n = queue.poll();
        UndirectedGraphNode c = map.get(n);
        for (UndirectedGraphNode nb : n.neighbors) {
          UndirectedGraphNode cnb = map.get(nb);
          if (cnb == null) {
            cnb = new UndirectedGraphNode(nb.label);
            map.put(nb, cnb);
            queue.add(nb);
          }
          c.neighbors.add(cnb);
        }
      }
    }
    return clone;
  }
}
