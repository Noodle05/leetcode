import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class NQueensTest {
    private NQueens solution;

    @Before
    public void init() {
        solution = new NQueens();
    }

    @Test
    public void test1() {
        List<String[]> expected = new ArrayList<>();
        expected.add(new String[] { ".Q..", "...Q", "Q...", "..Q." });
        expected.add(new String[] { "..Q.", "Q...", "...Q", ".Q.." });
        List<String[]> actual = solution.solveNQueens(4);
        Assert.assertEquals(expected.size(), actual.size());
        for (int i = 0; i < expected.size(); i++) {
            Assert.assertArrayEquals(expected.get(i), actual.get(i));
        }
    }
}
