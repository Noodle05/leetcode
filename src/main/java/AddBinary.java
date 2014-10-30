/**
 * <p>
 * Given two binary strings, return their sum (also a binary string).
 * </p>
 * 
 * <p>
 * For example,<br />
 * a = <font color="red">"11"</font><br />
 * b = <font color="red">"1"</font><br />
 * Return <font color="red">"100"</font>.
 * </p>
 * 
 * @author Wei Gao
 * @see <a href="https://oj.leetcode.com/problems/add-binary/">Leetcode Add
 *      Binary Problem</a>
 */
public class AddBinary {
    public String addBinary(String a, String b) {
        boolean carry = false;
        int m = a.length() - 1;
        int n = b.length() - 1;
        char[] chs = new char[m > n ? m + 2 : n + 2];
        int p = chs.length - 1;
        while (m >= 0 || n >= 0) {
            int v = (m >= 0 ? a.charAt(m--) - '0' : 0)
                    + (n >= 0 ? b.charAt(n--) - '0' : 0) + (carry ? 1 : 0);
            if (v > 1) {
                carry = true;
                v -= 2;
            } else {
                carry = false;
            }
            chs[p--] = (v == 0 ? '0' : '1');
        }
        if (carry) {
            chs[0] = '1';
            return new String(chs);
        } else {
            return new String(chs, 1, chs.length - 1);
        }
    }
}
