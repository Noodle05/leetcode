/**
 * <p>
 * Follow up for "Search in Rotated Sorted Array":
 * </p>
 * <p>
 * What if <i>duplicates</i> are allowed?
 * </p>
 * 
 * <p>
 * Would this affect the run-time complexity? How and why?
 * </p>
 * 
 * <p>
 * Write a function to determine if a given target is in the array.
 * </p>
 * 
 * @see <a
 *      href="https://oj.leetcode.com/problems/search-in-rotated-sorted-array-ii/">Leetcode
 *      Search in Rotated Sorted Array II Problem</a>
 * @author Wei Gao
 */
public class SearchInRotatedSortedArrayII {
    public boolean search(int A[], int target) {
        int left = 0, right = A.length - 1;
        while (left <= right) {
            int middle = (right + left) / 2;
            if (A[middle] == target)
                return true; // return m in Search in Rotated Array I
            if (A[left] < A[middle]) { // left half is sorted
                if (A[left] <= target && target < A[middle])
                    right = middle - 1;
                else
                    left = middle + 1;
            } else if (A[left] > A[middle]) { // right half is sorted
                if (A[middle] < target && target <= A[right])
                    left = middle + 1;
                else
                    right = middle - 1;
            } else
                left++;
        }
        return false;
    }
}
