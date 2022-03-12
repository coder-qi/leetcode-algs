/**
 * 买卖股票的最佳时机 III：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iii/
 */
public class BestTimeToBuyAndSellStockIII {

    public static int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2];
        int minPrice = prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], prices[i] - minPrice);
            minPrice = Math.min(minPrice, prices[i]);
        }

        int result = 0;
        int maxPrice = prices[prices.length - 1];
        for (int i = prices.length - 2; i >= 0; i--) {
            dp[i][1] = Math.max(dp[i + 1][1], maxPrice - prices[i]);
            maxPrice = Math.max(maxPrice, prices[i]);

            result = Integer.max(result, dp[i][0] + dp[i][1]);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[] {3,3,5,0,0,3,1,4}));
        System.out.println(maxProfit(new int[] {1,2,3,4,5}));
        System.out.println(maxProfit(new int[] {7,6,4,3,1}));
        System.out.println(maxProfit(new int[] {1,2,4,2,5,7,2,4,9,0})); // 13
    }

}
