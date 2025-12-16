import util.ArrayUtils;

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
        return dfs(g, 0, 0, budget, present, future);
    }

    private int dfs(List<Integer>[] g, int u, int bossBuy, int budget, int[] present, int[] future) {
        if (budget == 0) {
            return 0;
        }
        int res1 = 0;
        int p = bossBuy == 1 ? present[u] / 2 : present[u];
        // 购买
        if (p <= budget) {
            res1 = future[u] - p;
            for (int v : g[u]) {
                res1 += dfs(g, v, 1, budget - p, present, future);
            }
        }
        // 不买
        int res2 = 0;
        for (int v : g[u]) {
            res2 += dfs(g, v, 0, budget, present, future);
        }
        return Math.max(res1, res2);
    }

    public static void main(String[] args) {
        MaximumProfitFromTradingStocksWithDiscounts app = new MaximumProfitFromTradingStocksWithDiscounts();
        System.out.println(app.maxProfit(3, ArrayUtils.array("[4,6,8]"),
                ArrayUtils.array("[7,9,11]"),
                ArrayUtils.matrix("[[1,2],[1,3]]"), 10));
    }

}
