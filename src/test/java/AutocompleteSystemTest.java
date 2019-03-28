import junitx.framework.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class AutocompleteSystemTest {
    @Test
    public void test1() {
        String[] strs = new String[]{"i love leetcode", "ironman", "island", "i love you"};
        int[] times = new int[]{2, 2, 3, 5};
        AutocompleteSystem solution = new AutocompleteSystem(strs, times);
        List<String> actual = solution.input('i');
        Assert.assertEquals(Arrays.asList("i love you", "island", "i love leetcode"), actual);
        actual = solution.input(' ');
        Assert.assertEquals(Arrays.asList("i love you", "i love leetcode"), actual);
        actual = solution.input('a');
        Assert.assertTrue(actual.isEmpty());
        actual = solution.input('#');
        Assert.assertTrue(actual.isEmpty());
        solution.input('i');
        actual = solution.input(' ');
        Assert.assertEquals(Arrays.asList("i love you", "i love leetcode", "i a"), actual);
        solution.input('a');
        solution.input('#');
        solution.input('i');
        solution.input(' ');
        solution.input('a');
        solution.input('#');
        solution.input('i');
        solution.input(' ');
        solution.input('a');
        solution.input('#');
        solution.input('i');
        solution.input(' ');
        solution.input('a');
        solution.input('#');
        solution.input('i');
        solution.input(' ');
        solution.input('a');
        solution.input('#');
        solution.input('i');
        solution.input(' ');
        solution.input('a');
        solution.input('#');
        actual = solution.input('i');
        Assert.assertEquals(Arrays.asList("i a", "i love you", "island"), actual);
    }
}
