package weekly.w299;

/**
 * 2320. 统计放置房子的方式数：https://leetcode.cn/problems/count-number-of-ways-to-place-houses/
 */
public class CountNumberOfWaysToPlaceHouses {

    static final int MOD = (int) (1e9 + 7);

    public static int countHousePlacements(int n) {
        int[] dp = new int[n + 2];
        dp[0] = dp[1] = 1;
        for (int i = 2; i < n + 2; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % MOD;
        }
        return (int) ((dp[n + 1] * (long)dp[n + 1]) % MOD);
    }

    public static void main(String[] args) {
        System.out.println(countHousePlacements(1)); // 4
        System.out.println(countHousePlacements(2)); // 9
    }

}
