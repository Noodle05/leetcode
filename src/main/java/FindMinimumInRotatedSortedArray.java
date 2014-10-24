/**
 * <p>
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 * </p>
 * 
 * <p>
 * (i.e., <font color="red"> 0 1 2 4 5 6 7</font> might become <font
 * color="red">4 5 6 7 0 1 2</font>).
 * </p>
 * 
 * <p>
 * Find the minimum element.
 * </p>
 * 
 * <p>
 * You may assume no duplicate exists in the array.
 * </p>
 * 
 * @see <a
 *      href="https://oj.leetcode.com/problems/find-minimum-in-rotated-sorted-array/">Find
 *      Minimum in Rotated Sorted Array</a>
 * @author Wei Gao
 *
 */
public class FindMinimumInRotatedSortedArray {
    public int findMin(int[] num) {
        int left = 0, right = num.length - 1;
        while (left <= right) {
            int middle = (right + left) / 2;
            if (middle == left) {
                break;
            }
            if (num[left] > num[middle]) {
                right = middle;
            } else if (num[middle] > num[right]) {
                left = middle;
            } else {
                return num[left];
            }
        }
        return num[left] < num[right] ? num[left] : num[right];
    }
}
