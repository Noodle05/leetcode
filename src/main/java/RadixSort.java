/**
 * @author Wei Gao
 */
public class RadixSort {
    public int maximumGap(int[] nums) {
        int result = 0;
        if (nums == null || nums.length < 2) {
            return result;
        }
        int[] sorted = radixSort(nums);
        for (int i = 1; i < sorted.length; i ++) {
            result = result > sorted[i] - sorted[i - 1] ? result : sorted[i] - sorted[i - 1];
        }
        return result;
    }

    public int[] radixSort(int[] data) {
        int[] result = data;
        int maxDigits = 0;
        for (int i = 0; i < data.length; i ++) {
            int digits = 0;
            int t = data[i];
            while (t > 0) {
                digits ++;
                t = t / 10;
            }
            if (digits > maxDigits) {
                maxDigits = digits;
            }
        }
        for (int i = 0; i < maxDigits; i ++) {
            result = sortSpecificPosition(result, i);
        }
        return result;
    }

    private int[] sortSpecificPosition(int[] data, int position) {
        int[] result = new int[data.length];
        int[] indices = new int[10];
        int p1 = 1;
        for (int i = 0; i < position; i ++) {
            p1 *= 10;
        }
        for (int d : data) {
            int pv = (d / p1) % 10;
            indices[pv] ++;
        }
        for (int i = 1; i < indices.length; i ++) {
           indices[i] = indices[i] + indices[i - 1];
        }
        for (int i = data.length - 1; i >= 0; i --) {
            int pv = (data[i] / p1) % 10;
            indices[pv] -= 1;
            result[indices[pv]] = data[i];
        }
        return result;
    }
}
