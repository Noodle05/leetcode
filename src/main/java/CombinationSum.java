import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        combinationSum(new ArrayList<>(), target, candidates, 0, result);
        return result;
    }

    private void combinationSum(List<Integer> list, int target,
            int[] candidates, int offset, List<List<Integer>> result) {
        if (target == 0) {
            result.add(list);
            return;
        }
        for (int i = offset; i < candidates.length; i++) {
            int newTarget = target - candidates[i];
            if (newTarget >= 0) {
                List<Integer> copy = new ArrayList<>(list);
                copy.add(candidates[i]);
                combinationSum(copy, newTarget, candidates, i, result);
            }
        }
    }
}
