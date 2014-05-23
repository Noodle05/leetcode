import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 
 */

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
      if (!str.isEmpty()) {
        if (head == null) {
          head = new ListNode(Integer.parseInt(str));
          current = head;
        } else {
          current.next = new ListNode(Integer.parseInt(str));
          current = current.next;
        }
      }
    }
    return head;
  }

  public static TreeNode readTreeNode(String s) {
    String[] strs = s.split(",\\s*");
    TreeNode root = null;
    TreeNode node = null;
    Queue<TreeNode> queue = new ArrayDeque<>();
    boolean leftDone = false;
    boolean rightDone = false;
    for (String str : strs) {
      if (!str.isEmpty()) {
        TreeNode tmp;
        if (str.equals("#")) {
          tmp = null;
        } else {
          tmp = new TreeNode(Integer.parseInt(str));
        }
        if (root == null) {
          root = tmp;
          node = tmp;
          leftDone = false;
          rightDone = false;
        } else {
          if (leftDone && rightDone) {
            node = queue.poll();
            leftDone = false;
            rightDone = false;
          }
          if (leftDone) {
            node.right = tmp;
            rightDone = true;
          } else {
            node.left = tmp;
            leftDone = true;
          }
          if (tmp != null) {
            queue.add(tmp);
          }
        }
      }
    }
    return root;
  }

  public static TreeLinkNode readTreeLinkNode(String s) {
    String[] strs = s.split(",\\s*");
    TreeLinkNode root = null;
    TreeLinkNode node = null;
    Queue<TreeLinkNode> queue = new ArrayDeque<>();
    boolean leftDone = false;
    boolean rightDone = false;
    for (String str : strs) {
      if (!str.isEmpty()) {
        TreeLinkNode tmp;
        if (str.equals("#")) {
          tmp = null;
        } else {
          tmp = new TreeLinkNode(Integer.parseInt(str));
        }
        if (root == null) {
          root = tmp;
          node = tmp;
          leftDone = false;
          rightDone = false;
        } else {
          if (leftDone && rightDone) {
            node = queue.poll();
            leftDone = false;
            rightDone = false;
          }
          if (leftDone) {
            node.right = tmp;
            rightDone = true;
          } else {
            node.left = tmp;
            leftDone = true;
          }
          if (tmp != null) {
            queue.add(tmp);
          }
        }
      }
    }
    return root;
  }
}
