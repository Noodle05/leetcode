/**
 * @author Wei Gao
 * @since 2018-12-10
 */
public class SplitArray {
    public int splitArray(int[] nums, int m) {
        int max = 0; long sum = 0;

        for (int num : nums) {
            max = Math.max(num, max);
            sum += max;
        }

        if (m == 1)
            return (int)sum;
        long l = max; long r = sum;
        while (l < r) {
            long mid = (l + r) / 2;
            if (valid(mid, nums, m)) {
                r = mid - l;
            } else {
                l = mid + l;
            }
        }
        return (int)l;
    }

    private boolean valid(long target, int[] nums, int m) {
        int count = 1;
        long total = 0L;
        for (int num : nums) {
            total += num;
            if (total > target) {
                total = num;
                count ++;
                if (count > m) {
                    return false;
                }
            }
        }
        return true;
    }
}