/**
 * 
 */


/**
 * <p>
 * Given an input string, reverse the string word by word.<br />
 * </p>
 * <p>
 * For example, <br />
 * Given s = "<font color="red">the sky is blue</font>",<br />
 * return "<font color="red">blue is sky the</font>".
 * </p>
 * <p>
 * <b>Clarification:</b>
 * <ul>
 * <li>What constitutes a word?</li>
 * A sequence of non-space characters constitutes a word.
 * <li>Could the input string contain leading or trailing spaces?</li>
 * Yes. However, your reversed string should not contain leading or trailing
 * spaces.
 * <li>How about multiple spaces between two words?</li>
 * Reduce them to a single space in the reversed string.
 * </ul>
 * </p>
 * 
 * @see <a
 *      href="https://oj.leetcode.com/problems/reverse-words-in-a-string/">Leetcode
 *      Reverse Words in a String Problem</a>
 * @author Wei Gao
 */
public class ReverseWords {
  public String reverseWords(String s) {
    if (s == null) {
      return null;
    }
    boolean inWord = false;
    StringBuilder sb = new StringBuilder();
    int end = 0;
    boolean first = true;
    for (int i = s.length() - 1; i >= 0; i--) {
      char c = s.charAt(i);
      if (c != ' ') {
        if (inWord) {
          continue;
        } else {
          end = i + 1;
          inWord = true;
        }
      } else {
        if (inWord) {
          if (first) {
            first = false;
          } else {
            sb.append(' ');
          }
          sb.append(s.substring(i + 1, end));
          end = 0;
          inWord = false;
        } else {
          continue;
        }
      }
    }
    if (end > 0) {
      if (first) {
        first = false;
      } else {
        sb.append(' ');
      }
      sb.append(s.substring(0, end));
    }
    return sb.toString();
  }
}
