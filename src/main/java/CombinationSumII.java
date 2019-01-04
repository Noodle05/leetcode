import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p>
 * Given a collection of candidate numbers (<b><i>C</i></b>) and a target number
 * (<b><i>T</i></b>), find all unique combinations in <b><i>C</i></b> where the
 * candidate numbers sums to <b><i>T</i></b>.
 * </p>
 * 
 * <p>
 * Each number in <b><i>C</i></b> may only be used <b>once</b> in the
 * combination.
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
 * For example, given candidate set <font color="red">10,1,2,7,6,1,5</font> and
 * target <font color="red">8</font>,<br />
 * A solution set is:<br />
 * <font color="red">[1, 7]</font><br />
 * <font color="red">[1, 2, 5]</font><br />
 * <font color="red">[2, 6]</font><br />
 * <font color="red">[1, 1, 6]</font>
 * </p>
 * 
 * @see <a href="https://oj.leetcode.com/problems/combination-sum-ii/">Leetcode
 *      Combination Sum II Problem</a>
 * @author Wei Gao
 */
public class CombinationSumII {
    public List<List<Integer>> combinationSum2(int[] num, int target) {
        Arrays.sort(num);
        List<List<Integer>> result = new ArrayList<>();
        combinationSum2(new ArrayList<>(), target, num, 0, result);
        return result;
    }

    private void combinationSum2(List<Integer> list, int target, int[] num,
            int offset, List<List<Integer>> result) {
        if (target == 0) {
            result.add(list);
            return;
        }
        int i = offset;
        while (i < num.length) {
            int newTarget = target - num[i];
            int j = i + 1;
            if (newTarget >= 0) {
                List<Integer> copy = new ArrayList<>(list);
                copy.add(num[i]);
                combinationSum2(copy, newTarget, num, j, result);
            }
            while (j < num.length && (num[j] == num[i])) {
                j ++;
            }
            i = j;
        }
    }
}
