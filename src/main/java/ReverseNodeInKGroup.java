/**
 * <p>
 * Given a linked list, reverse the nodes of a linked list k at a time and
 * return its modified list.
 * </p>
 * 
 * <p>
 * If the number of nodes is not a multiple of k then left-out nodes in the end
 * should remain as it is.
 * </p>
 * 
 * <p>
 * You may not alter the values in the nodes, only nodes itself may be changed.
 * </p>
 * 
 * <p>
 * Only constant memory is allowed.
 * </p>
 * 
 * <p>
 * For example,
 * <p>
 * Given this linked list: <font color="red">1->2->3->4->5</font>
 * </p>
 * 
 * <p>
 * For k = 2, you should return: <font color="red">2->1->4->3->5</font>
 * </p>
 * 
 * <p>
 * For k = 3, you should return: <font color="red">3->2->1->4->5</font>
 * </p>
 * </p>
 * 
 * @see <a
 *      href="https://oj.leetcode.com/problems/reverse-nodes-in-k-group/">Leetcode
 *      Reverse Nodes in k-Group Problem</a>
 * @author Wei Gao
 */
public class ReverseNodeInKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k <= 1) {
            return head;
        }
        ListNode nh = head;
        ListNode p = null;
        ListNode p1 = head;
        ListNode p2 = head;

        while (p2 != null) {
            int i;
            for (i = 0; i < k && p2 != null; i ++) {
                p2 = p2.next;
            }
            
            if (i == k) {
                ListNode t1 = p2;
                ListNode t2 = p1;
                while (t2 != p2) {
                    ListNode t = t1;
                    t1 = t2.next;
                    t2.next = t;
                    t = t1;
                    t1 = t2;
                    t2 = t;
                }
                if (p == null) {
                    nh = t1;
                } else {
                    p.next = t1;
                }
                p = p1;
                p1 = p2;
            }
        }
        
        return nh;
    }
}
