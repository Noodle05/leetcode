/**
 * 
 */

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
 * Determine if you are able to reach the last index.
 * </p>
 * <p>
 * For example:<br />
 * A = <font color="red">[2,3,1,1,4]</font>, return <font
 * color="red">true</font>.<br />
 * 
 * A = <font color="red">[3,2,1,0,4]</font>, return <font
 * color="red">false</font>.
 * </p>
 * 
 * @see <a href="https://oj.leetcode.com/problems/jump-game/">Leetcode Jump Game
 *      Problem</a>
 * @author Wei Gao
 */
public class JumpGame {
  public boolean canJump(int[] A) {
    int canReach = 0;
    for (int i = 0; i < A.length && i <= canReach; i++) {
      if (i + A[i] > canReach)
        canReach = i + A[i];
      if (canReach >= A.length - 1)
        return true;
    }
    return (canReach >= A.length - 1);
  }
}
