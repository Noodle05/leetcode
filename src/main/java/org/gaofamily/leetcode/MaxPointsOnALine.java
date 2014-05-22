/**
 * 
 */
package org.gaofamily.leetcode;

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
            for (Map.Entry<Double, Integer> entry : slopeMap.entrySet()) {
              int count = entry.getValue();
              count++;
              entry.setValue(count);
              max = Math.max(max, count);
            }
            verticalPoints++;
            max = Math.max(max, verticalPoints);
          } else {
            verticalPoints++;
            max = Math.max(max, verticalPoints);
          }
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
