/**
 * <p>
 * Given a non-negative number represented as an array of digits, plus one to
 * the number.
 * </p>
 * 
 * <p>
 * The digits are stored such that the most significant digit is at the head of
 * the list.
 * </p>
 * 
 * @see <a href="https://oj.leetcode.com/problems/plus-one/">Leetcode Plus One
 *      Problem</a>
 * @author Wei Gao
 */
public class PlusOne {
    public int[] plusOne(int[] digits) {
        boolean carry = false;
        int len = digits.length;
        digits[len - 1]++;
        if (digits[len - 1] > 9) {
            carry = true;
            digits[len - 1] -= 10;
        }
        for (int i = len - 2; i >= 0 && carry; i--) {
            digits[i]++;
            if (digits[i] > 9) {
                carry = true;
                digits[i] -= 10;
            } else {
                carry = false;
            }
        }
        if (carry) {
            int[] result = new int[len + 1];
            for (int i = 0; i < len; i++) {
                result[i + 1] = digits[i];
            }
            result[0] = 1;
            return result;
        } else {
            return digits;
        }
    }
}
