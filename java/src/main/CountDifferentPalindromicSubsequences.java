/**
 * 730. 统计不同回文子序列：https://leetcode.cn/problems/count-different-palindromic-subsequences/
 */
public class CountDifferentPalindromicSubsequences {

    static final int MOD = (int) (1e9 + 7);

    public static int countPalindromicSubsequences(String s) {
        int n = s.length();
        int[][][] dp = new int[4][n][n];
        for (int i = 0; i < n; i++) {
            dp[s.charAt(i) - 'a'][i][i] = 1;
        }

        for (int len = 2; len <= n; len++) {
            for (int i = 0; i + len <= n; i++) {
                int j = i + len - 1;
                for (char c = 'a'; c <= 'd'; c++) {
                    int k = c - 'a';
                    if (s.charAt(i) == c && s.charAt(j) == c) {
                        dp[k][i][j] = 2;
                        for (int p = 0; p < dp.length; p++) {
                            dp[k][i][j] = (dp[k][i][j] + dp[p][i + 1][j - 1]) % MOD;
                        }
                    } else if (s.charAt(i) == c) {
                        dp[k][i][j] = dp[k][i][j - 1];
                    } else if (s.charAt(j) == c) {
                        dp[k][i][j] = dp[k][i + 1][j];
                    } else {
                        dp[k][i][j] = dp[k][i + 1][j - 1];
                    }
                }
            }
        }

        int result = 0;
        for (int i = 0; i < dp.length; i++) {
            result = (result + dp[i][0][n - 1]) % MOD;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(countPalindromicSubsequences("bccb")); // 6
        // 104860361
        System.out.println(countPalindromicSubsequences("abcdabcdabcdabcdabcdabcdabcdabcddcbadcbadcbadcbadcbadcbadcbadcba"));
    }

}
