package personal.spring2022;

/**
 * LCP 50. 宝石补给：https://leetcode-cn.com/problems/WHnhjV/
 */
public class LCP50 {

    public static int giveGem(int[] gem, int[][] operations) {
        if (gem.length <= 0) {
            return 0;
        }
        for (int i = 0; i < operations.length; i++) {
            int x = operations[i][0], y = operations[i][1];
            int c = gem[x] / 2;
            gem[x] -= c;
            gem[y] += c;
        }
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int i = 0; i < gem.length; i++) {
            min = Math.min(min, gem[i]);
            max = Math.max(max, gem[i]);
        }
        return max - min;
    }

    public static void main(String[] args) {

    }

}
