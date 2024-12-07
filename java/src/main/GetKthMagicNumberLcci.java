/**
 * 面试题 17.09. 第 k 个数：https://leetcode.cn/problems/get-kth-magic-number-lcci/
 */
public class GetKthMagicNumberLcci {

    public static void main(String[] args) {
        System.out.println(getKthMagicNumber(5)); // 9
        System.out.println(getKthMagicNumber(1000)); // 232
    }

    public static int getKthMagicNumber(int k) {
        int[] dp = new int[k + 1];
        dp[1] = 1;
        int p3 = 1, p5 = 1, p7 = 1;
        for (int i = 2; i <= k; i++) {
            int num3 = dp[p3] * 3, num5 = dp[p5] * 5, num7 = dp[p7] * 7;
            dp[i] = Math.min(num3, Math.min(num5, num7));
            if (num3 == dp[i]) {
                p3++;
            }
            if (num5 == dp[i]) {
                p5++;
            }
            if (num7 == dp[i]) {
                p7++;
            }
        }
        return dp[k];
    }

}
