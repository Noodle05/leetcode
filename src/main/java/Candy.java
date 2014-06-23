/**
 * <p>
 * There are N children standing in a line. Each child is assigned a rating
 * value.
 * </p>
 * 
 * <p>
 * You are giving candies to these children subjected to the following
 * requirements:
 * 
 * <ul>
 * <li>Each child must have at least one candy.</li>
 * <li>Children with a higher rating get more candies than their neighbors.</li>
 * </ul>
 * </p>
 * <p>
 * What is the minimum candies you must give?
 * </p>
 * 
 * @see <a href="https://oj.leetcode.com/problems/candy/">Leetcode Candy
 *      Problem</a>
 * @author Wei Gao
 */
public class Candy {
    public int candy(int[] ratings) {
        if (ratings == null || ratings.length == 0) {
            return 0;
        }
        if (ratings.length == 1) {
            return 1;
        }
        int[] leftToRight = new int[ratings.length];
        int[] rightToLeft = new int[ratings.length];
        leftToRight[0] = 1;
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                leftToRight[i] = leftToRight[i - 1] + 1;
            } else {
                leftToRight[i] = 1;
            }
        }
        rightToLeft[ratings.length - 1] = 1;
        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                rightToLeft[i] = rightToLeft[i + 1] + 1;
            } else {
                rightToLeft[i] = 1;
            }
        }
        int total = 0;
        for (int i = 0; i < ratings.length; i++) {
            total += (leftToRight[i] > rightToLeft[i] ? leftToRight[i]
                    : rightToLeft[i]);
        }
        return total;
    }
}
