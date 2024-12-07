package weekly.w297;

import static util.ArrayUtils.matrix;

/**
 * 5270. 网格中的最小路径代价：https://leetcode.cn/problems/minimum-path-cost-in-a-grid/
 */
public class MinimumPathCostInAGrid {

    public static int minPathCost(int[][] grid, int[][] moveCost) {
        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < n; i++) {
            dp[0][i] = grid[0][i];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = 0; k < n; k++) {
                    dp[i][j] = Math.min(dp[i][j], grid[i][j] + dp[i - 1][k] + moveCost[grid[i - 1][k]][j]);
                }
            }
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            ans = Integer.min(ans, dp[m - 1][i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(minPathCost(matrix("[[5,3],[4,0],[2,1]]"), matrix("[[9,8],[1,5],[10,12],[18,6],[2,4],[14,3]]")));
        System.out.println(minPathCost(matrix("[[5,1,2],[4,0,3]]"), matrix("[[12,10,15],[20,23,8],[21,7,1],[8,1,13],[9,10,25],[5,3,2]]")));
    }

}
