import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * The set <font color="red">[1,2,3,…,<i>n</i>]</font> contains a total of
 * <i>n</i>! unique permutations.
 * </p>
 * 
 * <p>
 * By listing and labeling all of the permutations in order,<br />
 * We get the following sequence (ie, for <i>n</i> = 3):<br />
 * <ul>
 * <li>
 * <font color="red">"123"</font></li>
 * <li>
 * <font color="red">"132"</font></li>
 * <li>
 * <font color="red">"213"</font></li>
 * <li>
 * <font color="red">"231"</font></li>
 * <li>
 * <font color="red">"312"</font></li>
 * <li>
 * <font color="red">"321"</font></li>
 * </ul>
 * </p>
 * <p>
 * Given <i>n</i> and <i>k</i>, return the <i>k<sup>th</sup></i> permutation
 * sequence.
 * </p>
 * 
 * <p>
 * <b>Note:</b> Given <i>n</i> will be between 1 and 9 inclusive.
 * </p>
 * 
 * @see <a
 *      href="https://oj.leetcode.com/problems/permutation-sequence/">Leetcode
 *      Permutation Sequence Problem</a>
 * @author Wei Ggao
 */
public class PermutationSequence {
    public String getPermutation(int n, int k) {
        List<Integer> list = new ArrayList<>(n);
        int step = 1;
        for (int i = 1; i <= n; i++) {
            step *= i;
        }

        k = k - 1;
        for (int i = n; i > 0; i--) {
            step /= i;
            int bucket = k / step;
            k = k % step;
            list.add(bucket);
        }
        StringBuilder sb = new StringBuilder();
        List<Character> used = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            used.add((char) ('1' + i));
        }
        for (int i : list) {
            sb.append(used.remove(i));
        }
        return sb.toString();
    }
}
