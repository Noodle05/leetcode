/**
 * <p>
 * Find the contiguous subarray within an array (containing at least one number)
 * which has the largest sum.
 * </p>
 * 
 * <p>
 * For example, given the array <font
 * color="red">[−2,1,−3,4,−1,2,1,−5,4]</font>,<br />
 * the contiguous subarray <font color="red">[4,−1,2,1]</font> has the largest
 * sum = <font color="red">6</font>.
 * </p>
 * <p>
 * <b>More practice:</b><br />
 * If you have figured out the O(n) solution, try coding another solution using
 * the divide and conquer approach, which is more subtle.
 * </p>
 * 
 * @see <a href="https://oj.leetcode.com/problems/maximum-subarray/">Leetcode
 *      Maximum Subarray Problem</a>
 * @author Wei Gao
 */
public class MaximumSubarray {
  public int maxSubArray(int[] A) {
    int currentSum;
    int max = currentSum = A[0];
    for (int i = 1; i < A.length; i++) {
      currentSum = (currentSum < 0 ? A[i] : currentSum + A[i]);
      max = max > currentSum ? max : currentSum;
    }
    return max;
  }
}
