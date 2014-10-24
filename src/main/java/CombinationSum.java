import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p>
 * Given a set of candidate numbers (<b><i>C</i></b>) and a target number
 * (<b><i>T</i></b>), find all unique combinations in <b><i>C</i></b> where the
 * candidate numbers sums to <b><i>T</i></b>.
 * </p>
 * 
 * <p>
 * The <b>same</b> repeated number may be chosen from <b><i>C</i></b> unlimited
 * number of times.
 * </p>
 * 
 * <p>
 * <b>Note:</b>
 * <ul>
 * <li>All numbers (including target) will be positive integers.</li>
 * <li>Elements in a combination (<i>a<sub>1</sub></i>, <i>a<sub>2</sub></i>, …
 * , <i>a<sub>k</sub></i>) must be in non-descending order. (ie,
 * <i>a<sub>1</sub></i> ≤ <i>a<sub>2</sub></i> ≤ … ≤ <i>a<sub>k</sub></i>).</li>
 * <li>The solution set must not contain duplicate combinations.</li>
 * </ul>
 * </p>
 * <p>
 * For example, given candidate set <font color="red">2,3,6,7</font> and target
 * <font color="red">7</font>,<br />
 * A solution set is:<br />
 * <font color="red">[7]</font><br />
 * <font color="red">[2, 2, 3]</font><br />
 * </p>
 * 
 * @see <a href="https://oj.leetcode.com/problems/combination-sum/">Leetcode
 *      Combination Sum Problem</a>
 * @author Wei Gao
 */
public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        combinationSum(new ArrayList<>(), target, candidates, 0, result);
        return result;
    }

    private void combinationSum(List<Integer> list, int target,
            int[] candidates, int offset, List<List<Integer>> result) {
        if (target == 0) {
            result.add(list);
            return;
        }
        for (int i = offset; i < candidates.length; i++) {
            int newTarget = target - candidates[i];
            if (newTarget >= 0) {
                List<Integer> copy = new ArrayList<>(list);
                copy.add(candidates[i]);
                combinationSum(copy, newTarget, candidates, i, result);
            }
        }
    }
}
