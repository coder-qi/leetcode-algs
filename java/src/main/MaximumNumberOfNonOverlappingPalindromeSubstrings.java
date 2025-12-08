/**
 * 2472. 不重叠回文子字符串的最大数目：https://leetcode.cn/problems/maximum-number-of-non-overlapping-palindrome-substrings
 */
public class MaximumNumberOfNonOverlappingPalindromeSubstrings {

    public int maxPalindromes(String s, int k) {
        char[] str = s.toCharArray();
        int n = str.length;
        boolean[][] palindromesDp = new boolean[n][n];
        palindromesDp[0][0] = true;
        for (int i = 1; i < n; i++) {
            palindromesDp[i][i] = true;
            palindromesDp[i][i - 1] = true;
        }
        for (int i = n - 2; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                palindromesDp[i][j] = str[i] == str[j] && palindromesDp[i + 1][j - 1];
            }
        }

        int[] f = new int[n + 1];
        for (int i = 0; i < n; i++) {
            f[i + 1] = f[i];
            for (int j = i - k + 1; j >= 0; j--) {
                if (palindromesDp[j][i]) {
                    f[i + 1] = Math.max(f[i + 1], f[j] + 1);
                    break;
                }
            }
        }
        return f[n];
    }

}
