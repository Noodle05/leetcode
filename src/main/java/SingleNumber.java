/**
 * <p>
 * Given an array of integers, every element appears twice except for one. Find
 * that single one.
 * </p>
 * <p>
 * <b>Note:</b><br />
 * Your algorithm should have a linear runtime complexity. Could you implement
 * it without using extra memory?
 * </p>
 * 
 * @see <a href="https://oj.leetcode.com/problems/single-number/">Leetcode
 *      Single Number Problem</a>
 * @author Wei Gao
 */
public class SingleNumber {
    public int singleNumber(int[] A) {
        int result = 0;
        for (int a : A) {
            result ^= a;
        }
        return result;
    }
}
