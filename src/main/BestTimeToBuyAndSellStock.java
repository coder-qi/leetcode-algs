/**
 * 买卖股票的最佳时机：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/
 */
public class BestTimeToBuyAndSellStock {

    public static int maxProfit(int[] prices) {
        int n = prices.length;
        int result = 0;
        int buy = 0, sell = 0;
        for (int i = 1; i < n; i++) {
            if (prices[buy] > prices[i]) {
                buy = i;
            }
            if (prices[sell] < prices[i]) {
                sell = i;
            }
            if (buy > sell) {
                buy = sell = i;
            }
            result = Math.max(result, prices[sell] - prices[buy]);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[] {7,1,5,3,6,4}));
        System.out.println(maxProfit(new int[] {7,6,4,3,1}));
        System.out.println(maxProfit(new int[] {2,4,1}));
    }

}
