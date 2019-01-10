import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CanIWin {
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        int sum = (maxChoosableInteger + 1) * maxChoosableInteger / 2;
        if (sum < desiredTotal) {
            return false;
        }
        if (desiredTotal <= 0) {
            return true;
        }

        boolean[] used = new boolean[maxChoosableInteger + 1];
        Map<String, Boolean> memory = new HashMap<>();

        return canIWin(maxChoosableInteger, desiredTotal, used, memory);
    }

    private boolean canIWin(int maxChoosableInteger, int desiredTotal, boolean[] used, Map<String, Boolean> memory) {
        if (desiredTotal <= 0) {
            return false;
        }
        String key = Arrays.toString(used);
        if (!memory.containsKey(key)) {
            for (int i = 1; i <= maxChoosableInteger; i++) {
                if (!used[i]) {
                    used[i] = true;
                    boolean otherWin = canIWin(maxChoosableInteger, desiredTotal - i, used, memory);
                    used[i] = false;
                    if (!otherWin) {
                        memory.put(key, true);
                        return true;
                    }
                }
            }
            memory.put(key, false);
            return false;
        } else {
            return memory.get(key);
        }
    }
}
