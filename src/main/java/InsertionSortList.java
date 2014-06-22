/**
 * <p>
 * Sort a linked list using insertion sort.
 * </p>
 * 
 * @see <a href="https://oj.leetcode.com/problems/insertion-sort-list/">Leetcode
 *      Insertion Sort List Problem</a>
 * @author Wei Gao
 */
public class InsertionSortList {
  public ListNode insertionSortList(ListNode head) {
    ListNode p = null;
    ListNode n = head;
    while (n != null) {
      ListNode t = n;
      n = n.next;
      t.next = null;
      if (p == null) {
        p = t;
      } else {
        if (p.val > t.val) {
          t.next = p;
          p = t;
        } else {
          ListNode tt = p;
          while (tt.next != null && tt.next.val < t.val) {
            tt = tt.next;
          }
          t.next = tt.next;
          tt.next = t;
        }
      }
    }
    return p;
  }
}
