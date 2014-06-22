/**
 * <p>
 * Sort a linked list in O(n log n) time using constant space complexity.
 * </p>
 * 
 * @see <a href="https://oj.leetcode.com/problems/sort-list/">Leetcode Sort List
 *      Problem</a>
 * @author Wei Gao
 */
public class SortList {
  public ListNode sortList(ListNode head) {
    if (head == null) {
      return null;
    }

    ListNode h1 = head;
    ListNode h2 = null;
    ListNode p = head;
    for (ListNode n = head; n != null;) {
      n = n.next;
      if (n != null) {
        n = n.next;
      }
      if (p.next != null) {
        if (p != h2 && h2 != null) {
          p = h2;
        }
        h2 = p.next;
      }
    }
    if (h2 == null) {
      return head;
    }
    p.next = null;
    h1 = sortList(h1);
    h2 = sortList(h2);

    // Merge
    ListNode nh = null;
    p = null;
    while (h1 != null && h2 != null) {
      if (h1.val < h2.val) {
        if (p == null) {
          nh = h1;
          p = nh;
        } else {
          p.next = h1;
          p = p.next;
        }
        h1 = h1.next;
      } else {
        if (p == null) {
          nh = h2;
          p = nh;
        } else {
          p.next = h2;
          p = p.next;
        }
        h2 = h2.next;
      }
    }
    if (h1 != null) {
      p.next = h1;
    }
    if (h2 != null) {
      p.next = h2;
    }

    return nh;
  }
}
