/**
 * <p>
 * A message containing letters from <font color="red">A-Z</font> is being
 * encoded to numbers using the following mapping:
 * 
 * <pre>
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * </pre>
 * 
 * Given an encoded message containing digits, determine the total number of
 * ways to decode it.
 * </p>
 * 
 * <p>
 * For example,<br />
 * Given encoded message <font color="red">"12"</font>, it could be decoded as
 * <font color="red">"AB"</font> (1 2) or <font color="red">"L"</font> (12).<br />
 * 
 * The number of ways decoding <font color="red">"12"</font> is 2.
 * </p>
 * 
 * @see <a href="https://oj.leetcode.com/problems/decode-ways/">Leetcode Decode
 *      Ways Problem</a>
 * @author Wei Gao
 */
public class DecodeWays {
    public int numDecodings(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        int c1 = 0;
        int c2 = 0;
        String d = s.substring(s.length() - 1, s.length());
        int v = Integer.valueOf(d);
        if (v > 0) {
            c1 = 1;
        }
        for (int i = s.length() - 2; i >= 0; i--) {
            int t = 0;
            d = s.substring(i, i + 1);
            v = Integer.valueOf(d);
            if (v > 0) {
                t += c1;
            }
            d = s.substring(i, i + 2);
            v = Integer.valueOf(d);
            if (v >= 10 && v <= 26) {
                if (i < s.length() - 2) {
                    t += c2;
                } else {
                    t++;
                }
            }
            c2 = c1;
            c1 = t;
        }
        return c1;
    }
}
