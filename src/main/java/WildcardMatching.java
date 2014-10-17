/**
 * <p>
 * Implement wildcard pattern matching with support for <font
 * color="red">'?'</font> and <font color="red">'*'</font>.
 * </p>
 * 
 * <p>
 * 
 * <pre>
 * '?' Matches any single character.
 * '*' Matches any sequence of characters (including the empty sequence).
 * 
 * The matching should cover the entire input string (not partial).
 * 
 * The function prototype should be:
 * bool isMatch(const char *s, const char *p)
 * 
 * Some examples:
 * isMatch("aa","a") → false
 * isMatch("aa","aa") → true
 * isMatch("aaa","aa") → false
 * isMatch("aa", "*") → true
 * isMatch("aa", "a*") → true
 * isMatch("ab", "?*") → true
 * isMatch("aab", "c*a*b") → false
 * </pre>
 * 
 * </p>
 * 
 * @see <a href="https://oj.leetcode.com/problems/wildcard-matching/">Leetcode
 *      Wildcard Matching Problem</a>
 * @author Wei Gao
 */
public class WildcardMatching {
    public boolean isMatch(String s, String p) {
        return isMatch(s.toCharArray(), p.toCharArray(), 0, 0);
    }

    private boolean isMatch(char[] s, char[] p, int spos, int ppos) {
        if (spos == s.length && ppos == p.length) // Both empty
            return true;
        if (ppos == p.length)
            return false;
        if (spos < s.length && p[ppos] == s[spos]) // Match
            return isMatch(s, p, spos + 1, ppos + 1);
        else if (p[ppos] == '?' && spos < s.length) // ? wired match?
            return isMatch(s, p, spos + 1, ppos + 1);
        else if (p[ppos] == '*') {
            boolean ret = false;
            while (ppos < p.length && p[ppos] == '*')
                // Skip '*'
                ppos++;
            if (ppos == p.length) // Pattern end with '*'
                return true;
            while (spos < s.length) {
                int ts = spos, ps = ppos;
                // Skip match characters
                while (ts < s.length && ps < p.length
                        && (s[ts] == p[ps] || p[ps] == '?')) {
                    if (p[ps] == '*')
                        break;
                    ts++;
                    ps++;
                }
                if (ts == s.length && ps == p.length) // Both empty
                    return true;
                if (ps < p.length && p[ps] == '*') {
                    ret |= isMatch(s, p, ts, ps);
                    return ret;
                }
                if (ts == s.length)
                    return false;
                spos++;
            }
            return ret;
        } else
            return false;
    }
}
