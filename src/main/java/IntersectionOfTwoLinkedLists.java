/**
 *
 */

/**
 * <p>
 * Write a program to find the node at which the intersection of two singly
 * linked lists begins.
 * </p>
 *
 * <p>
 * For example, the following two linked lists:
 *
 * <pre>
A:          a1 → a2
                   ↘
                     c1 → c2 → c3
                   ↗
B:     b1 → b2 → b3
 * </pre>
 *
 * begin to intersect at node c1.
 * </p>
 * <p>
 * <b>Notes:</b>
 * <ul>
 * <li>If the two linked lists have no intersection at all, return
 * <font color="red">null</font>.</li>
 * <li>The linked lists must retain their original structure after the function
 * returns.</li>
 * <li>You may assume there are no cycles anywhere in the entire linked
 * structure.</li>
 * <li>Your code should preferably run in O(n) time and use only O(1) memory.
 * </li>
 * </ul>
 * </p>
 *
 * @see <a href=
 *      "https://leetcode.com/problems/intersection-of-two-linked-lists/">
 *      Intersection of Two Linked Lists</a>
 * @author Wei Gao
 */
public class IntersectionOfTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode tailA = null;
        ListNode t = headA;
        ListNode intersection = null;
        while (t.next != null) {
            t = t.next;
        }
        t.next = headA;
        tailA = t;
        ListNode fast = headB;
        ListNode slow = null;
        while (fast.next != null && fast.next.next != null) {
            if (slow == null) {
                slow = fast.next;
            } else {
                slow = slow.next;
            }
            fast = fast.next.next;
            if (fast == slow) {
                break;
            }
        }
        if (fast == slow) {
            fast = headB;
            while (fast != slow) {
                fast = fast.next;
                slow = slow.next;
            }
            intersection = fast;
        }
        tailA.next = null;
        return intersection;
    }
}
