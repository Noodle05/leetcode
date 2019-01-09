import org.junit.Assert;
import org.junit.Test;

/**
 * @author Wei Gao
 * @since 2019-01-09
 */
public class KMPSearchTest {
    private KMPSearch solution = new KMPSearch();

    @Test
    public void testLspTable1() {
        int[] expected = new int[] {0, 0, 1, 2, 3, 4, 0, 1, 2};
        int[] actual = solution.createLspTable("abababcab");

        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void testLspTable2() {
        int[] expected = new int[] {0, 0, 1, 2, 3, 0, 1};
        int[] actual = solution.createLspTable("ababaca");

        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void testLspTable3() {
        int[] expected = new int[] {0, 1, 0, 1, 0, 0, 0, 0, 0};
        int[] actual = solution.createLspTable("aababcdef");

        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void testLspTable4() {
        int[] expected = new int[] {0, 0, 0, 1, 2, 0, 1, 2, 3, 4, 5, 6};
        int[] actual = solution.createLspTable("abcabdabcabd");

        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void testKMPSearch1() {
        String s = "abcde";
        String t = "abcde";
        int actual = solution.search(s, t);

        Assert.assertEquals(0, actual);
    }

    @Test
    public void testKMPSearch2() {
        String s = "abcabcdabcdfabcdeabc";
        String t = "abcde";
        int actual = solution.search(s, t);

        Assert.assertEquals(12, actual);
    }

    @Test
    public void testKMPSearch3() {
        String s = "abcabcadabcabdfabcabdabeabc";
        String t = "abcabdabe";
        int actual = solution.search(s, t);

        Assert.assertEquals(15, actual);
    }

    @Test
    public void testKMPSearch4() {
        String s = "aabaabacaababcdabcdeaababcdef";
        String t = "aababcdef";
        int actual = solution.search(s, t);

        Assert.assertEquals(20, actual);
    }
}
