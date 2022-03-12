/**
 *  买卖股票的最佳时机 II：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/
 */
public class BestTimeToBuyAndSellStockII {

    public static int maxProfit(int[] prices) {
        int minPrice = prices[0], maxPrice = prices[0];
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < maxPrice) {
                maxProfit += maxPrice - minPrice;
                maxPrice = minPrice = prices[i];
            } else {
                maxPrice = prices[i];
            }
        }
        if (maxPrice > minPrice) {
            maxProfit += maxPrice - minPrice;
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[] {7,1,5,3,6,4}));
        System.out.println(maxProfit(new int[] {1,2,3,4,5}));
        System.out.println(maxProfit(new int[] {7,6,4,3,1}));
    }

}
