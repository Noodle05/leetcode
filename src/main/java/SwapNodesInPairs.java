/**
 * 
 */

/**
 * <p>
 * Given a linked list, swap every two adjacent nodes and return its head.
 * </p>
 * 
 * <p>
 * For example,<br />
 * Given <font color="red">1->2->3->4</font>, you should return the list as
 * <font color="red">2->1->4->3</font>.
 * </p>
 * <p>
 * Your algorithm should use only constant space. You may not modify the values
 * in the list, only nodes itself can be changed.
 * </p>
 * 
 * @see <a href="https://oj.leetcode.com/problems/swap-nodes-in-pairs/">Leet
 *      code Swap Nodes in Pairs Problem</a>
 * @author Wei Gao
 */
public class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        ListNode result = null;
        ListNode tail = null;
        ListNode p1 = head;
        ListNode p2 = head.next;
        while (p1 != null && p2 != null) {
            p1.next = p2.next;
            p2.next = p1;
            if (result == null) {
                result = p2;
            }
            if (tail != null) {
                tail.next = p2;
            }
            tail = p1;
            p1 = p1.next;
            if (p1 != null) {
                p2 = p1.next;
            } else {
                p2 = null;
            }
        }
        return result;
    }
}
