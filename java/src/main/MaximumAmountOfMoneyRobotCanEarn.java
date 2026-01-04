import java.util.Arrays;

/**
 * 3418. 机器人可以获得的最大金币数：https://leetcode.cn/problems/maximum-amount-of-money-robot-can-earn
 */
public class MaximumAmountOfMoneyRobotCanEarn {

    public int maximumAmount(int[][] coins) {
        int m = coins.length;
        int n = coins[0].length;
        int[][][] memo = new int[m][n][3];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(memo[i][j], Integer.MIN_VALUE);
            }
        }
        return dfs(coins, m - 1, n - 1, 2, memo);
    }

    private int dfs(int[][] coins, int i, int j, int k, int[][][] memo) {
        if (i < 0 || j < 0) {
            return i == 0 ? 0 : Integer.MIN_VALUE / 2;
        }
        if (memo[i][j][k] != Integer.MIN_VALUE) {
            return memo[i][j][k];
        }
        int res = Math.max(dfs(coins, i - 1, j, k, memo), dfs(coins, i, j - 1, k, memo)) + coins[i][j];
        if (k > 0 && coins[i][j] < 0) {
            res = Math.max(res, Math.max(dfs(coins, i - 1, j, k - 1, memo), dfs(coins, i, j - 1, k - 1, memo)));
        }
        return memo[i][j][k] = res;
    }

    public int maximumAmount2(int[][] coins) {
        int m = coins.length;
        int n = coins[0].length;
        int[][][] f = new int[m + 1][n + 1][3];
        for (int i = 0; i <= m; i++) {
            Arrays.fill(f[i][0], Integer.MIN_VALUE / 2);
        }
        for (int j = 0; j <= n; j++) {
            Arrays.fill(f[0][j], Integer.MIN_VALUE / 2);
        }
        Arrays.fill(f[1][0], 0);
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                for (int k = 0; k < 3; k++) {
                    int res = Math.max(f[i - 1][j][k], f[i][j - 1][k]) + coins[i - 1][j - 1];
                    if (k > 0) {
                        res = Math.max(res, Math.max(f[i - 1][j][k - 1], f[i][j - 1][k - 1]));
                    }
                    f[i][j][k] = res;
                }
            }
        }
        return f[m][n][2];
    }

    public int maximumAmount3(int[][] coins) {
        int m = coins.length;
        int n = coins[0].length;
        int[][][] f = new int[2][n + 1][3];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j <= n; j++) {
                f[i][j][0] = f[i][j][1] = f[i][j][2] = Integer.MIN_VALUE / 2;
            }
        }
        f[0][1][0] = f[0][1][1] = f[0][1][2] = 0;

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                int preI = (i - 1) % 2, curI = i % 2;
                for (int k = 0; k < 3; k++) {
                    int res = Math.max(f[preI][j][k], f[curI][j - 1][k]) + coins[i - 1][j - 1];
                    if (k > 0) {
                        res = Math.max(res, Math.max(f[preI][j][k - 1], f[curI][j - 1][k - 1]));
                    }
                    f[curI][j][k] = res;
                }
            }
        }
        return f[m % 2][n][2];
    }

}
