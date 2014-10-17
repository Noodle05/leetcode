/**
 * <p>
 * The count-and-say sequence is the sequence of integers beginning as follows:<br />
 * <font color="red">1, 11, 21, 1211, 111221, ...</font>
 * </p>
 * 
 * <p>
 * <font color="red">1</font> is read off as <font color="red">"one 1"</font> or
 * <font color="red">11</font>.<br />
 * <font color="red">11</font> is read off as <font color="red">"two 1s"</font>
 * or <font color="red">21</font>.<br />
 * <font color="red">21</font> is read off as <font
 * color="red">"one 2, then one 1"</font> or <font color="red">1211</font>.
 * </p>
 * <p>
 * Given an integer <i>n</i>, generate the <i>n<sup>th</sup></i> sequence.
 * </p>
 * 
 * <p>
 * Note: The sequence of integers will be represented as a string.
 * </p>
 * 
 * @see <a href="https://oj.leetcode.com/problems/count-and-say/">Leetcode Count
 *      And Say Problem</a>
 * @author Wei Gao
 */
public class CountAndSay {
    private String nextOne(String s) {
        char last = ' ';
        int count = 0;
        StringBuilder sb = new StringBuilder();
        for (char ch : s.toCharArray()) {
            if (last == ' ') {
                last = ch;
                count = 1;
            } else if (last == ch) {
                count++;
            } else if (count > 0) {
                sb.append((char) ('0' + count)).append(last);
                last = ch;
                count = 1;
            }
        }
        if (count > 0) {
            sb.append((char) ('0' + count)).append(last);
        }
        return sb.toString();
    }

    public String countAndSay(int n) {
        if (n <= 0)
            return null;
        String s = "1";
        for (int i = 1; i < n; i++) {
            s = nextOne(s);
        }
        return s;
    }
}
