package lcr;

/**
 * LCR 165. 解密数字：https://leetcode.cn/problems/ba-shu-zi-fan-yi-cheng-zi-fu-chuan-lcof
 */
public class LCR165_CrackNumber {

    public int crackNumber(int ciphertext) {
        char[] str = String.valueOf(ciphertext).toCharArray();
        int n = str.length;
        int[] dp = new int[n + 1];
        dp[0] = dp[1] = 1;
        for (int i = 1; i < n; i++) {
            dp[i + 1] = dp[i];

            int x = (str[i - 1] - '0') * 10 + str[i] - '0';
            if (x >= 10 && x <= 25) {
                dp[i + 1] += dp[i - 1];
            }
        }
        return dp[n];
    }

}
