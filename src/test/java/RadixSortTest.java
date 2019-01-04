import org.junit.Assert;
import org.junit.Test;

public class RadixSortTest {
    private final RadixSort solvor = new RadixSort();

    @Test
    public void testBasic() {
        int[] data = {643, 612, 149, 84, 742, 591, 155, 507, 572, 799, 850, 303, 119, 884, 178, 936, 753, 552, 997, 514, 292, 819, 944, 170, 157, 222, 891, 615, 162, 637};
        int[] expected = {84, 119, 149, 155, 157, 162, 170, 178, 222, 292, 303, 507, 514, 552, 572, 591, 612, 615, 637, 643, 742, 753, 799, 819, 850, 884, 891, 936, 944, 997};

        int[] actual = solvor.radixSort(data);
        Assert.assertArrayEquals(expected, actual);
    }
}
