import java.util.Arrays;

/**
 * 分割回文串 II：https://leetcode-cn.com/problems/palindrome-partitioning-ii/
 */
public class PalindromePartitioningII {

    public int minCut(String s) {
        int n = s.length();
        boolean[][] f = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(f[i], true);
        }
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                f[i][j] = s.charAt(i) == s.charAt(j) && f[i + 1][j - 1];
            }
        }

        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        for (int i = 0; i < n; i++) {
            if (f[0][i]) {
                dp[i] = 0;
            } else {
                for (int j = 0; j < i; j++) {
                    if (f[j + 1][i]) {
                        dp[i] = Math.min(dp[i], dp[j] + 1);
                    }
                }
            }
        }
        return dp[n - 1];
    }

    public static void main(String[] args) {
        System.out.println(new PalindromePartitioningII().minCut("aab"));
        System.out.println(new PalindromePartitioningII().minCut("a"));
        System.out.println(new PalindromePartitioningII().minCut("ab"));
        System.out.println(new PalindromePartitioningII().minCut("abcdda"));
        System.out.println(new PalindromePartitioningII().minCut("fifgbeajcacehiicccfecbfhhgfiiecdcjjffbghdidbhbdbfbfjccgbbdcjheccfbhafehieabbdfeigbiaggchaeghaijfbjhi"));
    }

}
