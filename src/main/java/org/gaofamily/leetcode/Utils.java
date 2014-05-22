/**
 * 
 */
package org.gaofamily.leetcode;

/**
 * A utility/helper to read ListNode, TreeNode and so on for Leetcode test
 * 
 * @author Wei Gao
 */
public class Utils {
  public static ListNode readListNode(String s) {
    String[] strs = s.split(",\\s*");
    ListNode head = null;
    ListNode current = null;
    for (String str : strs) {
      if (head == null) {
        head = new ListNode(Integer.parseInt(str));
        current = head;
      } else {
        current.next = new ListNode(Integer.parseInt(str));
        current = current.next;
      }
    }
    return head;
  }
}
