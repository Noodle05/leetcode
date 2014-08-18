/**
 * <p>
 * Given a singly linked list <i>L</i>:
 * <i>L</i><sub>0</sub>→<i>L</i><sub>1</sub>
 * →…→<i>L</i><sub>n-1</sub>→<i>L</i><sub>n</sub>,<br />
 * reorder it to:
 * <i>L</i><sub>0</sub>→<i>L</i><sub>n</sub>→<i>L</i><sub>1</sub>→
 * <i>L</i><sub>n-1</sub>→<i>L</i><sub>2</sub>→<i>L</i><sub>n-2</sub>→…
 * </p>
 * 
 * <p>
 * You must do this in-place without altering the nodes' values.
 * </p>
 * 
 * <p>
 * For example,<br />
 * Given <font color="red">{1,2,3,4}</font>, reorder it to <font
 * color="red">{1,4,2,3}</font>.
 * </p>
 * 
 * @see <a href="https://oj.leetcode.com/problems/reorder-list/">Leetcode
 *      Reorder List Problem</a>
 * @author Wei Gao
 */
public class ReorderList {
    public void reorderList(ListNode head) {
        if (head != null) {
            ListNode p1 = head;
            ListNode p2 = head;
            // Find middle of this list.
            while (p1.next != null && p1.next.next != null) {
                p2 = p2.next;
                p1 = p1.next.next;
            }
            // Break this list from middle into two.
            p1 = p2.next;
            p2.next = null;
            // Reverse second half.
            ListNode p3 = null;
            while (p1 != null) {
                p2 = p1.next;
                p1.next = p3;
                p3 = p1;
                p1 = p2;
            }
            p2 = p3;
            p1 = head;
            // Merge two list
            while (p1 != null && p2 != null) {
                p3 = p2.next;
                p2.next = p1.next;
                p1.next = p2;
                p1 = p2.next;
                p2 = p3;
            }
        }
    }
}
