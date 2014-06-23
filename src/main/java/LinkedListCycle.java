/**
 * <p>
 * Given a linked list, determine if it has a cycle in it.
 * </p>
 * <p>
 * Follow up:<br />
 * Can you solve it without using extra space?
 * </p>
 * 
 * @see <a href="https://oj.leetcode.com/problems/linked-list-cycle/">Leetcode
 *      Linked List Cycle Problem</a>
 * @author Wei Gao
 */
public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        ListNode p1 = head;
        ListNode p2 = head;
        while (p1 != null && p1.next != null && p1.next.next != null) {
            p1 = p1.next.next;
            p2 = p2.next;
            if (p1 == p2) {
                return true;
            }
        }
        return false;
    }
}
