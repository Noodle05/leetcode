/**
 * @author Wei Gao
 */
public class ListNode {
  int val;
  ListNode next;

  ListNode(int x) {
    val = x;
    next = null;
  }

  @Override
  public int hashCode() {
    int ret = 7;
    ret += 13 * val;
    return ret;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) {
      return true;
    }
    if (other == null || !(other instanceof ListNode)) {
      return false;
    }
    final ListNode obj = (ListNode) other;
    if (val != obj.val) {
      return false;
    }
    if (next == null) {
      if (obj.next != null) {
        return false;
      }
    } else if (!next.equals(obj.next)) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append(val);
    if (next != null) {
      sb.append(", ").append(next);
    }
    return sb.toString();
  }
}
