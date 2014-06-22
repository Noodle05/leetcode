/**
 * <p>
 * Determine whether an integer is a palindrome. Do this without extra space.
 * </p>
 * 
 * <p>
 * <b>Some hints:</b><br />
 * Could negative integers be palindromes? (ie, -1)<br />
 * <p>
 * If you are thinking of converting the integer to string, note the restriction
 * of using extra space.
 * </p>
 * <p>
 * You could also try reversing an integer. However, if you have solved the
 * problem "Reverse Integer", you know that the reversed integer might overflow.
 * How would you handle such case?
 * </p>
 * <p>
 * There is a more generic way of solving this problem.
 * </p>
 * </p>
 * 
 * @see <a href="https://oj.leetcode.com/problems/palindrome-number/">Leetcode
 *      Palindrome Number Problem</a>
 * @author Wei Gao
 */
public class PalindromeNumber {
  public boolean isPalindrome(int x) {
    if (x < 0) {
      return false;
    }
    int t = x;
    int digitals = 0;
    while (t > 0) {
      digitals++;
      t = t / 10;
    }
    t = x;
    while (digitals > 1) {
      int a = t % 10;
      int b = t;
      for (int i = 0; i < digitals - 1; i++) {
        b = b / 10;
      }
      if (a != b) {
        return false;
      }
      if (a > 0) {
        for (int i = 0; i < digitals - 1; i++) {
          a *= 10;
        }
      }
      t -= a;
      t /= 10;
      digitals -= 2;
    }
    return true;
  }
}
