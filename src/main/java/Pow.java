/**
 * <p>
 * Implement pow(x, n)
 * </p>
 * 
 * @see <a href="https://oj.leetcode.com/problems/powx-n/">Leetcode Pow(x, n)
 *      Problem</a>
 * @author Wei Gao
 *
 */
public class Pow {
    public double pow(double x, int n) {
        if (x == 0.0D) {
            return 0.0D;
        }
        double t = x;
        double r = 1.0D;
        boolean negitive = (n < 0);
        n = Math.abs(n);
        while (n > 0) {
            if ((n % 2) > 0) {
                r *= t;
            }
            n /= 2;
            t *= t;
        }
        if (negitive) {
            r = 1.0D / r;
        }
        return r;
    }
}
