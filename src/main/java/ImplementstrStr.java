/**
 * <p>
 * Implement strStr().
 * </p>
 * 
 * <p>
 * Returns a pointer to the first occurrence of needle in haystack, or
 * <b>null</b> if needle is not part of haystack.
 * </p>
 * 
 * @see <a href="https://oj.leetcode.com/problems/implement-strstr/">Leetcode
 *      Implement strStr() Problem</a>
 * @author Wei Gao
 */
public class ImplementstrStr {
    public String strStr(String haystack, String needle) {
        int position = searchSubstring(haystack.toCharArray(),
                needle.toCharArray());
        if (position < haystack.length()) {
            return haystack.substring(position);
        }
        return null;
    }

    int searchSubstring(char[] S, char[] W) {
        int[] T = parialMatchTable(W);
        int m = 0, i = 0;
        while (m + i < S.length) {
            if (W[i] == S[m + i]) {
                if (i == W.length - 1) {
                    return m;
                } else {
                    i++;
                }
            } else {
                if (T[i] > -1) {
                    m = m + i - T[i];
                    i = T[i];
                } else {
                    i = 0;
                    m++;
                }
            }
        }
        return S.length;
    }

    int[] parialMatchTable(char[] chars) {
        int[] result = new int[chars.length];
        if (chars.length > 0) {
            result[0] = -1;
            if (chars.length > 1) {
                result[1] = 0;
                int m = 0;
                for (int i = 1; i < chars.length - 1; i++) {
                    if (chars[m] == chars[i]) {
                        result[i + 1] = result[i] + 1;
                        m++;
                    } else {
                        if (m > 0) {
                            m = 0;
                            if (chars[m] == chars[i]) {
                                result[i] = 1;
                                m++;
                            }
                        }
                    }
                }
            }
        }

        return result;
    }
}
