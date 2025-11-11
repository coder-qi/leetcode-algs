import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 474. 一和零：https://leetcode.cn/problems/ones-and-zeroes
 */
public class OnesAndZeroes {

    public int findMaxForm(String[] strs, int m, int n) {
        Map<String, int[]> countMap = new HashMap<>();
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
        int[][][] memo = new int[strs.length][m + 1][n + 1];
        for (int[][] matrix : memo) {
            for (int[] arr : matrix) {
                Arrays.fill(arr, -1);
            }
        }
        return dfs(0, strs, countMap, m, n, memo);
    }

    private int dfs(int index, String[] strs, Map<String, int[]> countMap, int m, int n, int[][][] memo) {
        if (index == strs.length) {
            return 0;
        }
        if (memo[index][m][n] != -1) {
            return memo[index][m][n];
        }
        int res = dfs(index + 1, strs, countMap, m, n, memo);
        int[] count = countMap.get(strs[index]);
        if (m >= count[0] && n >= count[1]) {
            res = Math.max(res, dfs(index + 1, strs, countMap, m - count[0], n - count[1], memo) + 1);
        }

        return memo[index][m][n] = res;
    }

}
