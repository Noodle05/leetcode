/**
 * <p>
 * Given a singly linked list where elements are sorted in ascending order,
 * convert it to a height balanced BST.
 * </p>
 * 
 * @see <a
 *      href="https://oj.leetcode.com/problems/convert-sorted-list-to-binary-search-tree/">Leetcode
 *      Convert Sorted List to Binary Search Tree Problem</a>
 * @author Wei Gao
 *
 */
public class ConvertSortedListToBinarySearchTree {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode fast = (head.next == null ? null : head.next.next);
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode current = null;
        if (slow.next != null) {
            current = slow.next;
            slow.next = null;
        } else {
            current = slow;
        }
        ListNode next = current.next;
        TreeNode root = new TreeNode(current.val);
        if (head != current) {
            root.left = sortedListToBST(head);
        }
        if (next != null) {
            root.right = sortedListToBST(next);
        }
        return root;
    }
}
