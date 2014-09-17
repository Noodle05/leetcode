import java.util.Arrays;
import java.util.List;

import junitx.framework.ListAssert;

import org.junit.Before;
import org.junit.Test;

public class RestoreIPAddressesTest {
    private RestoreIPAddresses solution;

    @Before
    public void init() {
        solution = new RestoreIPAddresses();
    }

    @Test
    public void test1() {
        List<String> expected = Arrays.asList("255.255.11.135",
                "255.255.111.35");
        List<String> actual = solution.restoreIpAddresses("25525511135");
        ListAssert.assertEquals(expected, actual);
    }

    @Test
    public void test2() {
        List<String> expected = Arrays.asList("0.10.0.10",
                "0.100.1.0");
        List<String> actual = solution.restoreIpAddresses("010010");
        ListAssert.assertEquals(expected, actual);
    }
}
