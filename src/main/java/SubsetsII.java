import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * <p>
 * Given a collection of integers that might contain duplicates, <i>S</i>,
 * return all possible subsets.
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
 * If <i><b>S</b></i> = <font color="red">[1,2,2]</font>, a solution is:
 * 
 * <pre>
 * [
 *   [2],
 *   [1],
 *   [1,2,2],
 *   [2,2],
 *   [1,2],
 *   []
 * ]
 * </pre>
 * 
 * </p>
 * 
 * @see <a href="https://oj.leetcode.com/problems/subsets-ii/>Leetcocde Subsets
 *      II Problem</a>
 * @author Wei Gao
 */
public class SubsetsII {
    public List<List<Integer>> subsetsWithDup(int[] num) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(Collections.emptyList());
        Arrays.sort(num);
        int j, lastLength = 0;
        for (int i = 0; i < num.length; i++) {
            if (i != 0 && num[i] == num[i - 1]) {
                j = lastLength;
            } else {
                j = 0;
            }
            lastLength = result.size();
            for (; j < lastLength; j++) {
                List<Integer> temp = new ArrayList<>(result.get(j));
                temp.add(num[i]);
                result.add(temp);
            }
        }
        return result;
    }
}
