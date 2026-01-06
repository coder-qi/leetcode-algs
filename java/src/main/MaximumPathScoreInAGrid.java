import util.ArrayUtils;

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

    public int maxPathScore2(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int[][][] f = new int[m + 1][n + 1][k + 1];
        for (int i = 0; i <= m; i++) {
            Arrays.fill(f[i][0], Integer.MIN_VALUE);
        }
        for (int j = 0; j <= n; j++) {
            Arrays.fill(f[0][j], Integer.MIN_VALUE);
        }
        Arrays.fill(f[1][0], 0);
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                int cost = grid[i - 1][j - 1] == 0 ? 0 : 1;
                f[i][j][0] = Integer.MIN_VALUE;
                for (int x = cost; x <= k; x++) {
                    f[i][j][x] = grid[i - 1][j - 1] + Math.max(f[i - 1][j][x - cost], f[i][j - 1][x - cost]);
                }
            }
        }
        return Math.max(f[m][n][k], -1);
    }

    public int maxPathScore3(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] f = new int[n + 1][k + 2];
        for (int[] r : f) {
            Arrays.fill(r, Integer.MIN_VALUE);
        }
        Arrays.fill(f[1], 1, k + 2, 0);
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                int cost = grid[i - 1][j - 1] == 0 ? 0 : 1;
                for (int x = k; x >= 0; x--) {
                    f[j][x + 1] = grid[i - 1][j - 1] + Math.max(f[j][x - cost + 1], f[j - 1][x - cost + 1]);
                }
            }
        }
        return Math.max(f[n][k + 1], -1);
    }

    public static void main(String[] args) {
        MaximumPathScoreInAGrid app = new MaximumPathScoreInAGrid();
        System.out.println(app.maxPathScore3(ArrayUtils.matrix("[[0],[2],[1],[0],[1]]"), 2));
    }

}
