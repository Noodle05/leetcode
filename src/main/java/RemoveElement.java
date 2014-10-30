/**
 * <p>
 * Given an array and a value, remove all instances of that value in place and
 * return the new length.
 * </p>
 * 
 * <p>
 * The order of elements can be changed. It doesn't matter what you leave beyond
 * the new length.
 * </p>
 * 
 * @author Wei Gao
 * @see <a href="https://oj.leetcode.com/problems/remove-element/">Leetcode
 *      Remove Element Problem</a>
 */
public class RemoveElement {
    public int removeElement(int[] A, int elem) {
        int tail = A.length - 1;
        int head = 0;
        while (head >= tail) {
            if (A[head] == elem) {
                int t = A[tail];
                A[tail] = A[head];
                A[head] = t;
                tail--;
            } else {
                head++;
            }
        }
        return tail + 1;
    }
}
