import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p>
 * Given <i>numRows</i>, generate the first <i>numRows</i> of Pascal's triangle.
 * </p>
 * <p>
 * For example, given <i>numRows</i> = 5,<br />
 * Return
 * 
 * <pre>
 * [
 *      [1],
 *     [1,1],
 *    [1,2,1],
 *   [1,3,3,1],
 *  [1,4,6,4,1]
 * ]
 * </pre>
 * 
 * </p>
 * 
 * @see <a href="https://oj.leetcode.com/problems/pascals-triangle/">Leetcode
 *      Pascal's Triangle Problem</a>
 * @author weigao
 */
public class PascalsTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>(numRows);
        for (int i = 1; i <= numRows; i++) {
            if (i == 1) {
                result.add(Arrays.asList(1));
            } else if (i == 2) {
                result.add(Arrays.asList(1, 1));
            } else {
                List<Integer> tmp = new ArrayList<>(i);

                tmp.add(1);
                List<Integer> pre = result.get(i - 2);
                for (int j = 1; j < pre.size(); j++) {
                    tmp.add(pre.get(j - 1) + pre.get(j));
                }
                tmp.add(1);

                result.add(tmp);
            }
        }
        return result;
    }
}
