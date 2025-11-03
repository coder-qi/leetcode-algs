import java.util.Arrays;

/**
 * 1578. 使绳子变成彩色的最短时间：https://leetcode.cn/problems/minimum-time-to-make-rope-colorful
 */
public class MinimumTimeToMakeRopeColorful {

    public int minCost(String colors, int[] neededTime) {
        int[][] memo = new int[27][neededTime.length + 1];
        for (int[] arr : memo) {
            Arrays.fill(arr, -1);
        }
        return dfs(colors, neededTime, (char)('a' - 1), 0, memo);
    }

    private int dfs(String colors, int[] neededTime, char prevColor, int index, int[][] memo) {
        if (index == colors.length()) {
            return 0;
        }
        int cost1 = Integer.MAX_VALUE;
        char color = colors.charAt(index);
        if (memo[prevColor - 'a' + 1][index] != -1) {
            return memo[prevColor - 'a' + 1][index];
        }
        if (color != prevColor) {
            cost1 = dfs(colors, neededTime, color, index + 1, memo);
        }
        int cost2 = dfs(colors, neededTime, prevColor, index + 1, memo) + neededTime[index];
        return memo[prevColor - 'a' + 1][index] = Math.min(cost1, cost2);
    }

}
