/**
 * <p>
 * Given a linked list, remove the n<sup>th</sup> node from the end of list and
 * return its head.
 * </p>
 * 
 * <p>
 * For example,
 * 
 * <pre>
 *    Given linked list: <b>1->2->3->4->5</b>, and <b>n = 2</b>.
 * 
 *    After removing the second node from the end, the linked list becomes <b>1->2->3->5</b>.
 * </pre>
 * 
 * </p>
 * <p>
 * <b>Note:</b><br />
 * Given <i>n</i> will always be valid.<br />
 * Try to do this in one pass.
 * </p>
 * 
 * @see <a
 *      href="https://oj.leetcode.com/problems/remove-nth-node-from-end-of-list/">LeetCode
 *      Remove Nth Node From End of List Problem</a>
 * @author Wei Gao
 */
public class RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head;
        ListNode slow = head;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        if (fast == null) {
            return head.next;
        } else {
            slow.next = slow.next.next;
            return head;
        }
    }
}
