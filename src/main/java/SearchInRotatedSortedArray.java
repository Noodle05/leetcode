/**
 * <p>
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 * </p>
 * 
 * <p>
 * (i.e., <font color="red">0 1 2 4 5 6 7</font> might become <font
 * color="red">4 5 6 7 0 1 2</font>).
 * </p>
 * 
 * <p>
 * You are given a target value to search. If found in the array return its
 * index, otherwise return -1.
 * </p>
 * 
 * <p>
 * You may assume no duplicate exists in the array.
 * </p>
 * 
 * @see <a
 *      href="https://oj.leetcode.com/problems/search-in-rotated-sorted-array/">Leetcode
 *      Search in Rotated Sorted Array Problem</a>
 * @author Wei Gao
 */
public class SearchInRotatedSortedArray {
    public int search(int[] A, int target) {
        int left = 0;
        int right = A.length - 1;
        while (right >= left) {
            int middle = (right + left) / 2;
            if (A[middle] == target) {
                return middle;
            }
            if (A[left] <= A[middle]) {
                if (A[left] <= target && target <= A[middle]) {
                    right = middle - 1;
                } else {
                    left = middle + 1;
                }
            } else {
                if (A[middle] <= target && target <= A[right]) {
                    left = middle + 1;
                } else {
                    right = middle - 1;
                }
            }
        }
        return -1;
    }
}
