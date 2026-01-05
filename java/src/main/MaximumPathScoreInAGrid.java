import java.util.Arrays;

/**
 * 3742. 网格中得分最大的路径：https://leetcode.cn/problems/maximum-path-score-in-a-grid
 */
public class MaximumPathScoreInAGrid {

    public int maxPathScore(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int[][][] memo = new int[m][n][k + 1];
        for (int[][] row : memo) {
            for (int[] a : row) {
                Arrays.fill(a, Integer.MIN_VALUE);
            }
        }
        return Math.max(dfs(grid, m - 1, n - 1, k, memo), -1);
    }

    private int dfs(int[][] grid, int i, int j, int k, int[][][] memo) {
        if (k < 0) {
            return Integer.MIN_VALUE;
        }
        if (i < 0 || j < 0) {
            return i == 0 ? 0 : Integer.MIN_VALUE;
        }
        if (memo[i][j][k] != Integer.MIN_VALUE) {
            return memo[i][j][k];
        }
        int cost = grid[i][j] == 0 ? 0 : 1;
        return memo[i][j][k] = grid[i][j] + Math.max(dfs(grid, i - 1, j, k - cost, memo), dfs(grid, i, j - 1, k - cost, memo));
    }

}
