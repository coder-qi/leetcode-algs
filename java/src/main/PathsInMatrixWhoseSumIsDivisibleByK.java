import util.ArrayUtils;

import java.util.Arrays;

/**
 * 2435. 矩阵中和能被 K 整除的路径：https://leetcode.cn/problems/paths-in-matrix-whose-sum-is-divisible-by-k
 */
public class PathsInMatrixWhoseSumIsDivisibleByK {

    static final int MOD = 1000000007;

    // dfs + 记忆化搜索
    public int numberOfPaths(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        int[][][] memo = new int[m][n][k];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(memo[i][j], -1);
            }
        }
        return dfs(grid, 0, 0, 0, k, memo);
    }

    private int dfs(int[][] grid, int i, int j, int x, int k, int[][][] memo) {
        int m = grid.length, n = grid[0].length;
        if (i >= m || j >= n) {
            return 0;
        }
        if (i == m - 1 && j == n - 1) {
            return (x + grid[i][j]) % k == 0 ? 1 : 0;
        }
        if (memo[i][j][x] != -1) {
            return memo[i][j][x];
        }
        int ans = dfs(grid, i + 1, j, (x + grid[i][j]) % k, k, memo);
        ans += dfs(grid, i, j + 1, (x + grid[i][j]) % k, k, memo);
        ans %= MOD;
        return memo[i][j][x] = ans;
    }

    // 改为动态规划
    public int numberOfPaths2(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        int[][][] dp = new int[m + 1][n + 1][k + 1];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                for (int s = 0; s <= k; s++) {
                    int x = (s + grid[i][j]) % k;
                    if (i == m - 1 && j == n - 1) {
                        dp[i][j][s] = x == 0 ? 1 : 0;
                    } else {
                        dp[i][j][s] = (dp[i + 1][j][x] + dp[i][j + 1][x]) % MOD;
                    }
                }
            }
        }
        return dp[0][0][k];
    }

    // 动态规划，空间压缩
    public int numberOfPaths3(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[n + 1][k + 1];
        int[] temp = new int[k + 1];
        dp[n - 1][0] = 1;
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                for (int s = 0; s <= k; s++) {
                    int x = (s + grid[i][j]) % k;
                    temp[s] = (dp[j][x] + dp[j + 1][x]) % MOD;
                }
                System.arraycopy(temp, 0, dp[j], 0, k + 1);
            }
        }
        return dp[0][k];
    }

    public static void main(String[] args) {
        PathsInMatrixWhoseSumIsDivisibleByK app = new PathsInMatrixWhoseSumIsDivisibleByK();
        System.out.println(app.numberOfPaths3(ArrayUtils.matrix("[[5,2,4],[3,0,5],[0,7,2]]"), 3));
        System.out.println(app.numberOfPaths3(ArrayUtils.matrix("[[7,3,4,9],[2,3,6,2],[2,3,7,0]]"), 1));
    }

}
