import java.util.ArrayList;
import java.util.Arrays;

/**
 * <p>
 * Given an array <i>S</i> of <i>n</i> integers, are there elements <i>a</i>,
 * <i>b</i>, <i>c</i> in <i>S</i> such that <i>a</i> + <i>b</i> + <i>c</i> = 0?
 * Find all unique triplets in the array which gives the sum of zero.
 * </p>
 * 
 * <p>
 * <b>Note:</b>
 * <ul>
 * <li>Elements in a triplet (<i>a</i>,<i>b</i>,<i>c</i>.) must be in
 * non-descending order. (ie, <i>a</i> ≤ <i>b</i> ≤ <i>c</i>)</li>
 * <li>The solution set must not contain duplicate triplets.</li>
 * </ul>
 * </p>
 * 
 * <pre>
 *     For example, given array S = {-1 0 1 2 -1 -4},
 * 
 *     A solution set is:
 *     (-1, 0, 1)
 *     (-1, -1, 2)
 * </pre>
 * 
 * @see <a href="https://oj.leetcode.com/problems/3sum/">Leetcode 3Sum
 *      Problem</a>
 * @author Wei Gao
 */
public class ThreeSum {
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        if (num == null || num.length < 3) {
            return new ArrayList<>(0);
        }
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        Arrays.sort(num);
        for (int i = 0; i < num.length - 2; i++) {
            if (i > 0 && num[i] == num[i - 1]) {
                continue;
            }
            int j = i + 1;
            int k = num.length - 1;
            while (j < k) {
                int sum = num[i] + num[j] + num[k];
                if (sum == 0) {
                    ArrayList<Integer> t = new ArrayList<>(3);
                    t.add(num[i]);
                    t.add(num[j]);
                    t.add(num[k]);
                    result.add(t);
                    while (j < num.length - 1 && num[j] == num[j + 1]) {
                        j++;
                    }
                    j++;
                    while (k > i + 1 && num[k] == num[k - 1]) {
                        k--;
                    }
                    k--;
                } else if (sum < 0) {
                    while (j < num.length - 1 && num[j] == num[j + 1]) {
                        j++;
                    }
                    j++;
                } else {
                    while (k > i + 1 && num[k] == num[k - 1]) {
                        k--;
                    }
                    k--;
                }
            }
        }
        return result;
    }
}
