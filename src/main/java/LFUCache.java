import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Wei Gao
 * @since 2019-01-04
 */
public class LFUCache {
    private final Map<Integer, Integer> keyToValue;
    private final Map<Integer, Integer> keyToCount;
    private final Map<Integer, Set<Integer>> countToKeys;
    private final int capacity;
    private int minCount;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        keyToValue = new HashMap<>(capacity);
        keyToCount = new HashMap<>(capacity);
        countToKeys = new HashMap<>();
        minCount = 0;
    }

    public int get(int key) {
        if (!keyToValue.containsKey(key)) {
            return -1;
        }
        int currentCount = keyToCount.get(key);
        Set<Integer> keys = countToKeys.get(currentCount);
        keys.remove(key);
        if (keys.isEmpty()) {
            countToKeys.remove(currentCount);
            if (currentCount == minCount) {
                minCount ++;
            }
        }
        currentCount ++;
        keyToCount.put(key, currentCount);
        keys = countToKeys.get(currentCount);
        if (keys == null) {
            keys = new LinkedHashSet<>();
            countToKeys.put(currentCount, keys);
        }
        keys.add(key);
        return keyToValue.get(key);
    }

    public void put(int key, int value) {
        if (keyToValue.containsKey(key)) {
            get(key);
            keyToValue.put(key, value);
        } else {
            if (keyToValue.size() == capacity) {
                Set<Integer> keys = countToKeys.get(minCount);
                Integer removeKey = keys.iterator().next();
                keys.remove(removeKey);
                if (keys.isEmpty()) {
                    countToKeys.remove(minCount);
                }
                keyToCount.remove(removeKey);
                keyToValue.remove(removeKey);
            }
            keyToValue.put(key, value);
            keyToCount.put(key, 1);
            Set<Integer> keys = countToKeys.get(1);
            if (keys == null) {
                keys = new LinkedHashSet<>();
                countToKeys.put(1, keys);
            }
            keys.add(key);
            minCount = 1;
        }
    }
}
