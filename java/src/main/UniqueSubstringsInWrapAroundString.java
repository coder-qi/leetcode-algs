import java.util.Arrays;

/**
 * 467. 环绕字符串中唯一的子字符串：https://leetcode.cn/problems/unique-substrings-in-wraparound-string/
 */
public class UniqueSubstringsInWrapAroundString {

    public static int findSubstringInWraproundString(String p) {
        int[] dp = new int[26];
        int k = dp[p.charAt(0) - 'a'] = 1;
        for (int i = 1; i < p.length(); i++) {
            int d = p.charAt(i) - p.charAt(i - 1);
            if ((d + 26) % 26 == 1) { // d为1或者-25，例a-b或者z-a
                k++;
            } else {
                k = 1;
            }
            dp[p.charAt(i) - 'a'] = Math.max(dp[p.charAt(i) - 'a'], k);
        }
        return Arrays.stream(dp).sum();
    }

    public static void main(String[] args) {
        System.out.println(findSubstringInWraproundString("a")); // 1
        System.out.println(findSubstringInWraproundString("cac")); // 2
        System.out.println(findSubstringInWraproundString("zab")); // 6
    }

}
