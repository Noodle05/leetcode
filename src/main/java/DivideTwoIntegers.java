/**
 * <p>
 * Divide two integers without using multiplication, division and mod operator.
 * </p>
 * 
 * @see <a href="https://oj.leetcode.com/problems/divide-two-integers/">Leetcode
 *      Divide Two Integers Problem</a>
 * @author Wei Gao
 */
public class DivideTwoIntegers {
    public int divde(int dividend, int divisor) {
        boolean signA = dividend >= 0;
        boolean signB = divisor > 0;
        long num = Math.abs((long) dividend);
        long div = Math.abs((long) divisor);
        long res = 0;
        long curr = 0;

        for (int i = 31; i >= 0; i--) {
            curr <<= 1;
            curr |= ((num >> i) & 1);

            res = res << 1;
            if (curr >= div) {
                curr -= div;
                res |= 1;
            }
        }
        if (signA ^ signB) {
            return -(int) res;
        } else {
            return (int) res;
        }
    }
}
