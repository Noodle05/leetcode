/**
 * 
 */


import java.util.Deque;
import java.util.LinkedList;

/**
 * <p>
 * Evaluate the value of an arithmetic expression in <a
 * href="http://en.wikipedia.org/wiki/Reverse_Polish_notation">Reverse Polish
 * Notation.</a>
 * </p>
 * <p>
 * Valid operators are <font color="red">+</font>, <font color="red">-</font>,
 * <font color="red">*</font>, <font color="red">/</font>. Each operand may be
 * an integer or another expression.<br />
 * </p>
 * <p>
 * Some examples: 
 * <pre> ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
 * ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6</pre>
 * </p>
 * 
 * @see <a
 *      href="https://oj.leetcode.com/problems/evaluate-reverse-polish-notation/">Leetcode
 *      Evaluate Reverse Polish Notation Problem</a>
 * @author Wei Gao
 *
 */
public class EvaluateReversePolishNotation {
  public int evalRPN(String[] tokens) {
    Deque<Integer> values = new LinkedList<>();
    int result;
    for (String token : tokens) {
      switch (token) {
      case "+": {
        int a = values.pop();
        int b = values.pop();
        int c = b + a;
        values.push(c);
        break;
      }
      case "-": {
        int a = values.pop();
        int b = values.pop();
        int c = b - a;
        values.push(c);
        break;
      }
      case "*": {
        int a = values.pop();
        int b = values.pop();
        int c = b * a;
        values.push(c);
        break;
      }
      case "/": {
        int a = values.pop();
        int b = values.pop();
        int c = b / a;
        values.push(c);
        break;
      }
      default: {
        int val = Integer.parseInt(token);
        values.push(val);
      }
      }
    }
    result = values.pop();
    return result;
  }
}
