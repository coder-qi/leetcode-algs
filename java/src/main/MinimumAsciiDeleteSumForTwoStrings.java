/**
 * 712. 两个字符串的最小ASCII删除和：https://leetcode.cn/problems/minimum-ascii-delete-sum-for-two-strings
 */
public class MinimumAsciiDeleteSumForTwoStrings {

    public static int minimumDeleteSum(String s1, String s2) {
        int M = s1.length();
        int N = s2.length();
        int[][] dp = new int[M + 1][N + 1];

        for (int i = 1; i <= M; i++) {
            dp[i][0] += dp[i - 1][0] + s1.charAt(i - 1);
        }
        for (int i = 1; i <= N; i++) {
            dp[0][i] += dp[0][i - 1] + s2.charAt(i - 1);
        }
        for (int i = 1; i <= M; i++) {
            for (int j = 1; j <= N; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j] + s1.charAt(i - 1), dp[i][j - 1] + s2.charAt(j - 1));
                }
            }
        }
        return dp[M][N];
    }

    public static int minimumDeleteSum2(String s1, String s2) {
        int M = s1.length();
        int N = s2.length();
        if (N > M) {
            return minimumDeleteSum2(s2, s1);
        }
        int[] dp1 = new int[N + 1];
        int[] dp2 = new int[N + 1];
        int[] initM = new int[M + 1];
        for (int i = 1; i <= M; i++) {
            initM[i] += initM[i - 1] + s1.charAt(i - 1);
        }
        for (int i = 1; i <= N; i++) {
            dp1[i] += dp1[i - 1] + s2.charAt(i - 1);
        }
        for (int i = 1; i <= M; i++) {
            dp2[0] = initM[i];
            for (int j = 1; j <= N; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp2[j] = dp1[j - 1];
                } else {
                    dp2[j] = Math.min(dp1[j] + s1.charAt(i - 1), dp2[j - 1] + s2.charAt(j - 1));
                }
            }
            int[] temp = dp1;
            dp1 = dp2;
            dp2 = temp;
        }
        return dp1[N];
    }

}
