/**
 * 746. 使用最小花费爬楼梯：https://leetcode.cn/problems/min-cost-climbing-stairs
 */
public class MinCostClimbingStairs {

    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        }
        return dp[n];
    }

    public int minCostClimbingStairs2(int[] cost) {
        int n = cost.length;
        int[] dp = new int[2];
        for (int i = 2; i <= n; i++) {
            dp[i % 2] = Math.min(dp[(i - 1) % 2] + cost[i - 1], dp[(i - 2) % 2] + cost[i - 2]);
        }
        return dp[n % 2];
    }

    public int minCostClimbingStairs3(int[] cost) {
        int n = cost.length;
        int dp0 = 0, dp1 = 0;
        for (int i = 2; i <= n; i++) {
            int dp = Math.min(dp1 + cost[i - 1], dp0 + cost[i - 2]);
            dp0 = dp1;
            dp1 = dp;
        }
        return dp1;
    }

}
