/**
 * <p>
 * Implement atoi to convert a string to an integer.
 * </p>
 * 
 * <p>
 * Hint: Carefully consider all possible input cases. If you want a challenge,
 * please do not see below and ask yourself what are the possible input cases.
 * </p>
 * 
 * <p>
 * Notes: It is intended for this problem to be specified vaguely (ie, no given
 * input specs). You are responsible to gather all the input requirements up
 * front.
 * </p>
 * 
 * <p>
 * <p>
 * spoilers alert... requirements for atoi.
 * </p>
 * 
 * <b>Requirements for atoi:</b><br />
 * <p>
 * The function first discards as many whitespace characters as necessary until
 * the first non-whitespace character is found. Then, starting from this
 * character, takes an optional initial plus or minus sign followed by as many
 * numerical digits as possible, and interprets them as a numerical value.
 * </p>
 * 
 * <p>
 * The string can contain additional characters after those that form the
 * integral number, which are ignored and have no effect on the behavior of this
 * function.
 * </p>
 * 
 * <p>
 * If the first sequence of non-whitespace characters in str is not a valid
 * integral number, or if no such sequence exists because either str is empty or
 * it contains only whitespace characters, no conversion is performed.
 * </p>
 * 
 * <p>
 * If no valid conversion could be performed, a zero value is returned. If the
 * correct value is out of the range of representable values, INT_MAX
 * (2147483647) or INT_MIN (-2147483648) is returned.
 * </p>
 * </p>
 * 
 * @see <a
 *      href="https://oj.leetcode.com/problems/string-to-integer-atoi/">Leetcode
 *      String to Integer (atoi) Problem</a>
 * @author Wei Gao
 */
public class StringToInteger {
    public int atoi(String str) {
        int index = 0;
        char[] chs = str.toCharArray();
        // Skip white space
        while (index < chs.length && chs[index] == ' ') {
            index++;
        }
        boolean negative = false;
        if (index < chs.length && (chs[index] == '+' || chs[index] == '-')) {
            if (chs[index] == '-') {
                negative = true;
            }
            index++;
        }
        int value = 0;
        while (index < chs.length) {
            if (chs[index] >= '0' && chs[index] <= '9') {
                int v = chs[index] - '0';
                if (value > Integer.MAX_VALUE / 10
                        || value == Integer.MAX_VALUE / 10 && v > 7) {
                    return negative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
                }
                value *= 10;
                value += v;
            } else {
                break;
            }
            index++;
        }
        if (value > 0) {
            if (negative) {
                return 0 - value;
            }
        }
        return value;
    }
}
