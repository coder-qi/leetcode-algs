/**
 * 583. 两个字符串的删除操作：https://leetcode.cn/problems/delete-operation-for-two-strings
 */
public class DeleteOperationForTwoStrings {

    public static int minDistance(String word1, String word2) {
        int M = word1.length();
        int N = word2.length();
        int[][] dp = new int[M + 1][N + 1];
        for (int i = 1; i <= M; i++) {
            dp[i][0] = i;
        }
        for (int i = 1; i <= N; i++) {
            dp[0][i] = i;
        }

        for (int i = 1; i <= M; i++) {
            for (int j = 1; j <= N; j++) {
                dp[i][j] = Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1);
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1]);
                }
            }
        }
        return dp[M][N];
    }

    public static int minDistance2(String word1, String word2) {
        int M = word1.length();
        int N = word2.length();
        if (N > M) {
            return minDistance2(word2, word1);
        }
        int[] dp1 = new int[N + 1];
        int[] dp2 = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            dp1[i] = i;
        }

        for (int i = 1; i <= M; i++) {
            dp2[0] = i;
            for (int j = 1; j <= N; j++) {
                dp2[j] = Math.min(dp1[j] + 1, dp2[j - 1] + 1);
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp2[j] = Math.min(dp2[j], dp1[j - 1]);
                }
            }
            int[] temp = dp1;
            dp1 = dp2;
            dp2 = temp;
        }
        return dp1[N];
    }


}
