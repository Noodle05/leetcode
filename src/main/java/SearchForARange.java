/**
 * <p>
 * Given a sorted array of integers, find the starting and ending position of a
 * given target value.
 * </p>
 * 
 * <p>
 * Your algorithm's runtime complexity must be in the order of <i>O</i>(log
 * <i>n</i>).
 * </p>
 * <p>
 * If the target is not found in the array, return <font color="red">[-1,
 * -1]</font>.
 * </p>
 * <p>
 * For example,<br />
 * Given <font color="red">[5, 7, 7, 8, 8, 10]</font> and target value 8,<br />
 * return <font color="red">[3, 4]</font>.
 * </p>
 * 
 * @see <a href="https://oj.leetcode.com/problems/search-for-a-range/">Leetcode
 *      Search for a Range Problem</a>
 * @author Wei Gao
 */
public class SearchForARange {
    public int[] searchRange(int[] A, int target) {
        if (A != null && A.length > 0) {
            return searchRange(A, 0, A.length - 1, target);
        } else {
            return new int[] { -1, -1 };
        }
    }

    private int[] searchRange(int[] A, int leftBound, int rightBound, int target) {
        int[] result = new int[] { -1, -1 };
        int middle = (rightBound - leftBound + 1) / 2 + leftBound;
        if (A[middle] == target) {
            int left = -1, right = -1;
            if (middle > leftBound) {
                left = searchLeft(A, leftBound, middle - 1, target);
            } else {
                left = middle;
            }
            if (middle < rightBound) {
                right = searchRight(A, middle + 1, rightBound, target);
            } else {
                right = middle;
            }
            result = new int[] { left, right };
        } else if (A[middle] < target) {
            if (middle < rightBound) {
                result = searchRange(A, middle + 1, rightBound, target);
            }
        } else { // A[middle] > target
            if (middle > leftBound) {
                result = searchRange(A, leftBound, middle - 1, target);
            }
        }
        return result;
    }

    private int searchLeft(int[] A, int leftBound, int rightBound, int target) {
        int middle = (rightBound - leftBound + 1) / 2 + leftBound;
        if (A[middle] == target) {
            if (middle > leftBound) {
                return searchLeft(A, leftBound, middle - 1, target);
            } else {
                return middle;
            }
        } else if (A[middle] < target) {
            if (middle < rightBound) {
                return searchLeft(A, middle + 1, rightBound, target);
            } else {
                return middle + 1;
            }
        } else {
            // This should never happen.
            throw new IllegalStateException();
        }
    }

    private int searchRight(int[] A, int leftBound, int rightBound, int target) {
        int middle = (rightBound - leftBound + 1) / 2 + leftBound;
        if (A[middle] == target) {
            if (middle < rightBound) {
                return searchRight(A, middle + 1, rightBound, target);
            } else {
                return middle;
            }
        } else if (A[middle] > target) {
            if (middle > leftBound) {
                return searchRight(A, leftBound, middle - 1, target);
            } else {
                return middle - 1;
            }
        } else {
            // This should never happen.
            throw new IllegalStateException();
        }
    }
}
