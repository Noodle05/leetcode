import org.junit.Assert;
import org.junit.Test;

public class CanIWinTest {
    private CanIWin solution = new CanIWin();

    @Test
    public void test1() {
        Assert.assertFalse(solution.canIWin(10, 11));
    }

    @Test
    public void test2() {
        Assert.assertFalse(solution.canIWin(20, 210));
    }
}
