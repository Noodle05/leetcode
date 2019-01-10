import org.junit.Assert;
import org.junit.Test;

public class JumpGameIITest {
    private final JumpGameII solution = new JumpGameII();

    @Test
    public void test1() {
        Assert.assertEquals(2, solution.jump(new int[] {2, 3, 1, 1, 4}));
    }
}
