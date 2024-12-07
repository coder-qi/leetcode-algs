/**
 * 264. 丑数 II：https://leetcode.cn/problems/ugly-number-ii/
 */
public class UglyNumberII {

    public static int nthUglyNumber(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        int p2 = 1, p3 = 1, p5 = 1;
        for (int i = 2; i <= n; i++) {
            int num2 = dp[p2] * 2, num3 = dp[p3] * 3, num5 = dp[p5] * 5;
            dp[i] = Math.min(num2, Math.min(num3, num5));
            if (dp[i] == num2) {
                p2++;
            }
            if (dp[i] == num3) {
                p3++;
            }
            if (dp[i] == num5) {
                p5++;
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(nthUglyNumber(10)); // 12
        System.out.println(nthUglyNumber(1)); // 1
        System.out.println(nthUglyNumber(1690)); // 2123366400
    }

}
