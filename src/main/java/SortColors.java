/**
 * <p>
 * Given an array with <i>n</i> objects colored red, white or blue, sort them so
 * that objects of the same color are adjacent, with the colors in the order
 * red, white and blue.
 * </p>
 * 
 * <p>
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white,
 * and blue respectively.
 * </p>
 * 
 * <p>
 * <b>Note:</b><br />
 * You are not suppose to use the library's sort function for this problem.
 * </p>
 * 
 * <p>
 * <b>Follow up:</b><br />
 * A rather straight forward solution is a two-pass algorithm using counting
 * sort.<br />
 * First, iterate the array counting number of 0's, 1's, and 2's, then overwrite
 * array with total number of 0's, then 1's and followed by 2's.
 * </p>
 * 
 * <p>
 * Could you come up with an one-pass algorithm using only constant space?
 * </p>
 * 
 * @see <a href="https://oj.leetcode.com/problems/sort-colors/">Leetcode Sort
 *      Color Problem</a>
 * @author Wei Gao
 */
public class SortColors {
    public void sortColors(int[] A) {
        int i = -1, j = -1, k = -1;
        for (int p = 0; i < A.length; p++) {
            if (A[p] == 0) {
                A[++k] = 2;
                A[++j] = 1;
                A[++i] = 0;
            } else if (A[p] == 1) {
                A[++k] = 2;
                A[++j] = 1;
            } else {
                A[++k] = 2;
            }
        }
    }
}
