/**
 * 通配符匹配：https://leetcode-cn.com/problems/wildcard-matching/
 */
public class WildcardMatching {

    /**
     * 动态规划
     * 时间复杂度：O(mn)
     * 空间复杂度：O(mn)
     */
    public static boolean isMatch_dp(String s, String p) {
        int m = s.length(), n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int i = 1; i <= n; i++) {
            if (p.charAt(i - 1) == '*' && dp[0][i - 1]) {
                dp[0][i] = true;
            }
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                } else {
                    if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?') {
                        dp[i][j] = dp[i - 1][j - 1];
                    }
                }
            }
        }
        return dp[m][n];
    }

    public static boolean isMatch(String s, String p) {
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isMatch("aa", "a")); // false
        System.out.println(isMatch("aa", "*")); // true
        System.out.println(isMatch("cb", "?a")); // false
        System.out.println(isMatch("adceb", "*a*b")); // true
        System.out.println(isMatch("acdcb", "a*c?b")); // false
    }

}
