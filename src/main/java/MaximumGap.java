import java.util.Arrays;

/**
 * <p>
 * Given an unsorted array, find the maximum difference between the successive
 * elements in its sorted form.
 * </p>
 *
 * <p>
 * Try to solve it in linear time/space.
 * </p>
 *
 * <p>
 * Return 0 if the array contains less than 2 elements.
 * </p>
 *
 * <p>
 * You may assume all elements in the array are non-negative integers and fit in
 * the 32-bit signed integer range.
 * </p>
 *
 * @see <a href="https://leetcode.com/problems/maximum-gap/">Maximum Gap</a>
 * @author Wei Gao
 */
public class MaximumGap {
	public int maximumGap(int[] nums) {
	    if (nums.length < 2) {
	        return 0;
	    }
	    int [] s = new int[10];
	    int[] tmp = new int [nums.length];
	    boolean finished = false;
	    int extract = 1;
	    while (!finished) {
	        finished = true;
	        Arrays.fill(s, 0);
	        try {
	            for (int i = 0; i < nums.length; i ++) {
	                int t = (nums[i] / extract) % 10;
	                if (finished && ((nums[i] / extract) >= 10)) {
	                    finished = false;
	                }
	                s[t] = s[t] + 1;
	            }
	            for (int i = 1; i < 10; i ++) {
	                s[i] = s[i] + s[i - 1];
	            }
	            for (int i = nums.length - 1; i >= 0; i --) {
	                int t = (nums[i] / extract) % 10;
	                int tt = s[t];
	                s[t] = s[t] - 1;
	                tmp[tt - 1] = nums[i];
	            }
	            System.arraycopy(tmp, 0, nums, 0, tmp.length);
	        } finally {
	            extract *= 10;
	        }
	    }
	    int max = 0;
	    for (int i = 1; i < nums.length; i ++) {
	        if ((nums[i] - nums[i - 1]) > max) {
	            max = nums[i] - nums[i -1];
	        }
	    }
	    return max;
	}
}
