import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BestTimeToBuyAndSellStockIIITest {
    private BestTimeToBuyAndSellStockIII solution;
    
    @Before
    public void init() {
        solution = new BestTimeToBuyAndSellStockIII();
    }
    
    @Test
    public void test1() {
        int[] prices = new int[] {1, 2};
        Assert.assertEquals(1, solution.maxProfit(prices));
    }
    
    @Test
    public void test2() {
        int[] prices = new int[] {2, 1, 2, 0, 1};
        Assert.assertEquals(2, solution.maxProfit(prices));
    }
    
    @Test
    public void test3() {
        int[] prices = new int[] {6, 1, 3, 2, 4, 7};
        Assert.assertEquals(7, solution.maxProfit(prices));
    }
}
