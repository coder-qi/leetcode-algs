import java.util.Arrays;

/**
 * 2684. 矩阵中移动的最大次数: https://leetcode.cn/problems/maximum-number-of-moves-in-a-grid
 */
public class MaximumNumberOfMovesInAGrid {

    // 记忆化搜索
    public int maxMoves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] memo = new int[m][n];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        int ans = 0;
        for (int i = 0; i < m; i++) {
            ans = Math.max(ans, dfs(grid, i, 0, memo));
        }
        return ans;
    }

    private int dfs(int[][] grid, int i, int j, int[][] memo) {
        int m = grid.length;
        int n = grid[0].length;
        if (j == n - 1) {
            return 0;
        }
        if (memo[i][j] != -1) {
            return memo[i][j];
        }
        int res = 0;
        if (i - 1 >= 0 && grid[i][j] < grid[i - 1][j + 1]) {
            res = Math.max(res, dfs(grid, i - 1, j + 1, memo) + 1);
        }
        if (grid[i][j] < grid[i][j + 1]) {
            res = Math.max(res, dfs(grid, i, j + 1, memo) + 1);
        }
        if (i + 1 < m && grid[i][j] < grid[i + 1][j + 1]) {
            res = Math.max(res, dfs(grid, i + 1, j + 1, memo) + 1);
        }
        return memo[i][j] = res;
    }

    // dp
    public int maxMoves2(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] f = new int[m + 1][n + 1];
        for (int j = n - 2; j >= 0; j--) {
            for (int i = m - 1; i >= 0; i--) {
                int res = 0;
                if (i - 1 >= 0 && grid[i][j] < grid[i - 1][j + 1]) {
                    res = Math.max(res, f[i - 1][j + 1] + 1);
                }
                if (grid[i][j] < grid[i][j + 1]) {
                    res = Math.max(res, f[i][j + 1] + 1);
                }
                if (i + 1 < m && grid[i][j] < grid[i + 1][j + 1]) {
                    res = Math.max(res, f[i + 1][j + 1] + 1);
                }
                f[i][j] = res;
            }
        }
        int ans = 0;
        for (int i = 0; i < m; i++) {
            ans = Math.max(ans, f[i][0]);
        }
        return ans;
    }


}
