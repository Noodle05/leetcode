/**
 * <p>
 * Given <i>n</i> non-negative integers representing an elevation map where the
 * width of each bar is 1, compute how much water it is able to trap after
 * raining.
 * </p>
 * 
 * <p>
 * For example, Given <font color="red">[0,1,0,2,1,0,1,3,2,1,2,1]</font>, return
 * <font color="red">6</font>.
 * </p>
 * 
 * <p>
 * <img
 * src="http://www.leetcode.com/wp-content/uploads/2012/08/rainwatertrap.png" />
 * <br />
 * The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In
 * this case, 6 units of rain water (blue section) are being trapped. Thanks
 * Marcos for contributing this image!
 * </p>
 * 
 * @see <a href="https://oj.leetcode.com/problems/trapping-rain-water/">Leetcode
 *      Trapping Rain Water Problem</a>
 * @author Wei Gao
 */
public class TrappingRainWater {
    public int trap(int[] A) {
        if (A.length == 0) {
            return 0;
        }
        int l = 0, r = A.length - 1, block = 0, all = 0, curlevel = 0;
        while (l <= r) {
            if (Math.min(A[l], A[r]) > curlevel) {
                all += (Math.min(A[l], A[r]) - curlevel) * (r - l + 1);
                curlevel = Math.min(A[l], A[r]);
            }
            if (A[l] < A[r])
                block += A[l++];
            else
                block += A[r--];
        }
        return all - block;
    }
}
