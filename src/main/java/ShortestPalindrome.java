/**
 * @author Wei Gao
 * @since 2019-01-09
 */
public class ShortestPalindrome {
    public String shortestPalindrome(String s) {
        String r = new StringBuilder(s).reverse().toString();
        String t = s + "#" + r;

        int[] lsp = createLspTable(t);
        int p = lsp[lsp.length - 1];

        String pre = "";
        if (p < s.length()) {
            pre = r.substring(0, r.length() - p);
        }

        return pre + s;
    }

    private int[] createLspTable(String s) {
        char[] chs = s.toCharArray();
        int[] lsp = new int[chs.length];

        int i = 1;
        int j = 0;
        while (i < chs.length) {
            if (chs[i] == chs[j]) {
                lsp[i ++] = ++ j;
            } else {
                if (j > 0) {
                    j = lsp[j - 1];
                } else {
                    lsp[i ++] = 0;
                }
            }
        }
        return lsp;
    }
}
