import org.junit.Assert;
import org.junit.Test;

public class SuperWashMachinesTest {
    private final SuperWashMachines solution = new SuperWashMachines();

    @Test
    public void test1() {
        int[] machines = {0, 0, 11, 5};
        int expected = 8;
        int actual = solution.findMinMoves(machines);

        Assert.assertEquals(expected, actual);
    }
}
