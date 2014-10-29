import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LongestSubstringWithoutRepeatingCharactersTest {
    private LongestSubstringWithoutRepeatingCharacters solution;

    @Before
    public void init() {
        solution = new LongestSubstringWithoutRepeatingCharacters();
    }

    @Test
    public void test1() {
        int actual = solution
                .lengthOfLongestSubstring("wlrbbmqbhcdarzowkkyhiddqscdxrjmowfrxsjybldbefsarcbynecdyggxxpklorellnmpapqfwkhopkmco");
        Assert.assertEquals(12, actual);
    }

    @Test
    public void test2() {
        int actual = solution
                .lengthOfLongestSubstring("qopubjguxhxdipfzwswybgfylqvjzhar");
        Assert.assertEquals(12, actual);
    }
}
