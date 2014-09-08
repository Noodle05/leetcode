import java.util.ArrayList;
import java.util.Collection;

/**
 * <p>
 * Given a string, determine if it is a palindrome, considering only
 * alphanumeric characters and ignoring cases.
 * </p>
 * 
 * <p>
 * For example,<br />
 * <font color="red">"A man, a plan, a canal: Panama"</font> is a palindrome. <br />
 * <font color="red">"race a car"</font> is not a palindrome.
 * </p>
 * <p>
 * <b>Note:</b><br />
 * Have you consider that the string might be empty? This is a good question to
 * ask during an interview.
 * </p>
 * <p>
 * For the purpose of this problem, we define empty string as valid palindrome.
 * </p>
 * 
 * @see <a href="https://oj.leetcode.com/problems/valid-palindrome/">Leetcode
 *      Valid Palindrome Problem</a>
 * @author Wei Gao
 */
public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        Collection<Character> chs = new ArrayList<>(s.length());
        for (char ch : s.toLowerCase().toCharArray()) {
            if ((ch >= 'a' && ch <= 'z') || (ch >= '0' && ch <= '9')) {
                chs.add(ch);
            }
        }
        Character[] cs = new Character[chs.size()];
        chs.toArray(cs);
        int left = 0;
        int right = cs.length - 1;
        while (left < right) {
            if (!cs[left].equals(cs[right])) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
