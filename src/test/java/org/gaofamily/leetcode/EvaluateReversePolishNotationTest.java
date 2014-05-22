package org.gaofamily.leetcode;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class EvaluateReversePolishNotationTest {
  private EvaluateReversePolishNotation solution;
  
  @Before
  public void init() {
    solution = new EvaluateReversePolishNotation();
  }
  
  @Test
  public void test1() {
    String[] tokens = new String[] {"2", "1", "+", "3", "*"};
    int res = solution.evalRPN(tokens);
    assertEquals(9, res);
  }
  
  @Test
  public void test2() {
    String[] tokens = new String[] {"4", "13", "5", "/", "+"};
    int res = solution.evalRPN(tokens);
    assertEquals(6, res);
  }
}
