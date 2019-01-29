import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LargestComponentSizeByCommonFactor {
    public int largestComponentSize(int[] A) {
        int mv = A[0];
        for (int a : A)
            mv = Math.max(mv, a);
        Set<Integer> primes = findAllPrime(mv);

        int[] counts = new int[A.length];
        int[] parents = new int[A.length];
        int[] primeToIdx = new int[mv + 1];

        Arrays.fill(primeToIdx, -1);
        for (int i = 0; i < A.length; i ++) {
            parents[i] = i;
            counts[i] = 1;
        }

        int max = 0;

        for (int i = 0; i < A.length; i ++) {
            int a = A[i];
            for (int p : primes) {
                if (primes.contains(a))
                    p = a;

                if (a % p == 0) {
                    if (primeToIdx[p] > -1)
                        max = union(parents, counts, primeToIdx[p], i, max);
                    primeToIdx[p] = i;
                    while (a % p == 0)
                        a /= p;
                }
                if (a == 1)
                    break;
            }
        }

        return max;
    }

    private Set<Integer> findAllPrime(int x) {
        boolean[] primes = new boolean[x + 1];
        Arrays.fill(primes, true);
        Set<Integer> result = new HashSet<>();
        for (int i = 2; i < x; i ++) {
            if (primes[i]) {
                result.add(i);
                for (int j = 2; j * i < primes.length; j ++) {
                    primes[i * j] = false;
                }
            }
        }
        return result;
    }

    private int find(int[] parents, int a) {
        if (parents[a] != a)
            parents[a] = find(parents, parents[a]);
        return parents[a];
    }

    private int union(int[] parents, int[] counts, int a, int b, int previousMax) {
        int root1 = find(parents, a);
        int root2 = find(parents, b);
        if (root1 == root2)
            return previousMax;
        int count = counts[root1] + counts[root2];
        int max = Math.max(count, previousMax);
        parents[root1] = root2;
        counts[root2] = count;
        return max;
    }
}
