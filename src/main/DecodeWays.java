/**
 * 解码方法：https://leetcode-cn.com/problems/decode-ways/
 */
public class DecodeWays {

    public int numDecodings(String s) {
        int[] dp = new int[s.length()];
        dp[0] = s.charAt(0) == '0' ? 0 : 1;
        for (int i = 1; i < s.length(); i++) {
            char cur = s.charAt(i);
            char prev = s.charAt(i - 1);
            if (cur == '0') {
                if (prev == '0' || prev >= '3') {
                    break;
                }
                dp[i] = dp[i - 1];
            } else {
                if (i + 1 < s.length() && s.charAt(i + 1) == '0') {
                    dp[i] += dp[i - 1];
                    continue;
                }
                if (prev == '1' || (prev == '2' && cur <= '6')) {
                    dp[i] += i >= 2 ? dp[i - 2] : 1;
                }
                dp[i] += dp[i - 1];
            }
        }
        return dp[s.length() - 1];
    }

    public static void main(String[] args) {
        System.out.println(new DecodeWays().numDecodings("12")); // 2
        System.out.println(new DecodeWays().numDecodings("226")); // 3
        System.out.println(new DecodeWays().numDecodings("0")); // 0
        System.out.println(new DecodeWays().numDecodings("111111111111111111111111111111111111111111111")); // 0
        System.out.println(new DecodeWays().numDecodings("2101")); // 1
    }

}
