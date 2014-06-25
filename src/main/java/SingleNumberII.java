/**
 * <p>
 * Given an array of integers, every element appears three times except for one.
 * Find that single one.
 * </p>
 * 
 * <p>
 * <b>Note:</b><br />
 * Your algorithm should have a linear runtime complexity. Could you implement
 * it without using extra memory?
 * </p>
 * 
 * @see <a href="https://oj.leetcode.com/submissions/detail/4277041/">Leetcode
 *      Single Number II Problem</a>
 * @author Wei Gao
 */
public class SingleNumberII {
    public int singleNumber(int[] A) {
        int ones = 0, twos = 0, threes = 0;
        for (int a : A) {
            /**
             * The expression "one & A[i]" gives the bits that are ther ein both
             * "ones" and new element from A. We add these bits to "twos" using
             * bitwise OR.
             */
            twos |= ones & a;
            /**
             * XOR the new bits with previous "ones" to get all bits appearing
             * odd number of times
             */
            ones ^= a;
            /**
             * "threes" bits appear in both "ones" and "twos"
             */
            threes = ones & twos;
            /**
             * Appear in "threes" should be removed from "ones" and "twos"
             */
            ones &= ~threes;
            twos &= ~threes;
        }
        return ones;
    }
}
