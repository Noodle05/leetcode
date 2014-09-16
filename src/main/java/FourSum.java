import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * <p>
 * Given an array <i>S</i> of <i>n</i> integers, are there elements <i>a</i>,
 * <i>b</i>, <i>c</i>, and <i>d</i> in <i>S</i> such that <i>a</i> + <i>b</i> +
 * <i>c</i> + <i>d</i> = target? Find all unique quadruplets in the array which
 * gives the sum of target.
 * </p>
 * 
 * <p>
 * <b>Note:</b>
 * <ul>
 * <li>Elements in a quadruplet (<i>a</i>,<i>b</i>,<i>c</i>,<i>d</i>) must be in
 * non-descending order. (ie, <i>a</i> ≤ <i>b</i> ≤ <i>c</i> ≤ <i>d</i>)</li>
 * <li>The solution set must not contain duplicate quadruplets.</li>
 * </ul>
 * </p>
 * For example, given array S = {1 0 -1 0 -2 2}, and target = 0.<br />
 * 
 * A solution set is:<br />
 * 
 * <pre>
 *     (-1,  0, 0, 1)
 *     (-2, -1, 1, 2)
 *     (-2,  0, 0, 2)
 * </pre>
 * 
 * </p>
 * 
 * @see <a
 *      href="https://oj.leetcode.com/problems/merge-k-sorted-lists/">Leetcode
 *      4Sum Problem</a>
 * @author Wei Gao
 *
 */
public class FourSum {
    public List<List<Integer>> fourSum(int[] num, int target) {
        Arrays.sort(num);
        Map<Integer, Set<Tuple>> hash = new HashMap<>();
        Set<List<Integer>> ans = new HashSet<>();
        int n = num.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int a = num[i] + num[j];
                if (hash.containsKey(target - a)) {
                    for (Tuple p : hash.get(target - a)) {
                        List<Integer> b = new ArrayList<>(4);
                        b.add(p.a);
                        b.add(p.b);
                        b.add(num[i]);
                        b.add(num[j]);
                        ans.add(b);
                    }
                }
            }
            for (int j = 0; j < i; j++) {
                int a = num[j], b = num[i];
                Set<Tuple> t = hash.get(a + b);
                if (t == null) {
                    t = new HashSet<>();
                    hash.put(a + b, t);
                }
                t.add(new Tuple(a, b));
            }
        }
        return new ArrayList<>(ans);
    }

    private static class Tuple {
        private final int a;
        private final int b;

        private Tuple(int a, int b) {
            this.a = a < b ? a : b;
            this.b = a < b ? b : a;
        }

        @Override
        public int hashCode() {
            return a + b;
        }

        @Override
        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (other == null || !(other instanceof Tuple)) {
                return false;
            }
            final Tuple obj = (Tuple) other;
            if (obj.a != a || obj.b != b) {
                return false;
            }
            return true;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(a).append(", ").append(b);
            return sb.toString();
        }
    }
}
