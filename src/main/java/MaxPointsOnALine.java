import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * Given n points on a 2D plane, find the maximum number of points that lie on
 * the same straight line.
 * </p>
 * 
 * @see <a
 *      href="https://oj.leetcode.com/problems/max-points-on-a-line/">Leetcode
 *      Max Points on a Line Problem</a>
 * @author Wei Gao
 */
public class MaxPointsOnALine {
    /**
     * A line is determined by two factors,say y=ax+b
     * 
     * If two points(x1,y1) (x2,y2) are on the same line(Of course).
     * 
     * Consider the gap between two points.
     * 
     * We have (y2-y1)=a(x2-x1),a=(y2-y1)/(x2-x1) a is a rational, b is canceled
     * since b is a constant
     * 
     * If a third point (x3,y3) are on the same line. So we must have y3=ax3+b
     * 
     * Thus,(y3-y1)/(x3-x1)=(y2-y1)/(x2-x1)=a
     * 
     * Since a is a rational, there exists y0 and x0,
     * y0/x0=(y3-y1)/(x3-x1)=(y2-y1)/(x2-x1)=a
     * 
     * So we can use y0/x0 to track a line;
     */
    public int maxPoints(Point[] points) {
        if (points == null || points.length == 0) {
            return 0;
        }
        if (points.length == 1) {
            return 1;
        }
        Map<Double, Integer> slopeMap = new HashMap<>();
        int max = 0;
        for (int i = 0; i < points.length; i++) {
            slopeMap.clear();
            int samePoints = 0;
            int verticalPoints = 0;
            Point p1 = points[i];
            for (int j = i + 1; j < points.length; j++) {
                Point p2 = points[j];
                if (p1.x == p2.x) {
                    if (p1.y == p2.y) {
                        samePoints++;
                        max = Math.max(max, samePoints);
                        for (Map.Entry<Double, Integer> entry : slopeMap
                                .entrySet()) {
                            int count = entry.getValue();
                            count++;
                            entry.setValue(count);
                            max = Math.max(max, count);
                        }
                    }
                    verticalPoints++;
                    max = Math.max(max, verticalPoints);
                } else {
                    double slope = 1.0 * (p2.y - p1.y) / (p2.x - p1.x);
                    if (slope == -0.0) {
                        slope = 0.0;
                    }
                    if (slopeMap.containsKey(slope)) {
                        int count = slopeMap.get(slope);
                        count++;
                        slopeMap.put(slope, count);
                        max = Math.max(max, count);
                    } else {
                        slopeMap.put(slope, samePoints + 1);
                        max = Math.max(max, samePoints + 1);
                    }
                }
            }
        }
        return max + 1;
    }
}
