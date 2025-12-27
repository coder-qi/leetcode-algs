import java.util.Arrays;

/**
 * 931. 下降路径最小和：https://leetcode.cn/problems/minimum-falling-path-sum
 */
public class MinimumFallingPathSum {

    // 记忆化搜索
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int[][] memo = new int[n][n];
        for (int[] row : memo) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            ans = Math.min(ans, dfs(matrix, 0, i, memo));
        }
        return ans;
    }

    private int dfs(int[][] matrix, int i, int j, int[][] memo) {
        int n = matrix.length;
        if (i == n) {
            return 0;
        }
        if (j < 0 || j == n) {
            return Integer.MAX_VALUE / 2;
        }
        if (memo[i][j] != Integer.MAX_VALUE) {
            return memo[i][j];
        }
        return memo[i][j] = matrix[i][j] + Math.min(
                Math.min(dfs(matrix, i + 1, j - 1, memo), dfs(matrix, i + 1, j, memo)),
                dfs(matrix, i + 1, j + 1, memo));
    }

    // dp
    public int minFallingPathSum2(int[][] matrix) {
        int n = matrix.length;
        int[][] f = new int[n + 1][n + 1];
        for (int i = 0; i < n; i++) {
            f[i][n] = Integer.MAX_VALUE / 2;
        }
        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j > 0; j--) {
                f[i][j] = matrix[i][j] + Math.min(Math.min(f[i + 1][j - 1], f[i + 1][j]), f[i + 1][j + 1]);
            }
            f[i][0] = matrix[i][0] + Math.min(f[i + 1][0], f[i + 1][1]);
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            ans = Math.min(ans, f[0][i]);
        }
        return ans;
    }

}
