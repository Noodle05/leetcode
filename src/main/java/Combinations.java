import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p>
 * Given two integers <i>n</i> and <i>k</i>, return all possible combinations of
 * <i>k</i> numbers out of 1 ... <i>n</i>.
 * </p>
 * <p>
 * For example,<br />
 * If <i>n</i> = 4 and <i>k</i> = 2, a solution is:<br />
 * 
 * <pre>
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 * </pre>
 * 
 * </p>
 * 
 * @see <a href="https://oj.leetcode.com/problems/combinations/">Leetcode
 *      Combinations Problem</a>
 * @author Wei Gao
 */
public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        return combine(n + 1, k, 1);
    }

    private List<List<Integer>> combine(int n, int k, int m) {
        List<List<Integer>> result = new ArrayList<>();
        if (k > 1) {
            for (int i = m; i < n - k + 1; i++) {
                List<List<Integer>> t;
                t = combine(n, k - 1, i + 1);
                for (List<Integer> s : t) {
                    List<Integer> a = new ArrayList<Integer>();
                    a.add(i);
                    a.addAll(s);
                    result.add(a);
                }
            }
        } else {
            for (int i = m; i < n; i++) {
                result.add(Arrays.asList(i));
            }
        }
        return result;
    }
}
