import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PalindromePartitioningTest {
    private PalindromePartitioning solution;

    @Before
    public void init() {
        solution = new PalindromePartitioning();
    }

    @Test
    public void test1() {
        ArrayList<ArrayList<String>> result = solution.partition("ab");
        ArrayList<ArrayList<String>> expect = new ArrayList<>();
        ArrayList<String> r = new ArrayList<>();
        r.add("a");
        r.add("b");
        expect.add(r);
        Assert.assertEquals(expect, result);
    }

    @Test
    public void test2() {
        ArrayList<ArrayList<String>> result = solution.partition("bb");
        ArrayList<ArrayList<String>> expect = new ArrayList<>();
        ArrayList<String> r = new ArrayList<>();
        r.add("b");
        r.add("b");
        expect.add(r);
        r = new ArrayList<>();
        r.add("bb");
        expect.add(r);
        Assert.assertEquals(expect, result);
    }
}
