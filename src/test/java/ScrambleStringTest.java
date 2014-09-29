import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ScrambleStringTest {
    private ScrambleString solution;

    @Before
    public void init() {
        solution = new ScrambleString();
    }

    @Test
    public void test1() {
        Assert.assertTrue(solution.isScramble("rgtae", "great"));
    }

    @Test
    public void test2() {
        Assert.assertTrue(solution.isScramble("xstjzkfpkggnhjzkpfjoguxvkbuopi",
                "xbouipkvxugojfpkzjhnggkpfkzjts"));
    }
}
