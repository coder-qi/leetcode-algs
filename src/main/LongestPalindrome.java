import java.util.ArrayList;
import java.util.List;

/**
 * 最长回文子串：https://leetcode-cn.com/problems/longest-palindromic-substring/
 */
public class LongestPalindrome {

    /**
     * 暴力破解法：O(N^3)
     */
    public static String longestPalindromeBruteForce(String s) {
        StringBuilder sb = new StringBuilder();
        String result = s.length() == 0 ? "" : String.valueOf(s.charAt(0));
        for (int i = 0; i < s.length(); i++) {
            sb.setLength(0);
            sb.append(s.charAt(i));
            for (int j = i + 1; j < s.length(); j++) {
                sb.append(s.charAt(j));
                boolean b = true;
                for (int k = 0; k <= sb.length() / 2; k++) {
                    if (sb.charAt(k) != sb.charAt(sb.length() - 1 - k)) {
                        b = false;
                        break;
                    }
                }
                if (b && sb.length() > result.length()) {
                    result = sb.toString();
                    if (result.length() == s.length()) {
                        return result;
                    }
                }
            }
        }
        if (sb.length() > result.length()) {
            result = sb.toString();
        }
        return result;
    }

    /**
     * 思路：从后往前找对称的字符，O(n^2)
     */
    public static String longestPalindrome2(String s) {
        String result = "";
        for (int i = 0; i < s.length(); i++) {
            result = longestPalindrome2(result, s, i);
            if (result.length() >= s.length() - i) {
                break;
            }
        }
        return result;
    }

    private static String longestPalindrome2(String max, String s, int start) {
        int l = start;
        int end = s.length() - 1;
        int r = end;
        while (l <= r) {
            if (s.charAt(l) != s.charAt(r)) {
                r = --end;
                l = start;
            } else {
                l++;
                r--;
            }
        }
        if (end - start + 1 > max.length()) {
            return s.substring(start, end + 1);
        }
        return max;
    }

    /**
     * 动态规划法：基于假设，如果s[i+1..j-1]是回文串，当且仅当s[i]==s[j]成立时，
     * s[i..j]也是回文串
     *
     * 时间复杂：O(N^2)
     * 空间复杂度：O(N^2)
     */
    public static String longestPalindrome_DP(String s) {
        int length = s.length();
        if (length <= 1) {
            return s;
        }

        int maxLen = 1, begin = 0;
        // dp[i][j]表示s[i..j]是否为回文串
        boolean[][] dp = new boolean[length][length];
        // 初始化长度为1的子串都是回文串
        for (int i = 0; i < length; i++) {
            dp[i][i] = true;
        }
        char[] charArray = s.toCharArray();

        for (int l = 2; l <= length; l++) {
            // i为左边界
            for (int i = 0; i < length - l + 1; i++) {
                // j为右边界
                int j = l + i - 1;
                if (charArray[i] != charArray[j]) {
                    dp[i][j] = false;
                } else {
                    // 长度为2的回文串，例如aa, bb
                    if (l == 2) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                    // 更新回文串的长度
                    if (dp[i][j] && j - i + 1 > maxLen) {
                        maxLen = j - i + 1;
                        begin = i;
                    }
                }

            }
        }
        return s.substring(begin, begin + maxLen);
    }

    /**
     * 回文中心扩展算法：状态转换方程                         <br>
     * 1. P(i, i) = true                                <br>
     * 2. P(i, i + 1) = (S[i] == S[i+1])                <br>
     * 3. P(i, j) = P(i + 1, j - 1) ^ (S[i] == S[j])    <br>
     *
     * 状态转换：
     * P(i, j) <- P(i + 1, j - 1) <- P(i + 2, j - 2) <- ...
     *                                                  <br>
     *
     * 所有的状态在转移的时候可能性都是唯一的                  <br>
     *
     * 时间复杂度：O(N^2)，空间复杂度：O(1)
     */
    public static String longestPalindrome_expandAroundCenter(String s) {
        if (s.length() <= 1) {
            return s;
        }
        int start = 0, end = 1;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = (i + len / 2) + 1;
            }
        }
        return s.substring(start, end);
    }

    private static int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }

    /**
     * Manacher 算法
     *
     * 时间复杂度O(N)，空间复杂度O(N)
     */
    public static String longestPalindrome(String s) {
        if (s.length() <= 1) {
            return s;
        }
        // 补充特殊字符#，使字符串的长度变为奇数
        // aa -> #a#a#, aba -> #a#b#a#
        StringBuilder sb = new StringBuilder(s.length() * 2 + 1);
        for (int i = 0; i < s.length(); i++) {
            sb.append('#');
            sb.append(s.charAt(i));
        }
        sb.append('#');
        s = sb.toString();

        List<Integer> armLen = new ArrayList<>(s.length());
        int start = 0, end = 0;
        int right = -1, j = -1;
        for (int i = 0; i < s.length(); i++) {
            int curArmLen;
            if (right > i) {
                int i_sym = j * 2 - i;
                int minArmLen = Math.min(armLen.get(i_sym), right - i);
                curArmLen = expand(s, i - minArmLen, i + minArmLen);
            } else {
                curArmLen = expand(s, i, i);
            }
            armLen.add(curArmLen);
            if (i + curArmLen > right) {
                j = i;
                right = i + curArmLen;
            }
            if (curArmLen * 2 > end - start) {
                start = i - curArmLen;
                end = i + curArmLen;
            }
        }

        sb.setLength(0);
        for (int i = start; i <= end; i++) {
            if (s.charAt(i) != '#') {
                sb.append(s.charAt(i));
            }
        }
       return sb.toString();
    }

    private static int expand(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return (right - left - 2) / 2;
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("bb")); // bb
        System.out.println(longestPalindrome("bacabab")); // bacab
        System.out.println(longestPalindrome("babad")); // bab
        System.out.println(longestPalindrome("cbbd")); // bb
        System.out.println(longestPalindrome("a")); // a
        System.out.println(longestPalindrome("ac")); // a
    }

}
