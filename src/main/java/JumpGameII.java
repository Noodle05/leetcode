/**
 * <p>
 * Given an array of non-negative integers, you are initially positioned at the
 * first index of the array.
 * </p>
 * 
 * <p>
 * Each element in the array represents your maximum jump length at that
 * position.
 * </p>
 * 
 * <p>
 * Your goal is to reach the last index in the minimum number of jumps.
 * </p>
 * 
 * <p>
 * For example: Given array A = [2,3,1,1,4]
 * 
 * The minimum number of jumps to reach the last index is 2. (Jump 1 step from
 * index 0 to 1, then 3 steps to the last index.)
 * </p>
 * 
 * @see <a href="https://oj.leetcode.com/problems/jump-game-ii/">Letcode Jump
 *      Game II Problem</a>
 * @author Wei Gao
 */
public class JumpGameII {
    /**
     * We use "last" to keep track of the maximum distance that has been reached
     * by using the minimum steps "ret", whereas "curr" is the maximum distance
     * that can be reached by using "ret+1" steps. Thus, curr = max(i+A[i])
     * where 0 <= i <= last.
     * 
     * @param A
     * @return
     */
    public int jump(int[] A) {
        int ret = 0;
        int last = 0;
        int curr = 0;
        for (int i = 0; i < A.length; i++) {
            if (i > last) {
                // If not last one and can't go further
                if (curr == last && last < A.length - 1) {
                    return -1;
                }
                last = curr;
                ret++;
            }
            curr = Math.max(curr, i + A[i]);
        }
        return ret;
    }
}
