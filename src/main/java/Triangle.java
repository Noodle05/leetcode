import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * Given a triangle, find the minimum path sum from top to bottom. Each step you
 * may move to adjacent numbers on the row below.
 * </p>
 * <p>
 * For example, given the following triangle
 * 
 * <pre>
 * [
 *      [<font color="red">2</font>],
 *     [<font color="red">3</font>,4],
 *    [6,<font color="red">5</font>,7],
 *   [4,<font color="red">1</font>,8,3]
 * ]
 * </pre>
 * 
 * The minimum path sum from top to bottom is <font color="red">11</font> (i.e.,
 * <font color="red">2</font> + <font color="red">3</font> + <font
 * color="red">5</font> + <font color="red">1</font> = 11).
 * <p>
 * <p>
 * <b>Note:</b><br />
 * Bonus point if you are able to do this using only <i>O(n)</i> extra space,
 * where <i>n</i> is the total number of rows in the triangle.
 * </p>
 * 
 * @see <a href="https://oj.leetcode.com/problems/triangle/">Leetcode Triangle
 *      Problem</a>
 * @author Wei Gao
 */
public class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        List<Integer> data = new ArrayList<>(triangle.get(triangle.size() - 1));
        for (int i = triangle.size() - 2; i >= 0; i--) {
            List<Integer> row = triangle.get(i);
            for (int j = 0; j < row.size(); j++) {
                int d = Math.min(row.get(j) + data.get(j),
                        row.get(j) + data.get(j + 1));
                data.set(j, d);
            }
        }
        return data.get(0);
    }
}
