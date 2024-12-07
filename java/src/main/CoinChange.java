import java.util.Arrays;

/**
 * 322. 零钱兑换：https://leetcode.cn/problems/coin-change
 */
public class CoinChange {

    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            int res = Integer.MAX_VALUE;
            for (int coin : coins) {
                int k = i - coin;
                if (k >= 0) {
                    res = Math.min(res, dp[k]);
                }
            }
            if (res != Integer.MAX_VALUE) {
                dp[i] = res + 1;
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        System.out.println(new CoinChange().coinChange(new int[] {1, 2, 5}, 11));
    }

}
