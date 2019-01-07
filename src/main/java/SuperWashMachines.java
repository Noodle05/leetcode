import java.util.Arrays;

public class SuperWashMachines {
    public int findMinMoves(int[] machines) {
        int total = Arrays.stream(machines).sum();
        if ((total % machines.length) != 0) {
            return -1;
        }
        int avg = total / machines.length;
        int cnt = 0;
        int max = 0;
        for (int load : machines) {
            cnt += load - avg;
            max = Math.max(Math.max(max, Math.abs(cnt)), load - avg);
        }
        return max;
    }
}
