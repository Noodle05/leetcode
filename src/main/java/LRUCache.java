/**
 * 
 */


import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * Design and implement a data structure for Least Recently Used (LRU) cache. It
 * should support the following operations: get and set.
 * </p>
 * 
 * <p>
 * <font color="red">get(key)</font> - Get the value (will always be positive)
 * of the key if the key exists in the cache, otherwise return -1. <font
 * color="red">set(key, value)</font> - Set or insert the value if the key is
 * not already present. When the cache reached its capacity, it should
 * invalidate the least recently used item before inserting a new item.
 * </p>
 * 
 * @see <a href="https://oj.leetcode.com/problems/lru-cache/">Leetcode LRU Cache
 *      Problem</a>
 * @author Wei Gao
 *
 */
public class LRUCache {
  final Map<Integer, Key> cache;
  final Key header;
  final Key tail;
  final int capacity;

  public LRUCache(int capacity) {
    this.capacity = capacity;
    cache = new HashMap<>();
    header = new Key(null, null);
    tail = new Key(null, null);
    header.next = tail;
    header.previous = tail;
    tail.next = header;
    tail.previous = header;
  }

  public int get(int key) {
    Key k = cache.get(key);
    if (k != null) {
      remove(k);
      addToFirst(k);
      return k.val;
    } else {
      return -1;
    }
  }

  public void set(int key, int value) {
    Key k = cache.get(key);
    if (k != null) {
      k.val = value;
      remove(k);
    } else {
      k = new Key(key, value);
      cache.put(key, k);
    }
    addToFirst(k);
    if (cache.size() > capacity) {
      int num = cache.size() - capacity;
      for (int i = 0; i < num; i++) {
        Key t = tail.previous;
        remove(t);
        cache.remove(t.key);
      }
    }
  }

  private void remove(Key key) {
    key.previous.next = key.next;
    key.next.previous = key.previous;
  }

  private void addToFirst(Key key) {
    key.next = header.next;
    key.next.previous = key;
    header.next = key;
    key.previous = header;
  }

  private class Key {
    final Integer key;
    Integer val;
    Key previous;
    Key next;

    private Key(Integer key, Integer val) {
      this.key = key;
      this.val = val;
    }
  }
}
