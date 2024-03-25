import java.util.Arrays;

/**
 * 518. 零钱兑换 II：https://leetcode.cn/problems/coin-change-ii
 */
public class CoinChangeII {

    public int change(int amount, int[] coins) {
        int[][] dp = new int[amount + 1][coins.length + 1];
        Arrays.fill(dp[0], 1);
        for (int i = coins.length - 1; i >= 0; i--) {
            for (int rest = 1; rest <= amount; rest++) {
                int res = 0;
                int count = rest / coins[i];
                for (int k = 0; k <= count; k++) {
                    res += dp[rest - coins[i] * k][i + 1];
                }
                dp[rest][i] = res;
            }
        }
        return dp[amount][0];
    }

    public static void main(String[] args) {
        System.out.println(new CoinChangeII().change(500, new int[] {2, 7, 13}));
    }

}
