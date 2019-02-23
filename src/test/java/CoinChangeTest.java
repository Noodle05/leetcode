import org.junit.Assert;
import org.junit.Test;

/**
 * @author Wei Gao
 * @since 2019-01-11
 */
public class CoinChangeTest {
    private final CoinChange solution = new CoinChange();

    @Test
    public void test1() {
        Assert.assertEquals(20, solution.coinChange(new int[]{186, 419, 83, 408}, 6249));
    }
}
