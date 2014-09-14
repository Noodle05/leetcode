import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
