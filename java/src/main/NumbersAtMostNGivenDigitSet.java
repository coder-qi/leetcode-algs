/**
 * 902. 最大为 N 的数字组合：https://leetcode.cn/problems/numbers-at-most-n-given-digit-set/
 */
public class NumbersAtMostNGivenDigitSet {

    public static void main(String[] args) {
        System.out.println(new NumbersAtMostNGivenDigitSet()
            .atMostNGivenDigitSet(new String[] {"1","3","5","7"}, 100)); // 20
        System.out.println(new NumbersAtMostNGivenDigitSet()
            .atMostNGivenDigitSet(new String[] {"1","4","9"}, 1000000000)); // 29523
    }

    public int atMostNGivenDigitSet(String[] digits, int n) {
        String s = String.valueOf(n);
        int k = s.length();
        int[] dp = new int[k + 1];
        dp[k] = 1;
        for (int i = k - 1; i >= 0; i--) {
            int d = s.charAt(i) - '0';
            for (String digit : digits) {
                if (Integer.valueOf(digit) < d) {
                    dp[i] += Math.pow(digits.length, k - i - 1);
                } else if (Integer.valueOf(digit) == d) {
                    dp[i] += dp[i + 1];
                } else {
                    break;
                }
            }
        }
        for (int i = 1; i < k; i++) {
            dp[0] += Math.pow(digits.length, i);
        }
        return dp[0];
    }

}
