package org.gaofamily.leetcode;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class InsertionSortListTest {
  private InsertionSortList solution;
  
  @Before
  public void init() {
    solution  = new InsertionSortList();
  }

  @Test(timeout = 10)
  public void test1() {
    ListNode data = Utils.readListNode("1");
    ListNode result = solution.insertionSortList(data);
    assertEquals(Utils.readListNode("1"), result);
  }

  @Test(timeout = 10)
  public void test2() {
    ListNode data = Utils.readListNode("2, 1");
    ListNode result = solution.insertionSortList(data);
    assertEquals(Utils.readListNode("1, 2"), result);
  }

  @Test(timeout = 10)
  public void test3() {
    ListNode data = Utils.readListNode("1, 1");
    ListNode result = solution.insertionSortList(data);
    assertEquals(Utils.readListNode("1, 1"), result);
  }

  @Test(timeout = 10)
  public void test4() {
    ListNode data = Utils.readListNode("3, 2, 4");
    ListNode result = solution.insertionSortList(data);
    assertEquals(Utils.readListNode("2, 3, 4"), result);
  }
}
