import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * <p>
 * Given a set of distinct integers, <i>S</i>, return all possible subsets.
 * </p>
 * 
 * <p>
 * <b>Note:</b><br />
 * <ul>
 * <li>Elements in a subset must be in non-descending order.</li>
 * <li>The solution set must not contain duplicate subsets.</li>
 * </ul>
 * </p>
 * <p>
 * For example,<br />
 * If <i><b>S</b></i> = <font color="red">[1,2,3]</font>, a solution is:
 * 
 * <pre>
 * [
 *   [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 * </pre>
 * 
 * </p>
 * 
 * @see <a href="https://oj.leetcode.com/problems/subsets/">Leetcode Subsets
 *      Problem</a>
 * @author Wei Gao
 */
public class Subsets {
    public List<List<Integer>> subsets(int[] S) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(Collections.emptyList());

        Arrays.sort(S);
        for (int i = 0; i < S.length; i++) {
            int length = result.size();
            for (int j = 0; j < length; j++) {
                List<Integer> temp = new ArrayList<>(result.get(j));
                temp.add(S[i]);
                result.add(temp);
            }
        }
        return result;
    }
}
