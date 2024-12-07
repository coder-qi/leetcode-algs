/**
 * 解码方法：https://leetcode-cn.com/problems/decode-ways/
 */
public class DecodeWays {

    public int numDecodings(String s) {
        int[] dp = new int[s.length() + 1];
        dp[0] = s.charAt(0) == '0' ? 0 : 1;
        for (int i = 0; i < s.length(); i++) {
            dp[i + 1] = s.charAt(i) == '0' ? 0 : dp[i];
            if (i > 0 && (s.charAt(i - 1) == '1'
                || (s.charAt(i - 1) == '2' && s.charAt(i) <= '6'))) {
                dp[i + 1] += dp[i - 1];
            }
        }
        return dp[s.length()];
    }

    public static void main(String[] args) {
        System.out.println(new DecodeWays().numDecodings("12")); // 2
        System.out.println(new DecodeWays().numDecodings("226")); // 3
        System.out.println(new DecodeWays().numDecodings("0")); // 0
        System.out.println(new DecodeWays().numDecodings("111111111111111111111111111111111111111111111")); // 0
        System.out.println(new DecodeWays().numDecodings("2101")); // 1
    }

}
