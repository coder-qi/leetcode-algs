/**
 * 3756. 连接非零数字并乘以其数字和 II：https://leetcode.cn/problems/concatenate-non-zero-digits-and-multiply-by-sum-ii
 */
public class ConcatenateNonZeroDigitsAndMultiplyBySumII {

    private static final int MOD = 1_000_000_007;
    private static final int MAX_N = 100_001;
    private static final int[] pow10 = new int[MAX_N];
    private static boolean initialized = false;

    public int[] sumAndMultiply(String s, int[][] queries) {
        if (!initialized) {
            // 预处理 10 的幂
            pow10[0] = 1;
            for (int i = 1; i < MAX_N; i++) {
                pow10[i] = (int) (pow10[i - 1] * 10L % MOD);
            }
        }
        initialized = true;

        int m = s.length();
        char[] str = s.toCharArray();
        int[] preSum = new int[m + 1];
        int[] preMultiply = new int[m + 1];
        int[] sumNonZero = new int[m + 1];
        for (int i = 0; i < m; i++) {
            int d = str[i] - '0';
            preSum[i + 1] = preSum[i] + d;
            preMultiply[i + 1] = d > 0 ? (int) ((preMultiply[i] * 10L + d) % MOD) : preMultiply[i];
            sumNonZero[i + 1] = sumNonZero[i] + (d > 0 ? 1 : 0);
        }

        int n = queries.length;
        int[] ans = new int[n];
        for (int i = 0; i < queries.length; i++) {
            int l = queries[i][0];
            int r = queries[i][1] + 1;
            int len = sumNonZero[r] - sumNonZero[l];
            long x = preMultiply[r] - (long) preMultiply[l] * pow10[len] % MOD + MOD;
            ans[i] = (int)(x * (preSum[r] - preSum[l]) % MOD);
        }
        return ans;
    }

}
