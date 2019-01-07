import java.util.List;

/**
 * <p>Given a nested list of integers, return the sum of all integers in the list weighted by their depth.</p>
 *
 * <p>Each element is either an integer, or a list -- whose elements may also be integers or other lists.</p>
 *
 * <p>Example 1:<br />
 * Given the list [[1,1],2,[1,1]], return 10. (four 1's at depth 2, one 2 at depth 1)</p>
 *
 * <p>Example 2:<br />
 * Given the list [1,[4,[6]]], return 27. (one 1 at depth 1, one 4 at depth 2, and one 6 at depth 3; 1 + 4*2 + 6*3 = 27)</p>
 */
public class NestedListWeightSum {
    public int depthSum(List<NestedInteger> nestedList) {
        return dfs(nestedList, 1);
    }

    private int dfs(List<NestedInteger> nestedList, int level) {
        int result = 0;
        for (NestedInteger ele : nestedList) {
            if (ele.isInteger()) {
                result += ele.getInteger() * level;
            } else {
                result += dfs(ele.getList(), level + 1);
            }
        }
        return result;
    }
}
