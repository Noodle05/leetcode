/**
 * @author Wei Gao
 * @since 2019-01-08
 */
public class KMPSearch {
    public int search(String s, String t) {
        int[] lsp = createLspTable(t);

        char[] ss = s.toCharArray();
        char[] ts = t.toCharArray();

        int tp = 0;
        int i = 0;
        while (i < ss.length) {
            if (ss[i] == ts[tp]) {
                i ++;
                if ((++ tp) == ts.length) {
                    return i - tp;
                }
            } else if (tp == 0) {
                i ++;
            } else {
                tp = lsp[tp - 1];
            }
        }

        return -1;
    }

    int[] createLspTable(String s) {
        int[] lsp = new int[s.length()];

        char[] chs = s.toCharArray();
        int i = 1, j = 0;
        while (i < chs.length) {
            if (chs[i] == chs[j]) {
                lsp[i ++] = ++j;
            } else {
                if (j != 0) {
                    j = lsp[j - 1];
                } else {
                    lsp[i ++] = 0;
                }
            }
        }
        return lsp;
    }
}
