import java.util.ArrayList;
import java.util.List;

/**
 * 3562. 折扣价交易股票的最大利润：https://leetcode.cn/problems/maximum-profit-from-trading-stocks-with-discounts
 */
public class MaximumProfitFromTradingStocksWithDiscounts {

    public int maxProfit(int n, int[] present, int[] future, int[][] hierarchy, int budget) {
        List<Integer>[] g = new List[n];
        for (int i = 0; i < n; i++) {
            g[i] = new ArrayList<>();
        }
        for (int[] h : hierarchy) {
            g[h[0] - 1].add(h[1] - 1);
        }
        return dfs(g, 0, false, budget, present, future);
    }

    private int dfs(List<Integer>[] g, int u, boolean b, int budget, int[] present, int[] future) {
        if (budget == 0) {
            return 0;
        }
        int res1 = 0;
        // 购买
        if (present[u] <= budget) {
            int f = b ? future[u] / 2 : future[u];
            res1 = f - present[u];
            for (int v : g[u]) {
                res1 += dfs(g, v, true, budget - f, present, future);
            }
        }
        // 不买
        int res2 = 0;
        for (int v : g[u]) {
            res2 += dfs(g, v, false, budget, present, future);
        }
        return Math.max(res1, res2);
    }

}
