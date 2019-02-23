import org.junit.Assert;
import org.junit.Test;

public class PalindromeNumberUtilTest {
    @Test
    public void test1() {
        Assert.assertEquals("1001", PalindromeNumberUtil.nextPalindrome("999"));
        Assert.assertEquals("10001", PalindromeNumberUtil.nextPalindrome("9999"));
        Assert.assertEquals("111", PalindromeNumberUtil.nextPalindrome("101"));
        Assert.assertEquals("22", PalindromeNumberUtil.nextPalindrome("11"));
        Assert.assertEquals("8", PalindromeNumberUtil.nextPalindrome("7"));
        Assert.assertEquals("11", PalindromeNumberUtil.nextPalindrome("9"));
        Assert.assertEquals("565", PalindromeNumberUtil.nextPalindrome("555"));
        Assert.assertEquals("606", PalindromeNumberUtil.nextPalindrome("595"));
        Assert.assertEquals("100000000000001", PalindromeNumberUtil.nextPalindrome("99999999999999"));
        Assert.assertEquals("10000000000000000000000000001", PalindromeNumberUtil.nextPalindrome("9999999999999999999999999999"));
    }
}
