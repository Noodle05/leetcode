import org.junit.Assert;
import org.junit.Test;

public class CatAndMouseTest {
    private final CatAndMouse solution = new CatAndMouse();

    @Test
    public void test1() {
        int[][] graph = new int[][]{{2, 5}, {3}, {0, 4, 5}, {1, 4, 5}, {2, 3}, {0, 2, 3}};

        Assert.assertEquals(0, solution.catMouseGame(graph));
    }
}
