import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;


public class LetterCombinationsOfaPhoneNumberTest {
    private LetterCombinationsOfaPhoneNumber solution;
    
    @Before
    public void init() {
        solution = new LetterCombinationsOfaPhoneNumber();
    }

    @Test
    public void test() {
        List<String> result = solution.letterCombinations("23");
        List<String> expect = Arrays.asList("ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf");
        assertEquals(expect, result);
    }
}
