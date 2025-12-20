import java.util.Arrays;

/**
 * 3573. 买卖股票的最佳时机 V：https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-v
 */
public class BestTimeToBuyAndSellStockV {

    public long maximumProfit(int[] prices, int k) {
        int n = prices.length;
        long[][][] memo = new long[n][k + 1][3];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= k; j++) {
                Arrays.fill(memo[i][j], -1);
            }
        }
        return dfs(prices, 0, k, 0, memo);
    }

    // state, 0: 未持有股票，1：买入股票，2：做空（卖出）
    private long dfs(int[] prices, int i, int j, int state, long[][][] memo) {
        if (j < 0) {
            return Long.MIN_VALUE / 2;
        }
        if (i >= prices.length) {
            return state == 0 ? 0 : Long.MIN_VALUE / 2;
        }
        if (memo[i][j][state] != -1) {
            return memo[i][j][state];
        }
        if (state == 0) {
            return memo[i][j][state] = Math.max(dfs(prices, i + 1, j, 0, memo),
                        Math.max(dfs(prices, i + 1, j - 1, 1, memo) - prices[i],
                                dfs(prices, i + 1, j - 1, 2, memo) + prices[i]));
        }
        if (state == 1) {
            return memo[i][j][state] = Math.max(dfs(prices, i + 1, j, 1, memo),
                                                dfs(prices, i + 1, j, 0, memo) + prices[i]);
        }
        return memo[i][j][state] = Math.max(dfs(prices, i + 1, j, 2, memo),
                                            dfs(prices, i + 1, j, 0, memo) - prices[i]);
    }

    public long maximumProfit2(int[] prices, int k) {
        int n = prices.length;
        long[][][] f = new long[n + 1][k + 2][3];
        for (int j = 0; j <= k + 1; j++) {
            f[n][j][1] = f[n][j][2] = Long.MIN_VALUE / 2;
        }
        for (int i = 0; i < n; i++) {
            f[i][0][0] = f[i][0][1] = f[i][0][2] = Long.MIN_VALUE / 2;
        }
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 1; j <= k + 1; j++) {
                f[i][j][0] = Math.max(f[i + 1][j][0],
                        Math.max(f[i + 1][j - 1][1] - prices[i], f[i + 1][j - 1][2] + prices[i]));
                f[i][j][1] = Math.max(f[i + 1][j][1], f[i + 1][j][0] + prices[i]);
                f[i][j][2] = Math.max(f[i + 1][j][2], f[i + 1][j][0] - prices[i]);
            }
        }
        return f[0][k + 1][0];
    }

    public long maximumProfit3(int[] prices, int k) {
        int n = prices.length;
        long[][][] f = new long[2][k + 2][3];
        for (int j = 0; j <= k + 1; j++) {
            f[n % 2][j][1] = f[n % 2][j][2] = Long.MIN_VALUE / 2;
        }
        f[0][0][0] = f[0][0][1] = f[0][0][2] = Long.MIN_VALUE / 2;
        f[1][0][0] = f[1][0][1] = f[1][0][2] = Long.MIN_VALUE / 2;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 1; j <= k + 1; j++) {
                f[i % 2][j][0] = Math.max(f[(i + 1) % 2][j][0],
                        Math.max(f[(i + 1) % 2][j - 1][1] - prices[i], f[(i + 1) % 2][j - 1][2] + prices[i]));
                f[i % 2][j][1] = Math.max(f[(i + 1) % 2][j][1], f[(i + 1) % 2][j][0] + prices[i]);
                f[i % 2][j][2] = Math.max(f[(i + 1) % 2][j][2], f[(i + 1) % 2][j][0] - prices[i]);
            }
        }
        return f[0][k + 1][0];
    }

    public long maximumProfit4(int[] prices, int k) {
        int n = prices.length;
        long[][] f = new long[k + 2][3];
        for (int j = 0; j <= k + 1; j++) {
            f[j][1] = f[j][2] = Long.MIN_VALUE / 2;
        }
        f[0][0] = f[0][1] = f[0][2] = Long.MIN_VALUE / 2;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 1; j <= k + 1; j++) {
                f[j][1] = Math.max(f[j][1], f[j][0] + prices[i]);
                f[j][2] = Math.max(f[j][2], f[j][0] - prices[i]);
                f[j][0] = Math.max(f[j][0], Math.max(f[j - 1][1] - prices[i], f[j - 1][2] + prices[i]));
            }
        }
        return f[k + 1][0];
    }

}
