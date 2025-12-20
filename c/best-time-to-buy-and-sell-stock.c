/**
 * 121. 买卖股票的最佳时机：https://leetcode.cn/problems/best-time-to-buy-and-sell-stock
 */

#define MIN(a,b) (((a)<(b))?(a):(b))
#define MAX(a,b) (((a)>(b))?(a):(b))

int maxProfit(int *prices, int n) {
    int ans = 0;
    int min = prices[0];
    for (int i = 1; i < n; i++) {
        min = MIN(min, prices[i]);
        ans = MAX(ans, prices[i] - min);
    }
    return ans;
}
