import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * <p>
 * You are given a string, <b>S</b>, and a list of words, <b>L</b>, that are all
 * of the same length. Find all starting indices of substring(s) in S that is a
 * concatenation of each word in L exactly once and without any intervening
 * characters.
 * </p>
 * 
 * <p>
 * For example, given:<br />
 * <b>S</b>: <font color="red">"barfoothefoobarman"</font><br />
 * <b>L</b>: <font color="red">["foo", "bar"]</font>
 * </p>
 * 
 * <p>
 * You should return the indices: <font color="red">[0,9]</font>.<br />
 * (order does not matter).
 * </p>
 * 
 * @see <a
 *      href="https://oj.leetcode.com/problems/substring-with-concatenation-of-all-words/">Leetcode
 *      Substring with Concatenation of All Words Problem</a>
 * @author Wei Gao
 */
public class SubstringWithConcatenationOfAllWords {
    /**
     * <p>
     * The words are all of the same width, Hence the dictionary will be the
     * same for overlapping valid substrings (Ex: "foobarisbarfoobar"
     * ["foo","bar"]) in which the "barfoobar" has overlapping valid substrings
     * "barfoo" and "foobar" and both have same dictionary.Thus we need not
     * construct the dictionary again, instead reuse the dictionary with some
     * proper cases.
     * </p>
     * 
     * <p>
     * Secondly instead of traversing the string character by character we can
     * traverse it in the form of words by words( w increments) fot the above
     * purpose. then do the same for the a character shifted to find out the
     * valid strings there.
     * </p>
     * 
     * <p>
     * Ex: the same above one will be traversed as "foo" "bar" "isb" "arf" "oob"
     * "ar" on the first iteration and then "oob" "ari" "sba" "rfo" "oba" "r"
     * and next "oba" "ris" "bar" "foo" "bar" next.
     * </p>
     * 
     * <p>
     * This will reduce the need for construction of Dictionaries O(n) times
     * instead we do it O(w) times. and we will be making a total of O(n)
     * iterations with O(w) string comparision operations each time, hence a
     * time complexity of O(nw) and an auxiliaty space of O(lw)
     * </p>
     * 
     * <p>
     * The algorithm works like this
     * 
     * <pre>
     *     a) initially store the number of occurences of each word in Hash table "cn".
     *     b) For i = 0 to w
     *           start = i; 
     *           For w : all words at intervals i, i+w, i+2w, .. n
     *            i) check if word w is  valid, if not set start to next word as the substring uptil now will be invalid.
     * 
     *           ii) if word is valid, check the number of occurences of this word in the substring  is less than availbale words
     *          increment  count of the word in the hash table cntL 
     * 
     *         iii) if the word is valid , but already occured maximum number of times, then consider the substring starting after the first occurence of this word.set start.
     * 
     *         if (all the dictionary words are used then store the start as the valid substring start.
     * </pre>
     * 
     * </p>
     * 
     * @param S
     * @param L
     * @return
     */
    public List<Integer> findSubstring(String S, String[] L) {
        List<Integer> result = new ArrayList<>();
        if (S == null || L == null || S.length() == 0 || L.length == 0)
            return result;
        // creat a dict of T
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for (String s : L) {
            if (map.containsKey(s)) {
                map.put(s, map.get(s) + 1);
            } else {
                map.put(s, 1);
            }
        }
        int wordLen = L[0].length();
        // start matching, traverse S
        for (int i = 0; i < wordLen; i++) {
            int count = 0;
            int left = i;
            // creat a new dict for current index
            HashMap<String, Integer> curMap = new HashMap<>();
            for (int j = i; j <= S.length() - wordLen; j += wordLen) {
                String str = S.substring(j, j + wordLen);
                if (map.containsKey(str)) {
                    // update the current dict
                    if (curMap.containsKey(str))
                        curMap.put(str, curMap.get(str) + 1);
                    else
                        curMap.put(str, 1);
                    // check with original dict
                    count++;
                    if (curMap.get(str) > map.get(str)) {
                        while (curMap.get(str) > map.get(str)) {
                            String temp = S.substring(left, left + wordLen);
                            curMap.put(temp, curMap.get(temp) - 1);
                            left += wordLen;
                            count--;
                        }
                    }
                    // check whether find a mathch
                    if (count == L.length) {
                        result.add(left);
                        String temp = S.substring(left, left + wordLen);
                        curMap.put(temp, curMap.get(temp) - 1);
                        count--;
                        left += wordLen;
                    }
                } else {
                    curMap.clear();
                    count = 0;
                    left = j + wordLen;
                }
            }
        }
        return result;
    }
}
