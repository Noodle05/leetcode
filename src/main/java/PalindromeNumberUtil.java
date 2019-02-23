/**
 * @author Wei Gao
 */
public class PalindromeNumberUtil {
    public static String nextPalindrome(String number) {
        if (number.length() == 1) {
            String n = Integer.toString(Integer.parseInt(number) + 1);
            if (n.length() == 2)
                return "11";
            return n;
        }
        int len = number.length();
        int middle = len / 2;
        String md = len % 2 == 1 ? number.substring(middle, middle + 1) : "";
        String firstHalf = number.substring(0, middle);
        String nfh = Long.toString(Long.parseLong(firstHalf) + 1);
        if (!md.isEmpty() && !"9".equals(md)) {
            md = Integer.toString(Integer.parseInt(md) + 1);
            nfh = firstHalf;
        }
        if (nfh.length() > firstHalf.length()) {
            if ("9".equals(md)) {
                md = "";
            } else {
                md = "0";
                nfh = nfh.substring(0, nfh.length() - 1);
            }
        } else if (!md.isEmpty() && "9".equals(md)) {
            md = "0";
        }
        String secondHalf = new StringBuilder(nfh).reverse().toString();
        return nfh + md + secondHalf;
    }

    public static String previousPalindrome(String number) {
        return null;
    }

    public static boolean isPalindrome(String str) {
        char[] chs = str.toCharArray();
        int l = 0, r = chs.length - 1;
        while (l < r) {
            if (chs[l] != chs[r])
                return false;
            l ++;
            r --;
        }
        return true;
    }
}
