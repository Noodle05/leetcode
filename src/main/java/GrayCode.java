import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * The gray code is a binary numeral system where two successive values differ
 * in only one bit.
 * </p>
 * 
 * <p>
 * Given a non-negative integer n representing the total number of bits in the
 * code, print the sequence of gray code. A gray code sequence must begin with
 * 0.
 * </p>
 * 
 * <p>
 * For example, given <i>n</i> = 2, return <font color="red">[0,1,3,2]</font>.
 * Its gray code sequence is:
 * 
 * <pre>
 * 00 - 0
 * 01 - 1
 * 11 - 3
 * 10 - 2
 * </pre>
 * 
 * </p>
 * <p>
 * <b>Note:</b><br />
 * For a given <i>n</i>, a gray code sequence is not uniquely defined.<br />
 * 
 * For example, <font color="red">[0,2,3,1]</font> is also a valid gray code
 * sequence according to the above definition.<br />
 * 
 * For now, the judge is able to judge based on one instance of gray code
 * sequence. Sorry about that.
 * </p>
 * 
 * @see <a href="https://oj.leetcode.com/problems/gray-code/">Leetcode Gray Code
 *      Problem</a>
 * @author Wei Gao
 */
public class GrayCode {
    public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<>();

        int val = 0;
        result.add(val);

        grayCode(val, n - 1, result);

        return result;
    }

    private int grayCode(int val, int n, List<Integer> result) {
        if (n < 0) {
            return val;
        }
        for (int i = 0; i <= n; i++) {
            val ^= (1 << i);
            result.add(val);
            val = grayCode(val, i - 1, result);
        }
        return val;
    }
}
