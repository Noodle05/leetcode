/**
 * <p>
 * Given two sorted integer arrays A and B, merge B into A as one sorted array.
 * </p>
 * 
 * <p>
 * <b>Note:</b><br />
 * You may assume that A has enough space (size that is greater or equal to m +
 * n) to hold additional elements from B. The number of elements initialized in
 * A and B are m and n respectively.
 * </p>
 * 
 * @see <a href="https://oj.leetcode.com/problems/merge-sorted-array/">Leetcode
 *      Merge Sorted Array Problem</a>
 * @author Wei Gao
 */
public class MergeSortedArray {
    public void merge(int A[], int m, int B[], int n) {
        int cursorA = m - 1;
        int cursorB = n - 1;
        int i;
        for (i = (m + n - 1); i >= 0 && cursorA >= 0 && cursorB >= 0; i--) {
            if (A[cursorA] > B[cursorB]) {
                A[i] = A[cursorA];
                cursorA--;
            } else {
                A[i] = B[cursorB];
                cursorB--;
            }
        }
        if (cursorB >= 0) {
            for (; i >= 0; i--) {
                A[i] = B[cursorB--];
            }
        }
    }
}
