/**
 * <p>
 * A <b>red-black tree</b> is a data structure which is a type of self-blanacing
 * binary search tree.
 * </p>
 * <p>
 * Balance is preserved by painting each node of the tree with one of two colors
 * (typically called 'red' and 'black') in a way that satisfies certain
 * properties, which collectively constrain how unbalanced the tree can become
 * in the worst case. When the tree is modified, the new tree is subsequently
 * rearranged and repainted to restore the coloring properties. The properties
 * are designed in such a way that this rearranging and recoloring can be
 * performed efficiently.
 * </p>
 * 
 * <p>
 * The balancing of the tree is not perfect but it is good enough to allow it to
 * guarantee searching in O(log n) time, where n is the total number of elements
 * in the tree. The insertion and deletion operations, along with the tree
 * rearrangement and recoloring, are also performed in O(log n) time.
 * </p>
 * 
 * @see <a href="http://en.wikipedia.org/wiki/Red%E2%80%93black_tree">Red Black
 *      Tree</a>
 * @author Wei Gao
 */
public class RedBlackTree<K extends Comparable<? super K>, V> {
  public static final boolean VERIFY_RBTREE = true;
  // private static final int INDENT_STEP = 4;

  private RedBlackTreeNode<K, V> root;

  public RedBlackTree() {
    root = null;
    verifyProperties();
  }

  public void verifyProperties() {
    if (VERIFY_RBTREE) {
      verifyProperty1(root);
      verifyProperty2(root);
      verifyProperty4(root);
      verifyProperty5(root);
    }
  }

  private RedBlackTreeNode<K, V> lookupNode(K key) {
    RedBlackTreeNode<K, V> n = root;
    while (n != null) {
      int compResult = key.compareTo(n.key);
      if (compResult == 0) {
        return n;
      } else if (compResult < 0) {
        n = n.left;
      } else {
        assert compResult > 0;
        n = n.right;
      }
    }
    return n;
  }

  public V lookup(K key) {
    RedBlackTreeNode<K, V> n = lookupNode(key);
    return n == null ? null : n.value;
  }

  private void rotateLeft(RedBlackTreeNode<K, V> n) {
    RedBlackTreeNode<K, V> r = n.right;
    replaceNode(n, r);
    n.right = r.left;
    if (r.left != null) {
      r.left.parent = n;
    }
    r.left = n;
    n.parent = r;
  }

  private void rotateRight(RedBlackTreeNode<K, V> n) {
    RedBlackTreeNode<K, V> l = n.left;
    replaceNode(n, l);
    n.left = l.right;
    if (l.right != null) {
      l.right.parent = n;
    }
    l.right = n;
    n.parent = l;
  }

  private void replaceNode(RedBlackTreeNode<K, V> oldn,
      RedBlackTreeNode<K, V> newn) {
    if (oldn.parent == null) {
      root = newn;
    } else {
      if (oldn == oldn.parent.left)
        oldn.parent.left = newn;
      else
        oldn.parent.right = newn;
    }
    if (newn != null) {
      newn.parent = oldn.parent;
    }
  }

  public void insert(K key, V value) {
    RedBlackTreeNode<K, V> insertedNode = new RedBlackTreeNode<K, V>(key,
        value, COLOR.RED, null, null);
    if (root == null) {
      root = insertedNode;
    } else {
      RedBlackTreeNode<K, V> n = root;
      while (true) {
        int compResult = key.compareTo(n.key);
        if (compResult == 0) {
          n.value = value;
          return;
        } else if (compResult < 0) {
          if (n.left == null) {
            n.left = insertedNode;
            break;
          } else {
            n = n.left;
          }
        } else {
          assert compResult > 0;
          if (n.right == null) {
            n.right = insertedNode;
            break;
          } else {
            n = n.right;
          }
        }
      }
      insertedNode.parent = n;
    }
    insertCase1(insertedNode);
    verifyProperties();
  }

  /**
   * <p>
   * <b>Case 1:</b> The current node N is at the root of the tree. In this case,
   * it is repainted black to satisfy property 2 (the root is black). Since this
   * adds one black node to every path at once, property 5 (all paths from any
   * given node to its leaf nodes contain the same number of black nodes) is not
   * violated.
   * </p>
   * 
   * @param n
   */
  private void insertCase1(RedBlackTreeNode<K, V> n) {
    if (n.parent == null)
      n.color = COLOR.BLACK;
    else
      insertCase2(n);
  }

  /**
   * <p>
   * <b>Case 2:</b> The current node's parent P is black, so property 4 (both
   * children of every red node are black) is not invalidated. In this case, the
   * tree is still valid. Property 5 (all paths from any given node to its leaf
   * nodes contain the same number of black nodes) is not threatened, because
   * the current node N has two black leaf children, but because N is red, the
   * paths through each of its children have the same number of black nodes as
   * the path through the leaf it replaced, which was black, and so this
   * property remains satisfied.
   * </p>
   * 
   * @param n
   */
  private void insertCase2(RedBlackTreeNode<K, V> n) {
    if (nodeColor(n.parent) == COLOR.BLACK)
      return; // Tree is still valid
    else
      insertCase3(n);
  }

  /**
   * <p>
   * <b>Case 3:</b> If both the parent P and the uncle U are red, then both of
   * them can be repainted black and the grandparent G becomes red (to maintain
   * property 5 (all paths from any given node to its leaf nodes contain the
   * same number of black nodes)). Now, the current red node N has a black
   * parent. Since any path through the parent or uncle must pass through the
   * grandparent, the number of black nodes on these paths has not changed.
   * However, the grandparent G may now violate properties 2 (The root is black)
   * or 4 (Both children of every red node are black) (property 4 possibly being
   * violated since G may have a red parent). To fix this, the entire procedure
   * is recursively performed on G from case 1. Note that this is a
   * tail-recursive call, so it could be rewritten as a loop; since this is the
   * only loop, and any rotations occur after this loop, this proves that a
   * constant number of rotations occur.
   * </p>
   * 
   * @param n
   */
  private void insertCase3(RedBlackTreeNode<K, V> n) {
    if (nodeColor(n.uncle()) == COLOR.RED) {
      n.parent.color = COLOR.BLACK;
      n.uncle().color = COLOR.BLACK;
      n.grandparent().color = COLOR.RED;
      insertCase1(n.grandparent());
    } else {
      insertCase4(n);
    }
  }

  /**
   * <p>
   * <b>Case 4:</b> The parent P is red but the uncle U is black; also, the
   * current node N is the right child of P, and P in turn is the left child of
   * its parent G. In this case, a left rotation on P that switches the roles of
   * the current node N and its parent P can be performed; then, the former
   * parent node P is dealt with using case 5 (relabeling N and P) because
   * property 4 (both children of every red node are black) is still violated.
   * The rotation causes some paths (those in the sub-tree labelled "1") to pass
   * through the node N where they did not before. It also causes some paths
   * (those in the sub-tree labelled "3") not to pass through the node P where
   * they did before. However, both of these nodes are red, so property 5 (all
   * paths from any given node to its leaf nodes contain the same number of
   * black nodes) is not violated by the rotation. After this case has been
   * completed, property 4 (both children of every red node are black) is still
   * violated, but now we can resolve this by continuing to case 5.
   * </p>
   * 
   * @param n
   */
  private void insertCase4(RedBlackTreeNode<K, V> n) {
    if (n == n.parent.right && n.parent == n.grandparent().left) {
      rotateLeft(n.parent);
      n = n.left;
    } else if (n == n.parent.left && n.parent == n.grandparent().right) {
      rotateRight(n.parent);
      n = n.right;
    }
    insertCase5(n);
  }

  /**
   * <p>
   * <b>Case 5:</b> The parent P is red but the uncle U is black, the current
   * node N is the left child of P, and P is the left child of its parent G. In
   * this case, a right rotation on G is performed; the result is a tree where
   * the former parent P is now the parent of both the current node N and the
   * former grandparent G. G is known to be black, since its former child P
   * could not have been red otherwise (without violating property 4). Then, the
   * colors of P and G are switched, and the resulting tree satisfies property 4
   * (both children of every red node are black). Property 5 (all paths from any
   * given node to its leaf nodes contain the same number of black nodes) also
   * remains satisfied, since all paths that went through any of these three
   * nodes went through G before, and now they all go through P. In each case,
   * this is the only black node of the three.
   * </p>
   * 
   * @param n
   */
  void insertCase5(RedBlackTreeNode<K, V> n) {
    n.parent.color = COLOR.BLACK;
    n.grandparent().color = COLOR.RED;
    if (n == n.parent.left && n.parent == n.grandparent().left) {
      rotateRight(n.grandparent());
    } else {
      assert n == n.parent.right && n.parent == n.grandparent().right;
      rotateLeft(n.grandparent());
    }
  }

  public void delete(K key) {
    RedBlackTreeNode<K, V> n = lookupNode(key);
    if (n == null)
      return; // Key not found, do nothing
    if (n.left != null && n.right != null) {
      // Copy key/value from predecessor and then delete it instead
      RedBlackTreeNode<K, V> pred = maximumNode(n.left);
      n.key = pred.key;
      n.value = pred.value;
      n = pred;
    }

    assert n.left == null || n.right == null;
    RedBlackTreeNode<K, V> child = (n.right == null) ? n.left : n.right;
    if (nodeColor(n) == COLOR.BLACK) {
      n.color = nodeColor(child);
      deleteCase1(n);
    }
    replaceNode(n, child);

    if (nodeColor(root) == COLOR.RED) {
      root.color = COLOR.BLACK;
    }

    verifyProperties();
  }

  private static <K extends Comparable<? super K>, V> RedBlackTreeNode<K, V> maximumNode(
      RedBlackTreeNode<K, V> n) {
    assert n != null;
    while (n.right != null) {
      n = n.right;
    }
    return n;
  }

  /**
   * <p>
   * <b>Case 1:</b> N is the new root. In this case, we are done. We removed one
   * black node from every path, and the new root is black, so the properties
   * are preserved.
   * </p>
   * 
   * @param n
   */
  private void deleteCase1(RedBlackTreeNode<K, V> n) {
    if (n.parent == null)
      return;
    else
      deleteCase2(n);
  }

  /**
   * <p>
   * <b>Case 2:</b> S is red. In this case we reverse the colors of P and S, and
   * then rotate left at P, turning S into N's grandparent. Note that P has to
   * be black as it had a red child. Although all paths still have the same
   * number of black nodes, now N has a black sibling and a red parent, so we
   * can proceed to step 4, 5, or 6. (Its new sibling is black because it was
   * once the child of the red S.) In later cases, we will relabel N's new
   * sibling as S.
   * </p>
   * 
   * @param n
   */
  private void deleteCase2(RedBlackTreeNode<K, V> n) {
    if (nodeColor(n.sibling()) == COLOR.RED) {
      n.parent.color = COLOR.RED;
      n.sibling().color = COLOR.BLACK;
      if (n == n.parent.left)
        rotateLeft(n.parent);
      else
        rotateRight(n.parent);
    }
    deleteCase3(n);
  }

  /**
   * <p>
   * <b>Case 3:</b> P, S, and S's children are black. In this case, we simply
   * repaint S red. The result is that all paths passing through S, which are
   * precisely those paths not passing through N, have one less black node.
   * Because deleting N's original parent made all paths passing through N have
   * one less black node, this evens things up. However, all paths through P now
   * have one fewer black node than paths that do not pass through P, so
   * property 5 (all paths from any given node to its leaf nodes contain the
   * same number of black nodes) is still violated. To correct this, we perform
   * the rebalancing procedure on P, starting at case 1.
   * </p>
   * 
   * @param n
   */
  private void deleteCase3(RedBlackTreeNode<K, V> n) {
    if (nodeColor(n.parent) == COLOR.BLACK
        && nodeColor(n.sibling()) == COLOR.BLACK
        && nodeColor(n.sibling().left) == COLOR.BLACK
        && nodeColor(n.sibling().right) == COLOR.BLACK) {
      n.sibling().color = COLOR.RED;
      deleteCase1(n.parent);
    } else
      deleteCase4(n);
  }

  /**
   * <p>
   * <b>Case 4:</b> S and S's children are black, but P is red. In this case, we
   * simply exchange the colors of S and P. This does not affect the number of
   * black nodes on paths going through S, but it does add one to the number of
   * black nodes on paths going through N, making up for the deleted black node
   * on those paths.
   * </p>
   * 
   * @param n
   */
  private void deleteCase4(RedBlackTreeNode<K, V> n) {
    if (nodeColor(n.parent) == COLOR.RED
        && nodeColor(n.sibling()) == COLOR.BLACK
        && nodeColor(n.sibling().left) == COLOR.BLACK
        && nodeColor(n.sibling().right) == COLOR.BLACK) {
      n.sibling().color = COLOR.RED;
      n.parent.color = COLOR.BLACK;
    } else
      deleteCase5(n);
  }

  /**
   * <p>
   * <b>Case 5:</b> S is black, S's left child is red, S's right child is black,
   * and N is the left child of its parent. In this case we rotate right at S,
   * so that S's left child becomes S's parent and N's new sibling. We then
   * exchange the colors of S and its new parent. All paths still have the same
   * number of black nodes, but now N has a black sibling whose right child is
   * red, so we fall into case 6. Neither N nor its parent are affected by this
   * transformation. (Again, for case 6, we relabel N's new sibling as S.)
   * </p>
   * 
   * @param n
   */
  private void deleteCase5(RedBlackTreeNode<K, V> n) {
    if (n == n.parent.left && nodeColor(n.sibling()) == COLOR.BLACK
        && nodeColor(n.sibling().left) == COLOR.RED
        && nodeColor(n.sibling().right) == COLOR.BLACK) {
      n.sibling().color = COLOR.RED;
      n.sibling().left.color = COLOR.BLACK;
      rotateRight(n.sibling());
    } else if (n == n.parent.right && nodeColor(n.sibling()) == COLOR.BLACK
        && nodeColor(n.sibling().right) == COLOR.RED
        && nodeColor(n.sibling().left) == COLOR.BLACK) {
      n.sibling().color = COLOR.RED;
      n.sibling().right.color = COLOR.BLACK;
      rotateLeft(n.sibling());
    }
    deleteCase6(n);
  }

  /**
   * <p>
   * <b>Case 6:</b> S is black, S's right child is red, and N is the left child
   * of its parent P. In this case we rotate left at P, so that S becomes the
   * parent of P and S's right child. We then exchange the colors of P and S,
   * and make S's right child black. The subtree still has the same color at its
   * root, so Properties 4 (Both children of every red node are black) and 5
   * (All paths from any given node to its leaf nodes contain the same number of
   * black nodes) are not violated. However, N now has one additional black
   * ancestor: either P has become black, or it was black and S was added as a
   * black grandparent. Thus, the paths passing through N pass through one
   * additional black node.
   * </p>
   * <p>
   * Meanwhile, if a path does not go through N, then there are two
   * possibilities:
   * <ul>
   * <li>It goes through N's new sibling. Then, it must go through S and P, both
   * formerly and currently, as they have only exchanged colors and places. Thus
   * the path contains the same number of black nodes.</li>
   * <li>It goes through N's new uncle, S's right child. Then, it formerly went
   * through S, S's parent, and S's right child (which was red), but now only
   * goes through S, which has assumed the color of its former parent, and S's
   * right child, which has changed from red to black (assuming S's color:
   * black). The net effect is that this path goes through the same number of
   * black nodes.</li>
   * </ul>
   * </p>
   * <p>
   * Either way, the number of black nodes on these paths does not change. Thus,
   * we have restored Properties 4 (Both children of every red node are black)
   * and 5 (All paths from any given node to its leaf nodes contain the same
   * number of black nodes). The white node in the diagram can be either red or
   * black, but must refer to the same color both before and after the
   * transformation.
   * </p>
   * 
   * @param n
   */
  private void deleteCase6(RedBlackTreeNode<K, V> n) {
    n.sibling().color = nodeColor(n.parent);
    n.parent.color = COLOR.BLACK;
    if (n == n.parent.left) {
      assert nodeColor(n.sibling().right) == COLOR.RED;
      n.sibling().right.color = COLOR.BLACK;
      rotateLeft(n.parent);
    } else {
      assert nodeColor(n.sibling().left) == COLOR.RED;
      n.sibling().left.color = COLOR.BLACK;
      rotateRight(n.parent);
    }
  }

  // public void print() {
  // printHelper(root, 0);
  // }
  //
  // private static void printHelper(RedBlackTreeNode<?, ?> n, int indent) {
  // if (n == null) {
  // System.out.print("<empty tree>");
  // return;
  // }
  // if (n.right != null) {
  // printHelper(n.right, indent + INDENT_STEP);
  // }
  // for (int i = 0; i < indent; i++)
  // System.out.print(" ");
  // if (n.color == COLOR.BLACK)
  // System.out.println(n.key);
  // else
  // System.out.println("<" + n.key + ">");
  // if (n.left != null) {
  // printHelper(n.left, indent + INDENT_STEP);
  // }
  // }

  /**
   * <b>Property 1:</b> A node is either red or black
   * 
   * @param n
   */
  private static void verifyProperty1(RedBlackTreeNode<?, ?> n) {
    assert nodeColor(n) == COLOR.RED || nodeColor(n) == COLOR.BLACK;
    if (n == null)
      return;
    verifyProperty1(n.left);
    verifyProperty1(n.right);
  }

  /**
   * <b>Property 2:</b> The root is black. (This rule is sometimes omitted.
   * Since the root can always be changed from red to black, but not necessarily
   * vice-versa, this rule has little effect on analysis.)
   * 
   * @param root
   */
  private static void verifyProperty2(RedBlackTreeNode<?, ?> root) {
    assert nodeColor(root) == COLOR.BLACK;
  }

  private static COLOR nodeColor(RedBlackTreeNode<?, ?> n) {
    return n == null ? COLOR.BLACK : n.color;
  }

  /**
   * <b>Property 4:</b> Every red node must have two black child nodes
   * 
   * @param n
   */
  private static void verifyProperty4(RedBlackTreeNode<?, ?> n) {
    if (nodeColor(n) == COLOR.RED) {
      assert nodeColor(n.left) == COLOR.BLACK;
      assert nodeColor(n.right) == COLOR.BLACK;
      assert nodeColor(n.parent) == COLOR.BLACK;
    }
    if (n == null)
      return;
    verifyProperty4(n.left);
    verifyProperty4(n.right);
  }

  /**
   * <b>Property 5:</b> Every path from a given node to any of its descendant
   * leaves contains the same number of black nodes.
   * 
   * @param root
   */
  private static void verifyProperty5(RedBlackTreeNode<?, ?> root) {
    verifyProperty5Helper(root, 0, -1);
  }

  private static int verifyProperty5Helper(RedBlackTreeNode<?, ?> n,
      int blackCount, int pathBlackCount) {
    if (nodeColor(n) == COLOR.BLACK) {
      blackCount++;
    }
    if (n == null) {
      if (pathBlackCount == -1) {
        pathBlackCount = blackCount;
      } else {
        assert blackCount == pathBlackCount;
      }
      return pathBlackCount;
    }
    pathBlackCount = verifyProperty5Helper(n.left, blackCount, pathBlackCount);
    pathBlackCount = verifyProperty5Helper(n.right, blackCount, pathBlackCount);
    return pathBlackCount;
  }

  private static enum COLOR {
    RED, BLACK;
  }

  private static class RedBlackTreeNode<K extends Comparable<? super K>, V> {
    K key;
    COLOR color;
    RedBlackTreeNode<K, V> left;
    RedBlackTreeNode<K, V> right;
    RedBlackTreeNode<K, V> parent;
    V value;

    public RedBlackTreeNode(K key, V value, COLOR nodeColor,
        RedBlackTreeNode<K, V> left, RedBlackTreeNode<K, V> right) {
      this.key = key;
      this.value = value;
      this.color = nodeColor;
      this.left = left;
      this.right = right;
      if (left != null)
        left.parent = this;
      if (right != null)
        right.parent = this;
      this.parent = null;
    }

    public RedBlackTreeNode<K, V> grandparent() {
      assert parent != null; // Not the root node
      assert parent.parent != null; // Not child of root
      return parent.parent;
    }

    public RedBlackTreeNode<K, V> sibling() {
      assert parent != null; // Root node has no sibling
      if (this == parent.left)
        return parent.right;
      else
        return parent.left;
    }

    public RedBlackTreeNode<K, V> uncle() {
      assert parent != null; // Root node has no uncle
      assert parent.parent != null; // Children of root have no uncle
      return parent.sibling();
    }
  }
}
