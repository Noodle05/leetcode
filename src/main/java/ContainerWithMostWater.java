/**
 * <p>
 * Given n non-negative integers a1, a2, ..., an, where each represents a point
 * at coordinate (i, ai). n vertical lines are drawn such that the two endpoints
 * of line i is at (i, ai) and (i, 0). Find two lines, which together with
 * x-axis forms a container, such that the container contains the most water.
 * </p>
 * 
 * <p>
 * Note: You may not slant the container.
 * </p>
 * 
 * @see <a
 *      href="https://oj.leetcode.com/problems/container-with-most-water/">Leetcode
 *      Container With Most Water Problem</a>
 * @author Wei Gao
 */
public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int len = height.length, low = 0, high = len - 1;
        int maxArea = 0;
        while (low < high) {
            maxArea = Math.max(maxArea,
                    (high - low) * Math.min(height[low], height[high]));
            if (height[low] < height[high]) {
                low++;
            } else {
                high--;
            }
        }
        return maxArea;
    }
}
