/**
 * <p>
 * Given an unsorted integer array, find the first missing positive integer.
 * </p>
 * 
 * <p>
 * For example,<br />
 * Given <font color="red">[1,2,0]</font> return <font color="red">3</font>,<br />
 * and <font color="red">[3,4,-1,1]</font> return <font color="red">2</font>.<br />
 * </p>
 * 
 * <p>
 * Your algorithm should run in <i>O(n)</i> time and uses constant space.
 * </p>
 * 
 * @see <a
 *      href="https://oj.leetcode.com/problems/first-missing-positive/">Leetcode
 *      First Missing Positive Problem</a>
 * @author Wei Gao
 *
 */
public class FirstMissingPositive {
    public int firstMissingPositive(int[] A) {
        for (int i = 1; i <= A.length; i++) {
            int target = A[i - 1];
            while (target > 0 && target <= A.length && target != A[target - 1]) {
                int t = A[target - 1];
                A[target - 1] = target;
                target = t;
            }
        }
        for (int i = 0; i < A.length; i++) {
            if (i != A[i] - 1) {
                return i + 1;
            }
        }
        return A.length + 1;
    }
}
