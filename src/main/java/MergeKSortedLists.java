import java.util.List;

/**
 * <p>
 * Merge k sorted linked lists and return it as one sorted list. Analyze and
 * describe its complexity.
 * </p>
 * 
 * @see <a
 *      href="https://oj.leetcode.com/problems/merge-k-sorted-lists/">Leetcode
 *      Merge k Sorted Lists Problem</a>
 * @author Wei Gao
 *
 */
public class MergeKSortedLists {
    public ListNode mergeKLists(List<ListNode> lists) {
        if (lists.isEmpty()) {
            return null;
        } else if (lists.size() == 1) {
            return lists.get(0);
        } else {
            int k = lists.size();
            int log = (int) (Math.log(k) / Math.log(2));
            log = log < Math.log(k) / Math.log(2) ? log + 1 : log;
            for (int i = 1; i <= log; i++) {
                for (int j = 0; j < lists.size(); j = j + (int) Math.pow(2, i)) {
                    int offset = j + (int) Math.pow(2, i - 1);
                    lists.set(
                            j,
                            merge2Lists(
                                    lists.get(j),
                                    (offset >= lists.size() ? null : lists
                                            .get(offset))));
                }
            }
            return lists.get(0);
        }
    }

    private ListNode merge2Lists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        ListNode header = new ListNode(Integer.MIN_VALUE);
        ListNode current = header;
        while (list1 != null && list2 != null) {
            while (list1 != null && list2 != null && list2.val <= list1.val) {
                current.next = list2;
                list2 = list2.next;
                current = current.next;
                current.next = null;
            }
            while (list1 != null && list2 != null && list1.val <= list2.val) {
                current.next = list1;
                list1 = list1.next;
                current = current.next;
                current.next = null;
            }
        }
        if (list1 != null) {
            current.next = list1;
        }
        if (list2 != null) {
            current.next = list2;
        }
        return header.next;
    }
}
