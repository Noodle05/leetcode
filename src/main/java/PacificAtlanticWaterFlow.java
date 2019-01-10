import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * <p>Given an m x n matrix of non-negative integers representing the height of each unit cell in a continent, the "Pacific ocean" touches the left and top edges of the matrix and the "Atlantic ocean" touches the right and bottom edges.</p>
 *
 * <p>Water can only flow in four directions (up, down, left, or right) from a cell to another one with height equal or lower.</p>
 *
 * <p>Find the list of grid coordinates where water can flow to both the Pacific and Atlantic ocean.</p>
 *
 * <p><b>Note:</b>
 * <ul><li>The order of returned grid coordinates does not matter.</li>
 * <li>Both m and n are less than 150.</li></ul></p>
 *
 * <p><b>Example:</b><br />
 *
 * Given the following 5x5 matrix:<br />
 *
 * <pre>  Pacific ~   ~   ~   ~   ~
 *        ~  1   2   2   3  (5) *
 *        ~  3   2   3  (4) (4) *
 *        ~  2   4  (5)  3   1  *
 *        ~ (6) (7)  1   4   5  *
 *        ~ (5)  1   1   2   4  *
 *           *   *   *   *   * Atlantic</pre>
 *
 * Return:<br />
 *
 * <pre>[[0, 4], [1, 3], [1, 4], [2, 2], [3, 0], [3, 1], [4, 0]] (positions with parentheses in above matrix).</pre></p>
 */
public class PacificAtlanticWaterFlow {
    private static final int[][] dir = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public List<int[]> pacificAtlantic(int[][] matrix) {
        List<int[]> result = new ArrayList<>();
        int n = matrix.length;
        int m = matrix[0].length;
        Queue<int[]> pQueue = new LinkedList<>();
        Queue<int[]> aQueue = new LinkedList<>();
        boolean[][] pacific = new boolean[n][m];
        boolean[][] atlantic = new boolean[n][m];

        for (int i = 0; i < n; i ++) {
            pQueue.offer(new int[]{i, 0});
            aQueue.offer(new int[]{i, m - 1});
            pacific[i][0] = true;
            atlantic[i][m - 1] = true;
        }
        for (int i = 0; i < m; i ++) {
            pQueue.offer(new int[]{0, i});
            aQueue.offer(new int[]{m - 1, i});
            pacific[0][i] = true;
            atlantic[n - 1][i] = true;
        }

        bfs(matrix, pQueue, pacific);
        bfs(matrix, aQueue, atlantic);

        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < m; j ++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    result.add(new int[] {i, j});
                }
            }
        }
        return result;
    }

    private void bfs(int[][] matrix, Queue<int[]> queue, boolean[][] visited) {
        int n = matrix.length;
        int m = matrix[0].length;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            for (int[] d : dir) {
                int x = current[0] + d[0];
                int y = current[1] + d[1];
                if (x < 0 || x >= n || y < 0 || y >= m || visited[x][y] || matrix[x][y] < matrix[current[0]][current[1]]) {
                    continue;
                }
                visited[x][y] = true;
                queue.offer(new int[]{x, y});
            }
        }
    }
}
