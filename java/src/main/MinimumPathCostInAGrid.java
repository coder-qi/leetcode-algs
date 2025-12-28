/**
 * 2304. 网格中的最小路径代价：https://leetcode.cn/problems/minimum-path-cost-in-a-grid
 */
public class MinimumPathCostInAGrid {

    public int minPathCost(int[][] grid, int[][] moveCost) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] memo = new int[m][n];
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            ans = Math.min(ans, dfs(grid, m - 1, i, moveCost, memo));
        }
        return ans;
    }

    private int dfs(int[][] grid, int i, int j, int[][] moveCost, int[][] memo) {
        int n = grid[0].length;
        if (i == 0) {
            return grid[i][j];
        }
        if (memo[i][j] != 0) {
            return memo[i][j];
        }
        int min = Integer.MAX_VALUE;
        for (int k = 0; k < n; k++) {
            min = Math.min(min, dfs(grid, i - 1, k, moveCost, memo) + grid[i][j] + moveCost[grid[i - 1][k]][j]);
        }
        return memo[i][j] = min;
    }

    public int minPathCost2(int[][] grid, int[][] moveCost) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] f = new int[m][n];
        System.arraycopy(grid[0], 0, f[0], 0, n);
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int min = Integer.MAX_VALUE;
                for (int k = 0; k < n; k++) {
                    min = Math.min(min, f[i - 1][k] + grid[i][j] + moveCost[grid[i - 1][k]][j]);
                }
                f[i][j] = min;
            }
        }
        int ans = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++) {
            ans = Math.min(ans, f[m - 1][j]);
        }
        return ans;
    }

    public int minPathCost3(int[][] grid, int[][] moveCost) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] f = new int[2][n];
        System.arraycopy(grid[0], 0, f[0], 0, n);
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int min = Integer.MAX_VALUE;
                for (int k = 0; k < n; k++) {
                    min = Math.min(min, f[(i - 1) % 2][k] + grid[i][j] + moveCost[grid[i - 1][k]][j]);
                }
                f[i % 2][j] = min;
            }
        }
        int ans = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++) {
            ans = Math.min(ans, f[(m - 1) % 2][j]);
        }
        return ans;
    }

}
