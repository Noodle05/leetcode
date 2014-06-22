/**
 * <p>
 * Given a linked list, return the node where the cycle begins. If there is no
 * cycle, return null.
 * </p>
 * 
 * <p>
 * Follow up:<br />
 * Can you solve it without using extra space?
 * </p>
 * 
 * @see <a
 *      href="https://oj.leetcode.com/problems/linked-list-cycle-ii/">Leetcode
 *      Linked List Cycle II problem</a>
 * @author Wei Gao
 */
public class LinkedListCycleII {
  public ListNode detectCycle(ListNode head) {
    ListNode p1 = head;
    ListNode p2 = head;
    boolean circle = false;
    while (!circle && p1 != null && p1.next != null && p1.next.next != null) {
      p1 = p1.next.next;
      p2 = p2.next;
      if (p1 == p2) {
        circle = true;
      }
    }
    if (circle) {
      p2 = head;
      while (p1 != p2) {
        p1 = p1.next;
        p2 = p2.next;
      }
      return p1;
    } else {
      return null;
    }
  }
}
