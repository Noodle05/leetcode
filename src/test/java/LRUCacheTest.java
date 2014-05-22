

import static org.junit.Assert.*;

import org.junit.Test;

public class LRUCacheTest {
  @Test(timeout = 10)
  public void test1() {
    LRUCache solution = new LRUCache(1);
    solution.set(2, 1);
    assertEquals(1, solution.get(2));
  }
}
