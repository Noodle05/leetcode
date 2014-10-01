import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * A robot is located at the top-left corner of a <i>m</i> x <i>n</i> grid
 * (marked 'Start' in the diagram below).
 * </p>
 * 
 * <p>
 * The robot can only move either down or right at any point in time. The robot
 * is trying to reach the bottom-right corner of the grid (marked 'Finish' in
 * the diagram below).
 * </p>
 * 
 * <p>
 * How many possible unique paths are there?
 * </p>
 * 
 * <p>
 * <img src=
 * "http://4.bp.blogspot.com/_UElib2WLeDE/TNJf8VtC2VI/AAAAAAAACXU/UyUa-9LKp4E/s400/robot_maze.png"
 * /><br />
 * Above is a 3 x 7 grid. How many possible unique paths are there?
 * </p>
 * 
 * <p>
 * <b>Note:</b> <i>m</i> and <i>n</i> will be at most 100.
 * </p>
 * 
 * @see <a href="https://oj.leetcode.com/problems/unique-paths/">Leetcode Unique
 *      Paths Problem</a>
 * @author Wei Gao
 */
public class UniquePaths {
    public int uniquePaths(int m, int n) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put((m - 1) * 100 + n - 1, 1);
        return uniquePaths(0, 0, m - 1, n - 1, map);
    }

    private int uniquePaths(int x, int y, int m, int n,
            Map<Integer, Integer> map) {
        if (map.containsKey(x * 100 + y)) {
            return map.get(x * 100 + y);
        }
        int num = 0;
        if (x < m) {
            num += uniquePaths(x + 1, y, m, n, map);
        }
        if (y < n) {
            num += uniquePaths(x, y + 1, m, n, map);
        }
        map.put(x * 100 + y, num);
        return num;
    }
}
