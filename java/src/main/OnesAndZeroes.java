import java.util.HashMap;
import java.util.Map;

/**
 * 474. 一和零：https://leetcode.cn/problems/ones-and-zeroes
 */
public class OnesAndZeroes {

    public int findMaxForm(String[] strs, int m, int n) {
        Map<String, int[]> countMap = new HashMap<>(strs.length);
        for (String str : strs) {
            int zeroCount = 0;
            int onesCount = 0;
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == '0') {
                    zeroCount++;
                } else {
                    onesCount++;
                }
            }
            countMap.put(str, new int[]{zeroCount, onesCount});
        }
        int[][][] dp = new int[strs.length + 1][m + 1][n + 1];
        for (int i = strs.length - 1; i >= 0; i--) {
            int[] count = countMap.get(strs[i]);
            for (int j = 0; j <= m; j++) {
                for (int k = 0; k <= n; k++) {
                    int res = dp[i + 1][j][k];
                    if (j >= count[0] && k >= count[1]) {
                        res = Math.max(res, dp[i + 1][j - count[0]][k - count[1]] + 1);
                    }
                    dp[i][j][k] = res;
                }
            }
        }
        return dp[0][m][n];
    }

}
