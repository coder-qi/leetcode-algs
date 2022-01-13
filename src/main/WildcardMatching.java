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

    /**
     * 贪心算法：单独匹配非*的每一个子串，类似于*u1*u2*u3*u4*，只看u1等子串是否能匹配
     */
    public static boolean isMatch(String s, String p) {
        int sRight = s.length(), pRight = p.length();
        // 处理模式的右侧非*部分的匹配情况
        while (sRight > 0 && pRight > 0 && p.charAt(pRight - 1) != '*') {
            if (matchChar(s.charAt(sRight - 1), p.charAt(pRight - 1))) {
                sRight--;
                pRight--;
            } else {
                return false;
            }
        }

        // 模式字符串消耗完了，只需要看s是否消耗完了
        if (pRight == 0) {
            return sRight == 0;
        }

        int sIndex = 0, pIndex = 0;
        int sRecord = -1, pRecord = -1;
        while (sIndex < sRight && pIndex < pRight) {
            if (p.charAt(pIndex) == '*') {
                pIndex++;
                sRecord = sIndex;
                pRecord = pIndex;
            } else if (matchChar(s.charAt(sIndex), p.charAt(pIndex))) {
                sIndex++;
                pIndex++;
            } else if (sRecord != -1 && sRecord + 1 < sRight) {
                sRecord++;
                sIndex = sRecord;
                pIndex = pRecord;
            } else {
                return false;
            }
        }
        return allStars(p, pIndex, pRight);
    }

    private static boolean allStars(String str, int left, int right) {
        while (left < right) {
            if (str.charAt(left) != '*') {
                return false;
            }
            left++;
        }
        return true;
    }

    private static boolean matchChar(char u, char v) {
        return u == v || v == '?';
    }

    public static void main(String[] args) {
        System.out.println(isMatch("aa", "a")); // false
        System.out.println(isMatch("aa", "*")); // true
        System.out.println(isMatch("cb", "?a")); // false
        System.out.println(isMatch("adceb", "*a*b")); // true
        System.out.println(isMatch("acdcb", "a*c?b")); // false
    }

}
