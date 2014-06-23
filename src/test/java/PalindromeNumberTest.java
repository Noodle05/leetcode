import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PalindromeNumberTest {
    private PalindromeNumber solution;

    @Before
    public void init() {
        solution = new PalindromeNumber();
    }

    @Test
    public void test1() {
        assertFalse(solution.isPalindrome(10));
    }

    @Test
    public void test2() {
        assertTrue(solution.isPalindrome(1001));
    }
}
