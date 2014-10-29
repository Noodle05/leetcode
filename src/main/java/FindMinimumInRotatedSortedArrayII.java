/**
 * <p>
 * Follow up for "Find Minimum in Rotated Sorted Array":<br />
 * What if duplicates are allowed?<br />
 * 
 * Would this affect the run-time complexity? How and why?
 * </p>
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
 * Find the minimum element.
 * </p>
 * 
 * <p>
 * The array may contain duplicates.
 * </p>
 * 
 * @author Wei Gao
 * @see <a
 *      href="https://oj.leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/">Leetcode
 *      Find Minimum in Rotated Sorted Array II Problem</a>
 */
public class FindMinimumInRotatedSortedArrayII {
    public int findMin(int[] num) {
        int left = 0, right = num.length - 1;
        while (left <= right) {
            if (num[left] < num[right]) {
                return num[left];
            }
            int middle = (right + left) / 2;
            if (middle == left) {
                break;
            }
            if (num[left] > num[middle]) {
                right = middle;
            } else if (num[middle] > num[left]) {
                left = middle;
            } else {
                left++;
            }
        }
        return num[left] < num[right] ? num[left] : num[right];
    }
}
