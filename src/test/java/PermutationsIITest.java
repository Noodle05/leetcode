import junitx.framework.ListAssert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class PermutationsIITest {
    private final PermutationsII solution = new PermutationsII();

    @Test
    public void test1() {
        List<List<Integer>> expected = Arrays.asList(Arrays.asList(1, 1, 2), Arrays.asList(1, 2, 1), Arrays.asList(2, 1, 1));

        ListAssert.assertEquals(expected, solution.permuteUnique(new int[] {1, 1, 2}));
    }
}
