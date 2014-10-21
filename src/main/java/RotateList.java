/**
 * <p>
 * Given a list, rotate the list to the right by <i>k</i> places, where <i>k</i>
 * is non-negative.
 * </p>
 * 
 * <p>
 * For example:<br />
 * Given <font color="red">1->2->3->4->5->NULL</font> and <i>k</i> = <font
 * color="red">2</font>,<br />
 * return <font color="red">4->5->1->2->3->NULL</font>.
 * </p>
 * 
 * @see <a href="https://oj.leetcode.com/problems/rotate-list/">Leetcode Rotate
 *      List Problem</a>
 * @author Wei Gao
 */
public class RotateList {
    public ListNode rotateRight(ListNode head, int n) {
        if (head == null || n == 0) {
            return head;
        }
        ListNode p1 = head, p2 = head;
        for (int i = 0; i < n; i++) {
            if (p2.next == null) {
                p2 = head;
            } else {
                p2 = p2.next;
            }
        }
        while (p2.next != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        if (p1 != p2) {
            ListNode t = p1.next;
            p1.next = null;
            p2.next = head;
            head = t;
        }
        return head;
    }
}
