/**
 * <p>
 * There are <i>N</i> gas stations along a circular route, where the amount of
 * gas at station <i>i</i> is <font color="red">gas[i]</font>.
 * </p>
 * 
 * <p>
 * You have a car with an unlimited gas tank and it costs <font
 * color="red">cost[i]</font> of gas to travel from station <i>i</i> to its next
 * station (<i>i</i>+1). You begin the journey with an empty tank at one of the
 * gas stations.
 * </p>
 * 
 * <p>
 * Return the starting gas station's index if you can travel around the circuit
 * once, otherwise return -1.
 * </p>
 * 
 * <p>
 * <b>Note:</b><br />
 * The solution is guaranteed to be unique.
 * </p>
 * 
 * @see <a href="https://oj.leetcode.com/problems/gas-station/">Leetcode Gas
 *      Station Problem</a>
 * @author Wei Gao
 */
public class GasStation {
    public int canCompleteCircuuit(int[] gas, int[] cost) {
        if (gas == null || cost == null || gas.length == 0
                || gas.length != cost.length) {
            return -1;
        }
        int start = 0;
        int leftGas = 0;
        for (int i = 0; i < gas.length * 2; i++) {
            leftGas += gas[i % gas.length] - cost[i % cost.length];
            if (leftGas < 0) {
                start = i + 1;
                leftGas = 0;
            }
        }
        if (start > gas.length) {
            return -1;
        } else {
            return start;
        }
    }
}
