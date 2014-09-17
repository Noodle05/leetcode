import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * <p>
 * Given a string containing only digits, restore it by returning all possible
 * valid IP address combinations.
 * </p>
 * 
 * <p>
 * For example:<br />
 * Given <font color="red">"25525511135"</font>,<br />
 * 
 * return <font color="red">["255.255.11.135", "255.255.111.35"]</font>. (Order
 * does not matter)
 * </p>
 * 
 * @see <a
 *      href="https://oj.leetcode.com/problems/restore-ip-addresses/">Leetcode
 *      Restore IP Addresses Problem</a>
 * @author Wei Gao
 */
public class RestoreIPAddresses {
    public List<String> restoreIpAddresses(String s) {
        return restoreIpAddresses(s.toCharArray(), 0, 4);
    }

    private List<String> restoreIpAddresses(char[] chs, int offset, int level) {
        if (offset >= chs.length) {
            return Collections.emptyList();
        }
        List<String> result = new ArrayList<>();

        if (level == 1) {
            if (validDigits(chs, offset, chs.length - offset)) {
                return Arrays.asList(new String(chs, offset, chs.length
                        - offset));
            } else {
                return Collections.emptyList();
            }
        }
        for (int i = 1; i <= (chs.length - offset < 3 ? chs.length - offset : 3); i++) {
            if (validDigits(chs, offset, i)) {
                List<String> tmp = restoreIpAddresses(chs, offset + i,
                        level - 1);
                if (!tmp.isEmpty()) {
                    for (String t : tmp) {
                        String s = new String(chs, offset, i);
                        result.add(s + "." + t);
                    }
                }
            }
        }

        return result;
    }

    private boolean validDigits(char[] chs, int offset, int length) {
        if (length > 3 || offset + length > chs.length) {
            return false;
        }
        int val = 0;
        for (int i = 0; i < length; i++) {
            val *= 10;
            val += chs[offset + i] - '0';
        }
        if (val > 255 || (val > 0 && chs[offset] == '0')
                || (val == 0 && length > 1)) {
            return false;
        }
        return true;
    }
}
