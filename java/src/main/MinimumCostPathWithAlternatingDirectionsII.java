import util.ArrayUtils;

import java.util.Arrays;

/**
 * 3603. 交替方向的最小路径代价 II：https://leetcode.cn/problems/minimum-cost-path-with-alternating-directions-ii
 */
public class MinimumCostPathWithAlternatingDirectionsII {

    public long minCost(int m, int n, int[][] waitCost) {
        long[][][] memo = new long[m][n][2];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(memo[i][j], -1);
            }
        }
        return 1 + dfs(0, 0, 1, m, n, waitCost, memo);
    }

    private long dfs(int i, int j, int x, int m, int n, int[][] waitCost, long[][][] memo) {
        if (i == m - 1 && j == n - 1) {
            return 0;
        }
        if (i == m || j == n) {
            return Long.MAX_VALUE / 2;
        }
        if (memo[i][j][x] != -1) {
            return memo[i][j][x];
        }
        if (x == 1) {
            return memo[i][j][x] = Math.min(dfs(i, j + 1, 0, m, n, waitCost, memo) + (i + 1) * (j + 2),
                    dfs(i + 1, j, 0, m, n, waitCost, memo) + (i + 2) * (j + 1));
        } else {
            return memo[i][j][x] = waitCost[i][j] + dfs(i, j, 1, m, n, waitCost, memo);
        }
    }

    public long minCost2(int m, int n, int[][] waitCost) {
        long[][][] f = new long[m + 1][n + 1][2];
        for (int i = 0; i <= m; i++) {
            f[i][n][0] = f[i][n][1] = Long.MAX_VALUE / 2;
        }
        for (int j = 0; j <= n; j++) {
            f[m][j][0] = f[m][j][1] = Long.MAX_VALUE / 2;
        }
        f[m - 1][n][0] = -m * (n + 1);
        waitCost[m - 1][n - 1] = 0;
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                f[i][j][1] = Math.min(f[i][j + 1][0] + (i + 1) * (j + 2), f[i + 1][j][0] + (i + 2) * (j + 1));
                f[i][j][0] = waitCost[i][j] + f[i][j][1];
            }
        }
        return 1 + f[0][0][1];
    }

    public long minCost3(int m, int n, int[][] waitCost) {
        long[][][] f = new long[2][n + 1][2];
        for (int j = 0; j <= n; j++) {
            f[0][j][0] = f[0][j][1] = Long.MAX_VALUE / 2;
            f[1][j][0] = f[1][j][1] = Long.MAX_VALUE / 2;
        }
        f[m % 2][n - 1][0] = -(m + 1) * n;
        waitCost[m - 1][n - 1] = 0;
        for (int i = m - 1; i >= 0; i--) {
            int current = i % 2;
            int next = (i + 1) % 2;
            for (int j = n - 1; j >= 0; j--) {
                f[current][j][1] = Math.min(f[current][j + 1][0] + (i + 1) * (j + 2), f[next][j][0] + (i + 2) * (j + 1));
                f[current][j][0] = waitCost[i][j] + f[current][j][1];
            }
        }
        return 1 + f[0][0][1];
    }

    public static void main(String[] args) {
        MinimumCostPathWithAlternatingDirectionsII app = new MinimumCostPathWithAlternatingDirectionsII();
        System.out.println(app.minCost3(3, 1, ArrayUtils.matrix("[[1],[1],[1]]")));
    }

}
