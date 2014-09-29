/**
 * <p>
 * Given a linked list and a value <i>x</i>, partition it such that all nodes
 * less than <i>x</i> come before nodes greater than or equal to <i>x</i>.
 * </p>
 * 
 * <p>
 * You should preserve the original relative order of the nodes in each of the
 * two partitions.
 * </p>
 * 
 * <p>
 * For example,<br />
 * Given <font color="red">1->4->3->2->5->2</font> and <i>x</i> = 3,<br />
 * return <font color="red">1->2->2->4->3->5</font>.
 * </p>
 * 
 * @see <a href="https://oj.leetcode.com/problems/partition-list/">Partition
 *      List</a>
 * @author Wei Gao
 */
public class PartitionList {
    public ListNode partition(ListNode head, int x) {
        ListNode t1 = new ListNode(Integer.MIN_VALUE);
        ListNode t2 = new ListNode(Integer.MIN_VALUE);
        ListNode cursor = head;
        ListNode c1 = t1, c2 = t2;
        while (cursor != null) {
            if (cursor.val < x) {
                c1.next = cursor;
                cursor = cursor.next;
                c1 = c1.next;
                c1.next = null;
            } else {
                c2.next = cursor;
                cursor = cursor.next;
                c2 = c2.next;
                c2.next = null;
            }
        }
        c1.next = t2.next;
        return t1.next;
    }
}
