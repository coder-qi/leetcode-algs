import java.util.Arrays;

/**
 * 1594. 矩阵的最大非负积：https://leetcode.cn/problems/maximum-non-negative-product-in-a-matrix
 */
public class MaximumNonNegativeProductInAMatrix {

    public int maxProductPath(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        long[][][] memo = new long[m][n][2];
        for (long[][] a : memo) {
            for (long[] b : a) {
                Arrays.fill(b, Long.MIN_VALUE);
            }
        }
        long[] ans = dfs(grid, m - 1, n - 1, memo);
        return ans[1] < 0 ? -1 : (int) (ans[1] % 1000000007);
    }

    private long[] dfs(int[][] grid, int i, int j, long[][][] memo) {
        if (memo[i][j][0] != Long.MIN_VALUE) {
            return memo[i][j];
        }
        if (i == 0 && j == 0) {
            return new long[] {grid[i][j], grid[i][j]};
        }
        long min = Long.MAX_VALUE;
        long max = Long.MIN_VALUE;
        if (i > 0) {
            long[] x = dfs(grid, i - 1, j, memo);
            min = Math.min(grid[i][j] * x[0], grid[i][j] * x[1]);
            max = Math.max(grid[i][j] * x[0], grid[i][j] * x[1]);
        }
        if (j > 0) {
            long[] x = dfs(grid, i, j - 1, memo);
            min = Math.min(min, Math.min(grid[i][j] * x[0], grid[i][j] * x[1]));
            max = Math.max(max, Math.max(grid[i][j] * x[0], grid[i][j] * x[1]));
        }
        return memo[i][j] = new long[] {min, max};
    }

    public int maxProductPath2(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        long[][][] f = new long[m][n][2];
        f[0][0][0] = f[0][0][1] = grid[0][0];
        for (int i = 1; i < m; i++) {
            f[i][0][0] = Math.min(grid[i][0] * f[i - 1][0][0], grid[i][0] * f[i - 1][0][1]);
            f[i][0][1] = Math.max(grid[i][0] * f[i - 1][0][0], grid[i][0] * f[i - 1][0][1]);
        }
        for (int j = 1; j < n; j++) {
            f[0][j][0] = Math.min(grid[0][j] * f[0][j - 1][0], grid[0][j] * f[0][j - 1][1]);
            f[0][j][1] = Math.max(grid[0][j] * f[0][j - 1][0], grid[0][j] * f[0][j - 1][1]);
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                f[i][j][0] = Math.min(grid[i][j] * f[i - 1][j][0], grid[i][j] * f[i - 1][j][1]);
                f[i][j][1] = Math.max(grid[i][j] * f[i - 1][j][0], grid[i][j] * f[i - 1][j][1]);
                f[i][j][0] = Math.min(f[i][j][0], Math.min(grid[i][j] * f[i][j - 1][0], grid[i][j] * f[i][j - 1][1]));
                f[i][j][1] = Math.max(f[i][j][1], Math.max(grid[i][j] * f[i][j - 1][0], grid[i][j] * f[i][j - 1][1]));
            }
        }

        return f[m - 1][n - 1][1] < 0 ? -1 : (int) (f[m - 1][n - 1][1] % 1000000007);
    }

    public int maxProductPath3(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        long[][][] f = new long[m][n][2];
        f[0][0][0] = f[0][0][1] = grid[0][0];
        for (int i = 1; i < m; i++) {
            f[i][0][0] = f[i][0][1] = grid[i][0] * f[i - 1][0][0];
        }
        for (int j = 1; j < n; j++) {
            f[0][j][0] = f[0][j][1] = grid[0][j] * f[0][j - 1][0];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                f[i][j][0] = Math.min(grid[i][j] * f[i - 1][j][0], grid[i][j] * f[i - 1][j][1]);
                f[i][j][1] = Math.max(grid[i][j] * f[i - 1][j][0], grid[i][j] * f[i - 1][j][1]);
                f[i][j][0] = Math.min(f[i][j][0], Math.min(grid[i][j] * f[i][j - 1][0], grid[i][j] * f[i][j - 1][1]));
                f[i][j][1] = Math.max(f[i][j][1], Math.max(grid[i][j] * f[i][j - 1][0], grid[i][j] * f[i][j - 1][1]));
            }
        }

        return f[m - 1][n - 1][1] < 0 ? -1 : (int) (f[m - 1][n - 1][1] % 1000000007);
    }

    public int maxProductPath4(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        long[][] f = new long[n][2];
        f[0][0] = f[0][1] = grid[0][0];
        for (int j = 1; j < n; j++) {
            f[j][0] = f[j][1] = grid[0][j] * f[j - 1][0];
        }
        for (int i = 1; i < m; i++) {
            f[0][0] = f[0][1] = grid[i][0] * f[0][0];
            for (int j = 1; j < n; j++) {
                long x1 = grid[i][j] * f[j][0];
                long x2 = grid[i][j] * f[j][1];
                long y1 = grid[i][j] * f[j - 1][0];
                long y2 = grid[i][j] * f[j - 1][1];
                f[j][0] = Math.min(Math.min(x1, x2), Math.min(y1, y2));
                f[j][1] = Math.max(Math.max(x1, x2), Math.max(y1, y2));
            }
        }

        return f[n - 1][1] < 0 ? -1 : (int) (f[n - 1][1] % 1000000007);
    }

}
