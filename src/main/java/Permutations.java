import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p>
 * Given a collection of numbers, return all possible permutations.
 * </p>
 * 
 * <p>
 * For example,<br />
 * <font color="red">[1,2,3]</font> have the following permutations:<br />
 * <font color="red">[1,2,3]</font>, <font color="red">[1,3,2]</font>, <font
 * color="red">[2,1,3]</font>, <font color="red">[2,3,1]</font>, <font
 * color="red">[3,1,2]</font>, and <font color="red">[3,2,1]</font>.
 * </p>
 * 
 * @see <a href="https://oj.leetcode.com/problems/permutations/">Leetcode
 *      Permutations Problem</a>
 * @author Wei Gao
 */
public class Permutations {
    public List<List<Integer>> permute(int[] num) {
        return permute(num, 0);
    }
    
    private List<List<Integer>> permute(int[] num, int offset) {
        List<List<Integer>> result = new ArrayList<>();
        if (offset == num.length - 1) {
            result.add(Arrays.asList(num[offset]));
        } else if (offset < num.length - 1) {
            List<List<Integer>> tt = permute(num, offset + 1);
            for (List<Integer> t : tt) {
                for (int i = 0; i <= t.size(); i ++) {
                    List<Integer> tmp = new ArrayList<>(t);
                    tmp.add(i, num[offset]);
                    result.add(tmp);
                }
            }
        }
        return result;
    }
}
