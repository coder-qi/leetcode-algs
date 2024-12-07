/**
 * 600. 不含连续1的非负整数：https://leetcode.cn/problems/non-negative-integers-without-consecutive-ones/
 */
public class NonNegativeIntegersWithoutConsecutiveOnes {

    public static void main(String[] args) {
        System.out.println(new NonNegativeIntegersWithoutConsecutiveOnes().findIntegers(5)); // 5
        System.out.println(new NonNegativeIntegersWithoutConsecutiveOnes().findIntegers(100000000)); // 514229
    }

    public int findIntegers(int n) {
        int[] dp = new int[32];
        dp[0] = 1;
        dp[1] = 2;
        for (int i = 2; i < 32; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        int ans = 0, prev = 0;
        for (int i = 30; i >= 0; i--) {
            if ((n & (1 << i)) != 0) {
                ans += dp[i];
                if (prev == 1) {
                    return ans;
                }
                prev = 1;
            } else {
                prev = 0;
            }
        }
        return ans + 1;
    }

}
