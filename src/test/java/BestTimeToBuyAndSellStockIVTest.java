import org.junit.Assert;
import org.junit.Test;

public class BestTimeToBuyAndSellStockIVTest {
    private final BestTimeToBuyAndSellStockIV solution = new BestTimeToBuyAndSellStockIV();

    @Test
    public void test1() {
        Assert.assertEquals(2, solution.maxProfit(2, new int[]{2, 4, 1}));
    }

    @Test
    public void test2() {
        Assert.assertEquals(7, solution.maxProfit(2, new int[]{3, 2, 6, 5, 0, 3}));
    }

    @Test
    public void test3() {
        Assert.assertEquals(27, solution.maxProfit(5, new int[]{5, 3, 2, 7, 11, 5, 3, 4, 9, 3, 4, 8, 7, 5, 10, 2, 4, 1}));
    }
}
