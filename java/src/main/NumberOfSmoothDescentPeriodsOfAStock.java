/**
 * 2110. 股票平滑下跌阶段的数目：https://leetcode.cn/problems/number-of-smooth-descent-periods-of-a-stock
 */
public class NumberOfSmoothDescentPeriodsOfAStock {

    public long getDescentPeriods(int[] prices) {
        int n = prices.length;
        long ans = 1;
        int cnt = 1;
        for (int i = 1; i < n; i++) {
            if (prices[i] + 1 == prices[i - 1]) {
                cnt++;
            } else {
                cnt = 1;
            }
            ans += cnt;
        }
        return ans;
    }

}
