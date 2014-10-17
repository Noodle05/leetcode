/**
 * <p>
 * Implement next permutation, which rearranges numbers into the
 * lexicographically next greater permutation of numbers.
 * </p>
 * 
 * <p>
 * If such arrangement is not possible, it must rearrange it as the lowest
 * possible order (ie, sorted in ascending order).
 * </p>
 * 
 * <p>
 * The replacement must be in-place, do not allocate extra memory.
 * </p>
 * 
 * <p>
 * Here are some examples. Inputs are in the left-hand column and its
 * corresponding outputs are in the right-hand column.<br />
 * <font color="red">1,2,3</font> → <font color="red">1,3,2</font><br />
 * <font color="red">3,2,1</font> → <font color="red">1,2,3</font><br />
 * <font color="red">1,1,5</font> → <font color="red">1,5,1</font><br />
 * </p>
 * 
 * @see <a href="https://oj.leetcode.com/problems/next-permutation/">Leetcode
 *      Next Permutation Problem</a>
 * @author Wei Gao
 */
public class NextPermutation {
    /**
     * <ul>
     * <li>Start from its last element, traverse backward to find the first one
     * with index i that satisfy num[i-1] < num[i]. So, elements from num[i] to
     * num[n-1] is reversely sorted.</li>
     * <li>To find the next permutation, we have to swap some numbers at
     * different positions, to minimize the increased amount, we have to make
     * the highest changed position as high as possible. Notice that index
     * larger than or equal to i is not possible as num[i,n-1] is reversely
     * sorted. So, we want to increase the number at index i-1, clearly, swap it
     * with the smallest number between num[i,n-1] that is larger than num[i-1].
     * For example, original number is 121543321, we want to swap the '1' at
     * position 2 with '2' at position 7.</li>
     * <li>The last step is to make the remaining higher position part as small
     * as possible, we just have to reversely sort the num[i,n-1]</li>
     * </ul>
     * 
     * @param num
     */
    public void nextPermutation(int[] num) {
        int pos = -1;
        for (int i = num.length - 1; i > 0; i--) {
            if (num[i] > num[i - 1]) {
                pos = i - 1;
                break;
            }
        }
        if (pos >= 0) {
            int pos1 = -1;
            int min = Integer.MAX_VALUE;
            for (int i = pos + 1; i < num.length; i++) {
                if (num[i] > num[pos] && min > num[i]) {
                    min = num[i];
                    pos1 = i;
                }
            }
            swap(num, pos, pos1);
        }
        reverseSort(num, pos + 1, num.length - 1);
    }

    private void swap(int[] num, int pos1, int pos2) {
        int t = num[pos1];
        num[pos1] = num[pos2];
        num[pos2] = t;
    }

    private void reverseSort(int[] num, int begin, int end) {
        swap(num, begin, end);
        int i = begin;
        int j = end;
        while (i < j) {
            while (i < j && num[i] <= num[end]) {
                i ++;
            }
            while (j > i && num[j] >= num[end]) {
                j --;
            }
            swap(num, i, j);
        }
        swap(num, i, end);
        if (i > begin + 1) {
            reverseSort(num, begin, i - 1);
        }
        if (i < end - 1) {
            reverseSort(num, i + 1, end);
        }
    }
}
