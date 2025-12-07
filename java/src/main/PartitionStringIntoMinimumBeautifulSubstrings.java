import java.util.Arrays;
import java.util.Set;

/**
 * 2767. 将字符串分割为最少的美丽子字符串：https://leetcode.cn/problems/partition-string-into-minimum-beautiful-substrings
 */
public class PartitionStringIntoMinimumBeautifulSubstrings {

    static final Set<String> FIVES = Set.of(
            "1",
            "101",
            "11001",
            "1111101",
            "1001110001",
            "110000110101",
            "11110100001001"
    );

    public int minimumBeautifulSubstrings(String s) {
        int n = s.length();
        int[] dp = new int[n + 1];
        Arrays.fill(dp, n);
        dp[0] = 0;
        for (int right = 0; right < n; right++) {
            if (s.charAt(right) == '0') {
                continue;
            }
            if (FIVES.contains(s.substring(0, right + 1))) {
                dp[right + 1] = 0;
                continue;
            }
            dp[right + 1] = n;
            for (int left = 1; left <= right; left++) {
                if (dp[left] == n) {
                    continue;
                }
                if (FIVES.contains(s.substring(left, right + 1))) {
                    dp[right + 1] = Math.min(dp[right + 1], dp[left] + 1);
                }
            }
        }
        return dp[n] == n ? -1 : dp[n] + 1;
    }

    public static void main(String[] args) {
        /*for (int i = 0; i < 20; i++) {
            int val = (int) Math.pow(5, i);
            String s = Integer.toBinaryString(val);
            System.out.println(s.length() + ": " + val + ":" + s);
        }*/
    }

}
