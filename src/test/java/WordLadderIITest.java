import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import junitx.framework.ListAssert;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class WordLadderIITest {
    private WordLadderII solution;

    @Before
    public void init() {
        solution = new WordLadderII();
    }

    @Test
    public void test1() {
        List<List<String>> expect = new ArrayList<>();
        expect.add(Arrays.asList("a", "c"));
        Set<String> dict = new HashSet<>();
        dict.addAll(Arrays.asList("a", "b", "c"));
        List<List<String>> result = solution.findLadders("a", "c", dict);
        ListAssert.assertEquals(expect, result);
    }

    @Test
    public void test2() {
        List<List<String>> expect = new ArrayList<>();
        expect.add(Arrays.asList("hit", "hot", "dot", "dog", "cog"));
        expect.add(Arrays.asList("hit", "hot", "lot", "log", "cog"));
        Set<String> dict = new HashSet<>();
        dict.addAll(Arrays.asList("hot", "dot", "dog", "lot", "log"));
        List<List<String>> result = solution.findLadders("hit", "cog", dict);
        ListAssert.assertEquals(expect, result);
    }
}
