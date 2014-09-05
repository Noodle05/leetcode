import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * Given an index <i>k</i>, return the <i>k<sup>th</sup></i> row of the Pascal's
 * triangle.
 * </p>
 * <p>
 * For example, given k = 3,<br />
 * Return <font color="red">[1,3,3,1]</font>.
 * </p>
 * <p>
 * <b>Note:</b><br />
 * Could you optimize your algorithm to use only O(k) extra space?
 * </p>
 * 
 * @see <a href="https://oj.leetcode.com/problems/pascals-triangle-ii/">Leetcode
 *      Pascal's Triangle II Problem</a>
 * @author Wei Gao
 */
public class PascalsTriangleII {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<>(rowIndex + 1);
        for (int i = 0; i <= rowIndex; i++) {
            result.add(1);
        }
        if (rowIndex > 1) {
            for (int i = 2; i <= rowIndex; i++) {
                for (int j = i - 1; j > 0; j--) {
                    result.set(j, result.get(j) + result.get(j - 1));
                }
            }
        }
        return result;
    }
}
