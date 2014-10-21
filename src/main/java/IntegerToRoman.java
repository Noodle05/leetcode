/**
 * <p>
 * Given an integer, convert it to a roman numeral.
 * </p>
 * 
 * <p>
 * Input is guaranteed to be within the range from 1 to 3999.
 * </p>
 * 
 * @see <a href="https://oj.leetcode.com/problems/integer-to-roman/">Leetcode
 *      Integer to Roman Problem</a>
 * @author Wei Gao
 */
public class IntegerToRoman {
    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        int t = num / 1000;
        num %= 1000;
        for (int i = 0; i < t; i++) {
            sb.append('M');
        }
        t = num / 100;
        num %= 100;
        helper(t, sb, 'C', 'D', 'M');
        t = num / 10;
        num %= 10;
        helper(t, sb, 'X', 'L', 'C');
        t = num;
        helper(t, sb, 'I', 'V', 'X');

        return sb.toString();
    }

    private void helper(int num, StringBuilder sb, char single, char five,
            char ten) {
        if (num == 9) {
            sb.append(single).append(ten);
        } else {
            if (num >= 5) {
                sb.append(five);
                num -= 5;
            }
            if (num == 4) {
                sb.append(single).append(five);
                num -= 4;
            }
            for (int i = 0; i < num; i++) {
                sb.append(single);
            }
        }
    }
}
