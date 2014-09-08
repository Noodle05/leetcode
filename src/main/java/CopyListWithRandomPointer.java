/**
 * <p>
 * A linked list is given such that each node contains an additional random
 * pointer which could point to any node in the list or null.
 * </p>
 * 
 * <p>
 * Return a deep copy of the list.
 * </p>
 * 
 * @see <a
 *      href="https://oj.leetcode.com/problems/copy-list-with-random-pointer/">Leetcode
 *      Copy List with Random Pointer Problem</a>
 * @author Wei Gao
 */
public class CopyListWithRandomPointer {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return null;
        }
        RandomListNode cursor = head;
        while (cursor != null) {
            RandomListNode copy = new RandomListNode(cursor.label);
            copy.next = cursor.next;
            cursor.next = copy;
            cursor = copy.next;
        }

        cursor = head;
        while (cursor != null) {
            cursor.next.random = cursor.random == null ? null
                    : cursor.random.next;
        }

        RandomListNode nh = head.next;
        cursor = head;
        RandomListNode c2 = head.next;
        while (cursor != null) {
            cursor.next = c2.next;
            cursor = cursor.next;
            c2.next = cursor == null ? null : cursor.next;
            c2 = c2.next;
        }

        return nh;
    }
}
