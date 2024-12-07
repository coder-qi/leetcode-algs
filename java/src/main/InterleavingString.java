import java.util.Arrays;

/**
 * 交错字符串：https://leetcode-cn.com/problems/interleaving-string/
 */
public class InterleavingString {

    public static boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length(), n = s2.length();
        if (m + n != s3.length()) {
            return false;
        }
        boolean[] dp = new boolean[n + 1];

        dp[0] = true;
        for (int j = 1; j <= n; j++) {
            dp[j] = dp[j - 1] && s2.charAt(j - 1) == s3.charAt(j - 1);
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                dp[j] = (dp[j] && s1.charAt(i - 1) == s3.charAt(i - 1 + j))
                    || (j > 0 && dp[j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1));
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(isInterleave("aabcc", "dbbca", "aadbbcbcac")); // true
        System.out.println(isInterleave("aabcc", "dbbca", "aadbbbaccc")); // false
        System.out.println(isInterleave("", "", "")); // true
        System.out.println(isInterleave("", "", "aaa")); // false
        System.out.println(isInterleave("a", "", "c")); // false
    }

}
