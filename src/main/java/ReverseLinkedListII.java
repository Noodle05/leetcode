/**
 * <p>
 * Reverse a linked list from position <i>m</i> to <i>n</i>. Do it in-place and
 * in one-pass.
 * </p>
 * 
 * <p>
 * For example:<br />
 * Given <font color="red">1->2->3->4->5->NULL</font>, <i>m</i> = 2 and <i>n</i>
 * = 4,<br />
 * 
 * return <font color="red">1->4->3->2->5->NULL</font>.
 * </p>
 * <p>
 * <b>Note:</b><br />
 * Given <i>m</i>, <i>n</i> satisfy the following condition: 1 ≤ <i>m</i> ≤
 * <i>n</i> ≤ length of list.
 * </p>
 * 
 * @see <a
 *      href="https://oj.leetcode.com/problems/reverse-linked-list-ii/">Leetcode
 *      Reverse Linked List II Problem</a>
 * @author Wei Gao
 */
public class ReverseLinkedListII {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode current = head;
        ListNode previous = null;
        for (int i = 1; i < m; i++) {
            previous = current;
            current = current.next;
        }
        ListNode tail = current;
        ListNode halfTail = previous;
        ListNode next = null;
        for (int i = m; i <= n; i++) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        tail.next = current;
        ListNode newHead = head;
        if (halfTail != null) {
            halfTail.next = previous;
        } else {
            newHead = previous;
        }
        return newHead;
    }
}
