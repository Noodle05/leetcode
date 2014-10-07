/**
 * <p>
 * Validate if a given string is numeric.
 * </p>
 * 
 * <p>
 * Some examples:<br />
 * <font color="red">"0"</font> => <font color="red">true</font><br />
 * <font color="red">" 0.1 "</font> => <font color="red">true</font><br />
 * <font color="red">"abc"</font> => <font color="red">false</font><br />
 * <font color="red">"1 a"</font> => <font color="red">false</font><br />
 * <font color="red">"2e10"</font> => <font color="red">true</font><br />
 * </p>
 * <p>
 * <b>Note:</b> It is intended for the problem statement to be ambiguous. You
 * should gather all requirements up front before implementing one.
 * </p>
 * 
 * @see <a href="https://oj.leetcode.com/problems/valid-number/">Leetcode Valid
 *      Number Problem</a>
 * @author Wei Gao
 */
public class ValidNumber {
    public boolean isNumber(String s) {
        char[] chs = s.toCharArray();
        int index = 0;
        index += skipSpace(chs, index);
        if (index < chs.length && (chs[index] == '+' || chs[index] == '-')) {
            index++;
        }
        int n1 = getNumDigits(chs, index);
        index += n1;
        if (index < chs.length && chs[index] == '.') {
            index++;
        }
        int n2 = getNumDigits(chs, index);
        if (n1 + n2 == 0) {
            return false;
        }
        index += n2;
        if (index < chs.length && (chs[index] == 'E' || chs[index] == 'e')) {
            index++;
            if (index < chs.length && (chs[index] == '+' || chs[index] == '-')) {
                index++;
            }
            int n3 = getNumDigits(chs, index);
            if (n3 == 0) {
                return false;
            }
            index += n3;
        }
        index += skipSpace(chs, index);
        if (index < chs.length) {
            return false;
        } else {
            return true;
        }
    }

    private int skipSpace(char[] chs, int offset) {
        int num = 0;
        for (int i = offset; i < chs.length; i++) {
            if (chs[i] == ' ') {
                num++;
            } else {
                break;
            }
        }
        return num;
    }

    private int getNumDigits(char[] chs, int offset) {
        int num = 0;
        for (int i = offset; i < chs.length; i++) {
            if (chs[i] >= '0' && chs[i] <= '9') {
                num++;
            } else {
                break;
            }
        }
        return num;
    }
}
