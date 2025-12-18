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

    public static void main(String[] args) {
        BestTimeToBuyAndSellStockUsingStrategy app = new BestTimeToBuyAndSellStockUsingStrategy();
        System.out.println(app.maxProfit(array("[4,2,8]"), array("[-1,0,1]"), 2)); // 10
        System.out.println(app.maxProfit(array("[5,8]"), array("[-1,-1]"), 2));  // 8
        System.out.println(app.maxProfit(array("[9,2,9,5]"), array("[-1,0,1,1]"), 4));  // 8
    }

}
