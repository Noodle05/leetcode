import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class RedBlackTreeTest {
  @Test(timeout = 500)
  public void test() {
    RedBlackTree<Integer, Integer> t = new RedBlackTree<Integer, Integer>();
    // t.print();

    java.util.Random gen = new java.util.Random();

    for (int i = 0; i < 5000; i++) {
      int x = gen.nextInt(10000);
      int y = gen.nextInt(10000);

      // t.print();
      // System.out.println("Inserting " + x + " -> " + y);
      // System.out.println();

      t.insert(x, y);
      assertEquals((Integer) y, t.lookup(x));
    }
    for (int i = 0; i < 60000; i++) {
      int x = gen.nextInt(10000);

      // t.print();
      // System.out.println("Deleting key " + x);
      // System.out.println();

      t.delete(x);
    }
  }
}
