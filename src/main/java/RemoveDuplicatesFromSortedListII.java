/**
 * <p>
 * Given a sorted linked list, delete all nodes that have duplicate numbers,
 * leaving only distinct numbers from the original list.
 * </p>
 * 
 * <p>
 * For example,<br />
 * Given <font color="red">1->2->3->3->4->4->5</font>, return <font
 * color="red">1->2->5</font>.<br />
 * Given <font color="red">1->1->1->2->3</font>, return <font
 * color="red">2->3</font>.
 * </p>
 * 
 * @see <a
 *      href="https://oj.leetcode.com/problems/remove-duplicates-from-sorted-list-ii/">Leetcode
 *      Remove Duplicates from Sorted List II Problem</a>
 * @author Wei Gao
 */
public class RemoveDuplicatesFromSortedListII {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode fakeHead = new ListNode(0);
        ListNode cur = fakeHead;
        ListNode suc = null;
        while (head != null) {
            for (suc = head.next; suc != null && suc.val == head.val; suc = suc.next)
                ;
            if (head.next == null || head.next == suc) {
                cur.next = head;
                cur = cur.next;
                cur.next = null;
            }
            head = suc;
        }

        return fakeHead.next;
    }
}