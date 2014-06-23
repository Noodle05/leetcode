import java.util.Arrays;

/**
 * <p>
 * Given an array S of n integers, find three integers in S such that the sum is
 * closest to a given number, target. Return the sum of the three integers. You
 * may assume that each input would have exactly one solution.
 * </p>
 * 
 * <pre>
 *     For example, given array S = {-1 2 1 -4}, and target = 1.
 * 
 *     The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 * </pre>
 * 
 * @see <a href="https://oj.leetcode.com/problems/3sum-closest/">Leetcode 3Sum
 *      Closest Problem</a>
 * @author Wei Gao
 */
public class ThreeSumClosest {
    public int threeSumClosest(int[] num, int target) {
        if (num == null || num.length < 3) {
            return Integer.MAX_VALUE;
        }
        Arrays.sort(num);
        int closet = Integer.MAX_VALUE / 2;
        for (int i = 0; i < num.length - 2; i++) {
            int left = i + 1;
            int right = num.length - 1;
            while (left < right) {
                int sum = num[i] + num[left] + num[right];
                if (sum == target) {
                    return sum;
                } else if (sum < target) {
                    left++;
                } else {
                    right--;
                }
                closet = Math.abs(sum - target) < Math.abs(closet - target) ? sum
                        : closet;
            }
        }
        return closet;
    }
}
