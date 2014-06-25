import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * Given n pairs of parentheses, write a function to generate all combinations
 * of well-formed parentheses.
 * </p>
 * <p>
 * <p>
 * For example, given n = 3, a solution set is:
 * </p>
 * 
 * <p>
 * <font color="red">"((()))", "(()())", "(())()", "()(())", "()()()"</font>
 * </p>
 * </p>
 * 
 * @see <a
 *      href="https://oj.leetcode.com/problems/generate-parentheses/">Leetcode
 *      Generate Parentheses Problem</a>
 * @author Wei Gao
 */
public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generateParenthesis(n, 0, 0, "", result);
        return result;
    }

    private void generateParenthesis(int n, int left, int right, String s,
            List<String> result) {
        if (left < right) {
            return;
        }
        if (left == n && right == n) {
            result.add(s);
            return;
        }
        if (left == n) {
            generateParenthesis(n, left, right + 1, s + ")", result);
            return;
        }
        generateParenthesis(n, left + 1, right, s + "(", result);
        generateParenthesis(n, left, right + 1, s + ")", result);
    }
}
