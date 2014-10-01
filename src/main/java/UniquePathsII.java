import java.util.HashMap;
import java.util.Map;

/**
 * <p>Follow up for "Unique Paths":</p>

<p>Now consider if some obstacles are added to the grids. How many unique paths would there be?</p>

<p>An obstacle and empty space is marked as <font color="red">1</font> and <font color="red">0</font> respectively in the grid.</p>

<p>For example,<br />
There is one obstacle in the middle of a 3x3 grid as illustrated below.

<pre>[
  [0,0,0],
  [0,1,0],
  [0,0,0]
]</pre>
The total number of unique paths is <font color="red">2</font>.</p>

<p><b>Note:</b> <i>m</i> and <i>n</i> will be at most 100.</p>

 * @see <a href="https://oj.leetcode.com/problems/unique-paths-ii/">Leetcode Unique Paths II Problem</a>
 * @author Wei Gao
 */
public class UniquePathsII {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        Map<Integer, Integer> map = new HashMap<>();
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if (obstacleGrid[m - 1][n - 1] == 0) {
            map.put((m - 1) * 100 + (n - 1), 1);
        } else {
            return 0;
        }
        return uniquePathsWithObstacles(0, 0, obstacleGrid, map);
    }
    
    private int uniquePathsWithObstacles(int x, int y, int[][] obstacleGrid, Map<Integer, Integer> map) {
        if (obstacleGrid[x][y] == 1) {
            return 0;
        }
        if (map.containsKey(x * 100 + y)) {
            return map.get(x * 100 + y);
        }
        int num = 0;
        if (x < obstacleGrid.length - 1) {
            num += uniquePathsWithObstacles(x + 1, y, obstacleGrid, map);
        }
        if (y < obstacleGrid[0].length - 1) {
            num += uniquePathsWithObstacles(x, y + 1, obstacleGrid, map);
        }
        map.put(x * 100 + y, num);
        return num;
    }
}
