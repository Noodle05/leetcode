import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <p>
 * Given <i>n</i> non-negative integers representing the histogram's bar height
 * where the width of each bar is 1, find the area of largest rectangle in the
 * histogram.
 * </p>
 * 
 * <p>
 * <img src="http://www.leetcode.com/wp-content/uploads/2012/04/histogram.png"
 * /><br />
 * Above is a histogram where width of each bar is 1, given height = <font
 * color="red">[2,1,5,6,2,3]</font>.
 * </p>
 * 
 * 
 * <p>
 * <img
 * src="http://www.leetcode.com/wp-content/uploads/2012/04/histogram_area.png"
 * /><br />
 * The largest rectangle is shown in the shaded area, which has area = <font
 * color="red">10</font> unit.
 * </p>
 * 
 * <p>
 * For example,<br />
 * Given height = <font color="red">[2,1,5,6,2,3]</font>,<br />
 * return <font color="red">10</font>.
 * </p>
 * 
 * @see <a
 *      href="https://oj.leetcode.com/problems/largest-rectangle-in-histogram/">Leetcode
 *      Largest Rectangle in Histogram Problem</a>
 * @author Wei Gao
 */
public class LargestRectangleInHistogram {
    public int largestRectangleArea(int[] height) {
        if (height == null)
            return 0;// Should throw exception
        if (height.length == 0)
            return 0;

        Deque<Integer> index = new ArrayDeque<>();
        index.push(-1);
        int max = 0;

        for (int i = 0; i < height.length; i++) {
            // Start calculate the max value
            while (index.peek() > -1)
                if (height[index.peek()] > height[i]) {
                    int top = index.pop();
                    max = Math.max(max, height[top] * (i - 1 - index.peek()));
                } else
                    break;

            index.push(i);
        }
        while (index.peek() != -1) {
            int top = index.pop();
            max = Math.max(max, height[top]
                    * (height.length - 1 - index.peek()));
        }
        return max;
    }
}
