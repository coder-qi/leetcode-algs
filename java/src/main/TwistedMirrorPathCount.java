import java.util.Arrays;

/**
 * 3665. 统计镜子反射路径数目：https://leetcode.cn/problems/twisted-mirror-path-count
 */
public class TwistedMirrorPathCount {

    public int uniquePaths(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][][] memo = new int[m][n][2];
        for (int[][] row : memo) {
            for (int[] col : row) {
                Arrays.fill(col, -1);
            }
        }
        return dfs(grid, 0, 0, 0, memo);
    }

    private int dfs(int[][] grid, int i, int j, int direct, int[][][] memo) {
        int m = grid.length;
        int n = grid[0].length;
        if (i >= m || j >= n) {
            return 0;
        }
        if (i == m - 1 && j == n - 1) {
            return 1;
        }
        if (memo[i][j][direct] != -1) {
            return memo[i][j][direct];
        }
        int mod = (int) (1e9 + 7);
        if (grid[i][j] == 1) {
            return memo[i][j][direct] = direct == 0 ? dfs(grid, i + 1, j, 1, memo) : dfs(grid, i, j + 1, 0, memo);
        }
        return memo[i][j][direct] = (dfs(grid, i + 1, j, 1, memo) + dfs(grid, i, j + 1, 0, memo)) % mod;
    }

    public int uniquePaths2(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][][] f = new int[m + 1][n + 1][2];
        f[m][n - 1][0] = f[m][n - 1][1] = 1;
        int mod = (int) (1e9 + 7);
        for (int i = m - 1; i >= 0 ; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (grid[i][j] == 1) {
                    f[i][j][0] = f[i + 1][j][1];
                    f[i][j][1] = f[i][j + 1][0];
                } else {
                    f[i][j][0] = f[i][j][1] = (f[i + 1][j][1] + f[i][j + 1][0]) % mod;
                }
            }
        }
        return f[0][0][0];
    }

    public int uniquePaths3(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] f = new int[n + 1][2];
        f[n - 1][0] = f[n - 1][1] = 1;
        int mod = (int) (1e9 + 7);
        for (int i = m - 1; i >= 0 ; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (grid[i][j] == 1) {
                    f[j][0] = f[j][1];
                    f[j][1] = f[j + 1][0];
                } else {
                    f[j][0] = f[j][1] = (f[j][1] + f[j + 1][0]) % mod;
                }
            }
        }
        return f[0][0];
    }

}
