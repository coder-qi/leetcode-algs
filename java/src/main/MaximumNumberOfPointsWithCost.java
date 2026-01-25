import java.util.Arrays;

/**
 * 1937. 扣分后的最大得分：https://leetcode.cn/problems/maximum-number-of-points-with-cost
 */
public class MaximumNumberOfPointsWithCost {

    public long maxPoints(int[][] points) {
        int n = points.length;
        int m = points[0].length;
        long[][] memo = new long[n][m];
        for (long[] row : memo) {
            Arrays.fill(row, Long.MIN_VALUE);
        }
        long ans = 0;
        for (int j = 0; j < m; j++) {
            ans = Math.max(ans, dfs(points, n - 1, j, memo));
        }
        return ans;
    }

    private long dfs(int[][] points, int i, int j, long[][] memo) {
        if (i < 0) {
            return 0;
        }
        if (memo[i][j] != Long.MIN_VALUE) {
            return memo[i][j];
        }
        long res = 0;
        for (int k = 0; k < points[i].length; k++) {
            res = Math.max(res, dfs(points, i - 1, k, memo) - Math.abs(j - k));
        }
        return memo[i][j] = res + points[i][j];
    }

    public long maxPoints2(int[][] points) {
        int n = points.length;
        int m = points[0].length;
        long[][] f = new long[n + 1][m + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                long res = 0;
                for (int k = 0; k < m; k++) {
                    res = Math.max(res, f[i][k + 1] - Math.abs(j - k));
                }
                f[i + 1][j + 1] = res + points[i][j];
            }
        }
        long ans = 0;
        for (int j = 0; j < m; j++) {
            ans = Math.max(ans, f[n][j + 1]);
        }
        return ans;
    }

    public long maxPoints3(int[][] points) {
        int n = points.length;
        int m = points[0].length;
        long[] f = new long[m];
        long[] t = new long[m];
        for (int i = 0; i < n; i++) {
            long best = Long.MIN_VALUE;
            for (int j = 0; j < m; j++) {
                best = Math.max(best, f[j] + j);
                t[j] = best - j + points[i][j];
            }
            best = Long.MIN_VALUE;
            for (int j = m - 1; j >= 0; j--) {
                best = Math.max(best, f[j] - j);
                t[j] = Math.max(t[j], best + j + points[i][j]);
            }
            long[] temp = f;
            f = t;
            t = temp;
        }
        long ans = 0;
        for (int j = 0; j < m; j++) {
            ans = Math.max(ans, f[j]);
        }
        return ans;
    }

}
