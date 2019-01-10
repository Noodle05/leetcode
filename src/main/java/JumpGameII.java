import java.util.Arrays;

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
        int jumps = 0, curEnd = 0, curFarthest = 0;
        for (int i = 0; i < A.length - 1; i ++) {
            curFarthest = Math.max(curFarthest, i + A[i]);
            if (i == curEnd) {
                jumps ++;
                curEnd = curFarthest;
            }
        }
        return jumps;
    }

    public int jump2(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = 0;
        for (int i = 1; i < nums.length; i ++) {
            for (int j = 0; j < nums[i - 1]; j ++) {
                if ((i + j) < nums.length) {
                    if (dp[i + j] == 0) {
                        dp[i + j] = dp[i - 1] + 1;
                    } else {
                        dp[i + j] = Math.min(dp[i + j], dp[i] + 1);
                    }
                }
            }
        }
        return dp[nums.length - 1];
    }
}
