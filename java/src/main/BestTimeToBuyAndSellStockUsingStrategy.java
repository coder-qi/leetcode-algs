import static util.ArrayUtils.array;

/**
 * 3652. 按策略买卖股票的最佳时机：https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-using-strategy
 */
public class BestTimeToBuyAndSellStockUsingStrategy {

    public long maxProfit(int[] prices, int[] strategy, int k) {
        int n = prices.length;
        long s = 0;
        for (int i = 0; i < n; i++) {
            s += (long) prices[i] * strategy[i];
        }
        long sHold = 0, sSell = 0;
        long ans = s;
        for (int i = 0; i < n; i++) {
            if (strategy[i] < 0) {
                sSell += (long) prices[i] * 2;
            } else if (strategy[i] == 0) {
                sSell += prices[i];
            }
            if (i >= k / 2) {
                if (strategy[i - k / 2] < 0) {
                    sSell -= (long) prices[i - k / 2] * 2;
                } else if (strategy[i - k / 2] == 0) {
                    sSell -= prices[i - k / 2];
                }
                sHold += (long) prices[i - k / 2] * strategy[i - k / 2];
            }
            if (i + 1 < k) {
                continue;
            }
            ans = Math.max(ans, s - sHold + sSell);
            sHold -= (long) prices[i - k + 1] * strategy[i - k + 1];
        }
        return ans;
    }

    public long maxProfit2(int[] prices, int[] strategy, int k) {
        int n = prices.length;
        long s = 0;
        for (int i = 0; i < n; i++) {
            s += (long) prices[i] * strategy[i];
        }
        long sHold = 0, sSell = 0;
        long ans = s;
        for (int i = 0; i < n; i++) {
            sSell += (long) prices[i] * (-strategy[i] + 1);
            if (i >= k / 2) {
                sSell -= (long) prices[i - k / 2] * (-strategy[i - k / 2] + 1);
                sHold += (long) prices[i - k / 2] * strategy[i - k / 2];
            }
            if (i + 1 < k) {
                continue;
            }
            ans = Math.max(ans, s - sHold + sSell);
            sHold -= (long) prices[i - k + 1] * strategy[i - k + 1];
        }
        return ans;
    }

    // 前缀和
    public long maxProfit3(int[] prices, int[] strategy, int k) {
        int n = prices.length;
        long[] sum = new long[n + 1];
        long[] sumSell = new long[n + 1];
        for (int i = 0; i < n; i++) {
            sum[i + 1] = sum[i] + (long) prices[i] * strategy[i];
            sumSell[i + 1] = sumSell[i] + prices[i];
        }
        long ans = sum[n];
        for (int i = k; i <= n; i++) {
            ans = Math.max(ans, sum[i - k] + sum[n] - sum[i] + sumSell[i] - sumSell[i - k / 2]);
        }
        return ans;
    }

    // 滑动窗口
    public long maxProfit4(int[] prices, int[] strategy, int k) {
        long total = 0;
        long sum = 0;
        for (int i = 0; i < k / 2; i++) {
            int p = prices[i], s = strategy[i];
            total += (long) p * s;
            sum -= (long) p * s;
        }
        for (int i = k / 2; i < k; i++) {
            int p = prices[i], s = strategy[i];
            total += (long) p * s;
            sum += (long) p * (1 - s);
        }
        long maxSum = Math.max(sum, 0);
        int n = prices.length;
        for (int i = k; i < n; i++) {
            int p = prices[i], s = strategy[i];
            total += (long) p * s;
            sum += (long) p * (1 - s) - prices[i - k / 2] + (long) prices[i - k] * strategy[i - k];
            maxSum = Math.max(maxSum, sum);
        }
        return total + maxSum;
    }

    public long maxProfit5(int[] prices, int[] strategy, int k) {
        long total = 0;
        long sum = 0;
        long maxSum = 0;
        int n = prices.length;
        for (int i = 0; i < n; i++) {
            int p = prices[i], s = strategy[i];
            total += (long) p * s;
            sum += (long) p * (1 - s);
            if (i < k - 1) {
                if (i + 1 >= k / 2) {
                    sum -= prices[i - k / 2 + 1];
                }
                continue;
            }
            maxSum = Math.max(maxSum, sum);

            sum -= prices[i - k / 2 + 1] - (long) prices[i - k + 1] * strategy[i - k + 1];
        }
        return total + maxSum;
    }

    public static void main(String[] args) {
        BestTimeToBuyAndSellStockUsingStrategy app = new BestTimeToBuyAndSellStockUsingStrategy();
        System.out.println(app.maxProfit5(array("[4,2,8]"), array("[-1,0,1]"), 2)); // 10
        System.out.println(app.maxProfit5(array("[5,8]"), array("[-1,-1]"), 2));  // 8
        System.out.println(app.maxProfit5(array("[9,2,9,5]"), array("[-1,0,1,1]"), 4));  // 14
    }

}
