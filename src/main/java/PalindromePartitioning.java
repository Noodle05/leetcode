import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * Given a string s, partition s such that every substring of the partition is a
 * palindrome.
 * </p>
 * <p>
 * Return all possible palindrome partitioning of s.
 * </p>
 * <p>
 * For example, given s = <font color="red">"aab"</font>,<br />
 * Return
 * 
 * <pre>
 *   [
 *     ["aa","b"],
 *     ["a","a","b"]
 *   ]
 * </pre>
 * 
 * </p>
 * 
 * @see <a
 *      href="https://oj.leetcode.com/problems/palindrome-partitioning/">Leetcode
 *      Palindrome Partitioning Problem</a>
 * @author Wei Gao
 *
 */
public class PalindromePartitioning {
    public ArrayList<ArrayList<String>> partition(String s) {
        Map<Integer, ArrayList<ArrayList<String>>> map = new HashMap<>();
        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = i + 1; j <= s.length(); j++) {
                String str = s.substring(i, j);
                if (isPalindrome(str)) {
                    ArrayList<ArrayList<String>> t = map.get(i);
                    if (t == null) {
                        t = new ArrayList<>();
                    }
                    if (j >= s.length()) {
                        ArrayList<String> tt = new ArrayList<>();
                        tt.add(str);
                        t.add(tt);
                    } else {
                        ArrayList<ArrayList<String>> tt = map.get(j);
                        for (ArrayList<String> st : tt) {
                            ArrayList<String> ss = new ArrayList<>();
                            ss.add(str);
                            ss.addAll(st);
                            t.add(ss);
                        }
                    }
                    map.put(i, t);
                }
            }
        }
        return map.get(0);
    }

    private boolean isPalindrome(String str) {
        int left = 0;
        int right = str.length() - 1;
        while (right > left) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
