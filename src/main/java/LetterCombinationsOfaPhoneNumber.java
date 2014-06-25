import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * Given a digit string, return all possible letter combinations that the number
 * could represent.
 * </p>
 * 
 * <p>
 * A mapping of digit to letters (just like on the telephone buttons) is given
 * below.
 * </p>
 * <img src=
 * "http://upload.wikimedia.org/wikipedia/commons/thumb/7/73/Telephone-keypad2.svg/200px-Telephone-keypad2.svg.png"
 * />
 * 
 * <pre>
 * Input:Digit string "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * </pre>
 * <p>
 * <b>Note:</b><br />
 * Although the above answer is in lexicographical order, your answer could be
 * in any order you want.
 * </p>
 * 
 * @see <a
 *      href="https://oj.leetcode.com/problems/letter-combinations-of-a-phone-number/">Leetcode
 *      Letter Combinations of a Phone Number Problem</a>
 * @author Wei Gao
 */
public class LetterCombinationsOfaPhoneNumber {
    private static final Map<Character, List<Character>> maps = new HashMap<>(
            12);

    static {
        maps.put('1', Collections.emptyList());
        maps.put('2', Arrays.asList('a', 'b', 'c'));
        maps.put('3', Arrays.asList('d', 'e', 'f'));
        maps.put('4', Arrays.asList('g', 'h', 'i'));
        maps.put('5', Arrays.asList('j', 'k', 'l'));
        maps.put('6', Arrays.asList('m', 'n', 'o'));
        maps.put('7', Arrays.asList('p', 'q', 'r', 's'));
        maps.put('8', Arrays.asList('t', 'u', 'v'));
        maps.put('9', Arrays.asList('w', 'x', 'y', 'z'));
        maps.put('0', Arrays.asList(' '));
        maps.put('*', Arrays.asList('+'));
        maps.put('#', Collections.emptyList());
    }

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.isEmpty()) {
            return Collections.emptyList();
        }
        List<String> result = new ArrayList<>();
        Deque<Character> stack = new ArrayDeque<>();
        int i = 0;
        letterCombinations(digits, i, stack, result);
        return result;
    }

    private void letterCombinations(String digits, int position,
            Deque<Character> stack, List<String> result) {
        if (position > digits.length() - 1) {
            StringBuilder sb = new StringBuilder();
            Iterator<Character> ite = stack.descendingIterator();
            while (ite.hasNext()) {
                sb.append(ite.next());
            }
            result.add(sb.toString());
        } else {
            List<Character> chs = maps.get(digits.charAt(position));
            if (!chs.isEmpty()) {
                for (char ch : chs) {
                    stack.push(ch);
                    letterCombinations(digits, position + 1, stack, result);
                    stack.pop();
                }
            }
        }
    }
}
